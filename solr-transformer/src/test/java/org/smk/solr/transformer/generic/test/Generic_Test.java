package org.smk.solr.transformer.generic.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.smk.solr.transformer.generic.*;

public class Generic_Test {

	@Test
	public void test_Util_codepoint(){
		String test = "udført";
		String expected = "udfU+F8rt";
		String res = Util.codepoints(test);
		org.junit.Assert.assertEquals(res, expected);
	}
		
	@Test
	public void test_Util_capitalize(){
		String test = "åben";
		String expected = "Åben";
		String res = Util.firstUpper(test);
		org.junit.Assert.assertEquals(res, expected);
	}

	@Test
	public void test_Util_isValidDataText(){
		String test = "coco";
		Boolean res = Util.isValidDataText(test);
		org.junit.Assert.assertTrue(res);
		test = "original";
		res = Util.isValidDataText(test, "role");
		org.junit.Assert.assertTrue(!res);

	}

	@Test
	public void test_Util_isPersonData(){
		String[] test = {"person", "2", "frfr"};
		Boolean res = Util.isPersonData(test);
		org.junit.Assert.assertTrue(!res);
		test = new String[]{"original"};
		res = Util.isPersonData(test, "producent");
		org.junit.Assert.assertTrue(!res);
		test = new String[]{"person"};
		res = Util.isPersonData(test, "producent");
		org.junit.Assert.assertTrue(res);

	}
	
	@Test
	public void test_Process_location(){
		Map<String, Object> row = new HashMap();
		Map<String, Object> rowmodif = new HashMap();
		String teststring = "sAl 201";
		row.put("location_name", teststring);
		Process_location transf = new Process_location();
		rowmodif = (Map<String, Object>) transf.transformRow(row);
		org.junit.Assert.assertEquals(teststring, rowmodif.get("location_name"));

		teststring = "magasin 201";
		row.put("location_name", teststring);		
		rowmodif = (Map<String, Object>) transf.transformRow(row);
		org.junit.Assert.assertEquals(null, rowmodif.get("location_name"));	
	}

