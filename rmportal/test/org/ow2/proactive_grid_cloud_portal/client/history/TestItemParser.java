package org.ow2.proactive_grid_cloud_portal.client.history;

import org.ow2.proactive_grid_cloud_portal.client.history.ItemParser;
import junit.framework.TestCase;

public class TestItemParser extends TestCase {

	@org.junit.Test
	public void testPath() {
		testPath("", "");
		testPath("path", "path");
		testPath("path?", "path");
		testPath("path?param1=value1", "path");
		testPath("path?param1=value1&param2=value2&param3=value3", "path");
		
	}
	
	public void testPath(String item, String expectedPath) {
		ItemParser itemParser = new ItemParser(item);
		String path= itemParser.getPath();
		assertEquals(expectedPath, path);
	}
	
	@org.junit.Test
	public void testParamNumber() {
		testParamNumber("", 0);
		testParamNumber("path", 0);
		testParamNumber("path?", 0);
		testParamNumber("path?param1=value1", 1);
		testParamNumber("path?param1=value1&param2=value2&param3=value3", 3);
		
	}
	
	public void testParamNumber(String item, int expectedNumber) {
		ItemParser itemParser = new ItemParser(item);
		int n = itemParser.getParameterNumber();
		assertEquals(expectedNumber, n);
	}
	
	@org.junit.Test
	public void testParam() {
		testParam("path", "param1", null);
		testParam("path?", "param1", null);
		testParam("path?param1=value1", "param2", null);
		testParam("path?param1=value1", "param1", "value1");
		testParam("path?param1=value1&param2=value2&param3=value3", "param3", "value3");
		testParam("path?param1=value1&param2=&param3=value3", "param2", "");
	}
	
	public void testParam(String item, String parameterName, String expectedParamValue) {
		ItemParser itemParser = new ItemParser(item);
		String paramValue = itemParser.getParameterValue(parameterName);
		assertEquals(expectedParamValue, paramValue);
	}

	@org.junit.Test
	public void testContainsParam() {
		testContainsParam("path", "param1", false);
		testContainsParam("path?", "param1", false);
		testContainsParam("path?param1=value1", "param2", false);
		testContainsParam("path?param1=value1", "param1", true);
	}
	
	public void testContainsParam(String item, String parameterName, boolean expectedHasParam) {
		ItemParser itemParser = new ItemParser(item);
		boolean hasParam = itemParser.containsParameter(parameterName);
		assertEquals(expectedHasParam, hasParam);
	}
}