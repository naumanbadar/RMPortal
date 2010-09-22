package org.ow2.proactive_grid_cloud_portal.client.history;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * @author The ProActive Team
 *
 * Item parser class used for history management.
 * Example:
 * 
 * <code>
 * String item = "hello?firstname=ProActive&name=Team"
 * ItemParser parser = new ItemParser(item);
 * 
 * String path = parser.getPath(); // should be equals to "hello"
 * String query = parser.getQuery(); // should be equals to "firstname=ProActive&name=Team"
 * boolean hasName = parser.containsParameter("name"); // should be equals to true
 * Sting nameValue = parser.getParameterValue("name");
 * </code>
 */
public class ItemParser {

	private String item;
	private String path;
	private String query;
	private Map<String, String> params;
	
	/**
	 * Constructor
	 * Sets the item value and parses it.
	 * 
	 * @param item
	 */
	public ItemParser(String item) {
		this.item = item;
		parse();
	}
	
	/**
	 * Parses <code>this.item</code>
	 * Assuming <code>this.item = "path?param1=value1&param2=value2"</code>, 
	 * then, <code>this.path</code> will contain <code>"path"</code>,
	 * <code>this.query</code> will contain <code>param1=value1&param2=value2</code>
	 * and <code>this.params</code> will contain the following pairs:
	 * <code>(param1, value1)</code> and <code>(param2, value2)</code>.
	 */
	public void parse() {
		this.params = new HashMap<String, String>();
		
		String[] splittedItem = this.item.split("\\?", 2);
		path = splittedItem[0];
		
		if (splittedItem.length < 2) {
			query = "";
			return;
		}
		
		this.query = splittedItem[1];
		if ("".equals(this.query))
			return;
		
		String[] parameters = this.query.split("&");
		
		for (String pair : parameters) {
			String[] param = pair.split("=", 2);
			this.params.put(param[0], param[1]);
		}
	}
	

	/**
	 * @return the complete item
	 */
	public String getItem() {
		return this.item;
	}
	
	/**
	 * @return the path of the item (String before '?')
	 */
	public String getPath() {
		return this.path;
	}
	
	/**
	 * @return the query of the item (String after '?')
	 */
	public String getQuery() {
		return this.query;
	}
	
	/**
	 * @return the number of parameters
	 */
	public int getParameterNumber() {
		return this.params.size();
	}
	
	/**
	 * Converts the map of parameters to an array of String pairs and returns it.
	 * For efficiency purpose, this array of array is of the form of
	 * <code>String[2][parameters number]</code>
	 * 
	 * @return the parameters in a form of an array of String pairs.
	 */
	public String[][] getParameters() {
	
		String[][] result = new String[2][this.params.size()];
		
		Set<Entry<String, String>> entries = this.params.entrySet();
		int i = 0;
		for (Entry<String, String> entry : entries) {
			result[0][i] = entry.getKey();
			result[1][i] = entry.getValue();
		}
		
		return result;
	}
	
	/**
	 * Gets the Value of a corresponding parameter
	 * 
	 * @param parameterName
	 * @return the value of <code>parameterName</code>
	 */
	public String getParameterValue(String parameterName) {
		return this.params.get(parameterName);
	}
	
	/**
	 * @return the array of parameter names
	 */
	public String[] getParameterNames() {
		return this.params.keySet().toArray(new String[]{});
	}
	
	/**
	 * @param parameterName
	 * @return True if and only if the item contains a parameter
	 * whose name is <code>parameterName</code>
	 */
	public boolean containsParameter(String parameterName) {
		return this.params.containsKey(parameterName);
	}
}