	@Test
	public void test_Process_multi_works(){
		Map<String, Object> row = new HashMap();
		Map<String, Object> rowmodif = new HashMap();
		String teststring = "Udklip på papir med kvindetegnet;--;KKS1984-23;--;parent;-;Udklip på papir med kvindetegnet;--;KKS1984-23/1;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/10;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/100;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/101;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/102;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/103;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/104;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/105;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/106;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/107;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/108;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/109;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/11;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/110;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/111;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/112;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/113;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/114;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/115;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/116;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/117;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/118;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/119;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/12;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/120;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/121;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/122;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/123;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/124;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/125;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/126;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/127;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/128;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/129;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/13;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/130;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/131;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/132;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/133;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/134;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/135;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/136;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/137;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/138;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/139;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/14;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/140;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/141;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/142;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/143;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/144;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/145;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/146;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/147;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/148;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/149;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/15;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/150;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/151;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/152;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/153;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/154;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/155;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/156;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/157;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/158;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/159;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/16;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/160;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/161;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/162;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/163;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/164;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/165;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/166;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/167;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/168;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/169;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/17;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/170;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/171;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/172;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/173;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/174;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/175;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/176;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/177;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/178;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/179;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/18;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/180;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/181;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/182;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/183;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/184;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/185;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/186;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/187;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/188;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/189;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/19;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/190;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/191;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/192;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/193;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/194;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/195;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/196;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/197;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/198;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/199;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/2;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/20;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/200;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/201;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/202;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/203;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/204;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/205;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/206;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/207;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/208;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/209;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/21;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/210;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/211;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/212;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/213;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/214;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/215;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/216;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/217;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/218;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/219;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/22;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/220;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/221;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/222;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/223;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/224;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/225;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/226;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/227;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/228;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/229;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/23;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/230;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/231;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/232;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/233;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/234;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/235;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/236;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/237;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/238;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/239;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/24;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/240;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/241;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/242;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/243;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/244;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/245;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/246;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/247;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/248;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/249;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/25;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/250;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/251;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/252;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/253;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/254;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/255;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/256;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/257;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/258;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/259;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/26;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/260;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/261;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/262;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/263;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/264;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/265;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/266;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/267;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/268;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/269;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/27;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/270;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/271;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/272;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/273;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/274;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/275;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/276;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/277;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/278;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/279;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/28;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/280;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/281;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/282;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/283;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/284;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/285;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/286;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/287;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/288;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/289;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/29;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/290;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/291;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/292;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/293;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/294;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/295;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/296;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/297;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/298;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/299;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/3;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/30;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/300;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/301;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/302;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/303;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/304;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/305;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/306;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/307;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/308;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/309;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/31;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/310;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/311;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/312;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/313;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/314;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/315;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/316;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/317;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/318;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/319;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/32;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/320;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/321;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/322;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/323;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/324;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/325;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/326;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/327;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/328;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/329;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/33;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/330;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/331;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/332;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/333;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/334;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/335;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/336;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/337;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/338;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/339;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/34;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/340;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/341;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/342;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/343;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/344;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/345;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/346;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/347;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/348;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/349;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/35;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/350;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/351;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/352;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/353;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/354;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/355;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/356;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/357;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/358;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/359;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/36;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/360;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/361;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/362;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/363;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/364;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/365;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/366;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/367;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/368;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/369;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/37;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/370;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/371;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/372;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/373;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/374;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/375;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/376;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/377;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/378;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/379;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/38;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/380;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/381;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/382;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/383;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/384;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/385;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/386;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/387;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/388;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/389;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/39;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/390;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/391;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/392;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/393;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/394;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/395;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/396;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/397;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/398;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/399;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/4;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/40;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/400;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/401;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/402;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/403;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/404;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/405;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/406;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/407;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/408;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/409;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/41;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/410;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/411;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/412;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/413;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/414;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/415;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/416;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/417;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/418;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/419;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/42;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/420;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/421;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/422;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/423;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/424;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/425;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/426;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/427;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/428;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/429;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/43;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/430;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/431;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/432;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/433;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/434;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/435;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/436;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/437;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/438;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/439;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/44;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/440;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/441;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/442;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/443;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/444;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/445;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/446;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/447;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/448;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/449;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/45;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/450;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/451;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/452;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/453;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/454;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/455;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/456;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/457;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/458;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/459;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/46;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/460;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/461;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/462;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/463;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/464;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/465;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/466;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/467;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/468;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/469;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/47;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/470;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/471;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/472;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/473;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/474;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/475;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/476;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/477;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/478;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/479;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/48;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/480;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/481;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/482;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/483;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/484;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/49;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/5;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/50;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/51;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/52;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/53;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/54;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/55;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/56;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/57;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/58;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/59;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/6;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/60;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/61;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/62;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/63;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/64;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/65;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/66;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/67;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/68;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/69;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/7;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/70;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/71;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/72;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/73;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/74;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/75;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/76;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/77;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/78;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/79;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/8;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/80;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/81;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/82;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/83;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/84;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/85;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/86;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/87;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/88;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/89;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/9;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/90;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/91;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/92;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/93;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/94;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/95;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/96;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/97;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/98;--;sibling;-;Udklip på papir med kvindetegnet;--;KKS1984-23/99;--;sibling";
		String testid = "KMS11";
		row.put("multi_work_ref", teststring);
		row.put("id", testid);
		Process_multi_works transf = new Process_multi_works();
		rowmodif = (Map<String, Object>) transf.transformRow(row);
		String[] multi_works_split = ((String) rowmodif.get("multi_work_ref")).split(Util.split_1_niv);		
		org.junit.Assert.assertEquals("Udklip på papir med kvindetegnet;--;KKS1984-23/100;--;sibling", multi_works_split[100]);

		row.remove("multi_work_ref");		
		transf = new Process_multi_works();
		rowmodif = (Map<String, Object>) transf.transformRow(row);
		String newid = (String) rowmodif.get("id");		
		org.junit.Assert.assertEquals(testid, newid);
	}

