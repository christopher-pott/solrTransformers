package org.smk.solr.transformer.fullexport;

import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.smk.solr.transformer.generic.Util;

public class Process_titles{

	protected final static Logger log = Logger .getLogger(Process_titles.class);

	/**
	 * @throws JSONException 
	 * 
	 **/            
	public Object transformRow(Map<String, Object> row){
		if(log.isDebugEnabled())
			log.debug(String.format("--------\r\nstart Process_titles - csid:%s", (String) row.get("csid")));

		if ((String)row.get("title_all") == null)
			return row;

		String[] titles_split = ((String) row.get("title_all")).split(Util.split_1_niv);                      				
		int arrayLength = titles_split.length;        
		        
		String title_data_first = new String();      	// first title in the list (whatever language is)   	
		String title_dk_with_notes = new String(); 	// first danish title with notes and translations
		String titles_data_en = new String();					// first english translation for the first title					            		

		for(int i = 0; i < arrayLength; i++) {         
			String[] values = titles_split[i].split(Util.split_2_niv);			         			      					
			String title = Util.getValueFromSplit(values, 0);
			String note = Util.getValueFromSplit(values, 1);
			String lang = Util.getValueFromSplit(values, 2);
			String translated = Util.getValueFromSplit(values, 3);

			//* process translated titles for all titles
			ArrayList<String> translations_all_lang = new ArrayList<String> ();			
			if(Util.isValidDataText(translated)){				
				String[] split_trans = translated.split(Util.split_3_niv);	

				for (int j = 0; j < split_trans.length; j++) {	
					String lang_trans = Util.getValueFromSplit(split_trans[j].split(Util.split_4_niv), 0);            	
					translations_all_lang.add(lang_trans);          	            
				}            
			}          

			String title_orig_with_notes = String.format("%s%s%s%s%s", title, Util.split_2_niv, note, Util.split_2_niv, StringUtils.join(translations_all_lang, Util.split_3_niv));

			if(i == 0){
				title_data_first = title_orig_with_notes;

				//* process translated titles FOR THE FIRST TITLE ONLY
				String[] titles_en_split = translated != null ? translated.split(Util.split_3_niv) : new String[0];

				for (int j = 0; j < titles_en_split.length; j++) {
					String[] trans_values = titles_en_split[i].split(Util.split_4_niv);			         			      																	
					String trans_title = Util.getValueFromSplit(trans_values, 0);	
					String trans_lang = Util.getValueFromSplit(trans_values, 1);	

					if(trans_lang != null && trans_lang.indexOf("engelsk") > -1){
						titles_data_en = trans_title;
						break;
					}						
				}
			}            

			if(lang != null && lang.indexOf("dansk") > -1 && title_dk_with_notes.equals("") )
				title_dk_with_notes = title_orig_with_notes;   							// first danish title with notes and translations						

		}                                                                                                        

		//* copy data back into solr's fields
		row.put("title_first", Util.getValueFromSplit(title_data_first.split(Util.split_2_niv), 0));             // first title in the list (whatever language is)		         

		if (Util.isValidDataText(title_dk_with_notes))
			row.put("title_dk", Util.getValueFromSplit(title_dk_with_notes.split(Util.split_2_niv), 0));  			// first danish title                   		
		
		if (Util.isValidDataText(titles_data_en)) 
			row.put("title_eng", titles_data_en);                                  // first english title for the first title
		

		if(log.isDebugEnabled())
			log.debug(String.format("finish Process_titles - csid:%s\r\n--------------", (String) row.get("csid")));

		return row;		

	}		
}