	@Test
	public void test_Process_related_works(){
		Map<String, Object> row = new HashMap();
		Map<String, Object> rowmodif = new HashMap();
		String teststring = "Stående Artemis, som støtter venstre arm på arkaistisk Idol;--;KAS382;-;Kvinde, der læner sig til pille under venstre armhule. Afrodite i haverne;--;KAS2349;-;Original til KAS : Afrodite stående lænet til lille arkaistisk statue;--;ORIG40";
		teststring  = "Original til KAS : Abraham giver tiende til Melkisedek i (Jeru-)Salem. Del af predella til altertavle;--;ORIG1;-;Titanernes fald;--;KAStest(KMS1);-;De fire himmelstormere - Ikaros;--;KKSgb1045";
		row.put("related_id", teststring);
		Process_origin transf = new Process_origin();
		rowmodif = (Map<String, Object>) transf.transformRow(row);
		String orig = ((String) rowmodif.get("related_works_orig_number"));		
		org.junit.Assert.assertEquals("ORIG1", orig);		
	}

	@Test
	public void test_Process_producents(){
		Map<String, Object> row = new HashMap();
		Map<String, Object> rowmodif = new HashMap();
		String teststring = "person;--;tidl. tilskrevet;--;Maria Sibylla Merian;--;1647;--;02-04-1647;--;1647-04-02;--;1717;--;13-01-1717;--;1717-01-13;--;Tysk;--;German;-;person;--;forfatter/redaktør;--;Hans Simon Holtzbecker;--;1620;--;1610-1620;--;1610-1620;--;1671;--;1671;--;1671;--;Tysk;--;German";
		row.put("producents_data", teststring);
		row.put("id", "KMS1");
		Process_producents transf = new Process_producents();
		rowmodif = (Map<String, Object>) transf.transformRow(row);
		ArrayList<String>  artist_name = ((ArrayList<String> ) rowmodif.get("artist_name"));
		ArrayList<String>  artist_birth_en = ((ArrayList<String> ) rowmodif.get("artist_birth_en"));
		ArrayList<String>  artist_birth_dk = ((ArrayList<String> ) rowmodif.get("artist_birth_dk"));
		ArrayList<String>  artist_death_en = ((ArrayList<String> ) rowmodif.get("artist_death_en"));
		ArrayList<String>  artist_death_dk = ((ArrayList<String> ) rowmodif.get("artist_death_dk"));
		ArrayList<String>  artist_natio = ((ArrayList<String> ) rowmodif.get("artist_natio"));
		ArrayList<String>  artist_natio_en = ((ArrayList<String> ) rowmodif.get("artist_natio_en"));
		ArrayList<String>  artist_auth = ((ArrayList<String> ) rowmodif.get("artist_auth"));		   		

		org.junit.Assert.assertEquals("Maria Sibylla Merian", artist_name.get(0));
		org.junit.Assert.assertEquals("02-04-1647", artist_birth_dk.get(0));
		org.junit.Assert.assertEquals("1647-04-02", artist_birth_en.get(0));
		org.junit.Assert.assertEquals("13-01-1717", artist_death_dk.get(0));
		org.junit.Assert.assertEquals("1717-01-13", artist_death_en.get(0));
		org.junit.Assert.assertEquals("Tysk", artist_natio.get(0));
		org.junit.Assert.assertEquals("German", artist_natio_en.get(0));
		org.junit.Assert.assertEquals("tidl. tilskrevet", artist_auth.get(0));		
		
		teststring = "person;--;;--;Hans Simon Holtzbecker;--;1620;--;1610-1620;--;1610-1620;--;1671;--;1671;--;1671;--;Tysk;--;German;-;person;--;tidl. tilskrevet;--;Maria Sibylla Merian;--;1647;--;02-04-1647;--;1647-04-02;--;1717;--;13-01-1717;--;1717-01-13;--;Tysk;--;German";
		row.put("producents_data", teststring);		
		rowmodif = (Map<String, Object>) transf.transformRow(row);
		artist_auth = ((ArrayList<String> ) rowmodif.get("artist_auth"));	
		org.junit.Assert.assertEquals("original", artist_auth.get(0));
		
		
		teststring = "person;--;;--;Günter Brus;--;1938;--;27.september 1938 ;--;27th September 1938 ;--;;--;;--;;--;Østrigsk;--;;-;person;--;forfatter/redaktør;--;Günter Brus;--;1938;--;27.september 1938 ;--;27th September 1938 ;--;;--;;--;;--;Østrigsk;--;";
		row.put("producents_data", teststring);		
		rowmodif = (Map<String, Object>) transf.transformRow(row);
		artist_auth = ((ArrayList<String> ) rowmodif.get("artist_auth"));	
		org.junit.Assert.assertEquals("original", artist_auth.get(0));
		
		
		teststring = "person;--;;--;Ubekendt;--;;--;;--;;--;;--;;--;;--;;--;";
		row.put("producents_data", teststring);		
		rowmodif = (Map<String, Object>) transf.transformRow(row);
		artist_auth = ((ArrayList<String> ) rowmodif.get("artist_auth"));	
		org.junit.Assert.assertEquals("original", artist_auth.get(0));		
		
	}

	@Test
	public void test_Process_titles(){
		Map<String, Object> row = new HashMap();
		Map<String, Object> rowmodif = new HashMap();
		String teststring = "De tyske byers underkastelse;--;Titel oversat fra Veldman (The New Hollstein);--;urn:cspace:smk.dk:vocabularies:name(languages):item:name(dansk)'dansk';--;trans_eng;-v;engelsk;-;The submission of the German cities;--;Eng. titel som hos Veldman (The New Hollstein);--;urn:cspace:smk.dk:vocabularies:name(languages):item:name(engelsk)'engelsk';--;;-v;;-;Kejser Karl V's sejre;--;Titel oversat fra Veldman (The New Hollstein);--;urn:cspace:smk.dk:vocabularies:name(languages):item:name(dansk)'dansk';--;trans_eng;-v;engelsk;-;The victories of Emperor Charles V;--;Eng. titel som hos Veldman (The New Hollstein);--;urn:cspace:smk.dk:vocabularies:name(languages):item:name(engelsk)'engelsk';--;;-v;";
		row.put("title_all", teststring);
		Process_titles transf = new Process_titles();
		rowmodif = (Map<String, Object>) transf.transformRow(row);
		String title_first = ((String) rowmodif.get("title_first"));		
		org.junit.Assert.assertEquals("De tyske byers underkastelse", title_first);
		String title_first_note = ((String) rowmodif.get("title_first_with_note")).split(Util.split_2_niv)[1];		
		org.junit.Assert.assertEquals("Titel oversat fra Veldman (The New Hollstein)", title_first_note);	
		String title_eng = ((String) rowmodif.get("title_eng"));		
		org.junit.Assert.assertEquals("trans_eng", title_eng);	
		
		
		teststring = "Udklip på papir med kvindetegnet;--;;--;urn:cspace:smk.dk:vocabularies:name(languages):item:name(dansk)'dansk';--;";
		row.put("title_all", teststring);
		transf = new Process_titles();
		rowmodif = (Map<String, Object>) transf.transformRow(row);
		title_first = ((String) rowmodif.get("title_first"));		
		org.junit.Assert.assertEquals("Udklip på papir med kvindetegnet", title_first);
	
		String title_dk = ((String) rowmodif.get("title_dk"));		
		org.junit.Assert.assertEquals("Udklip på papir med kvindetegnet", title_dk);

		
		
	}

	      



}
