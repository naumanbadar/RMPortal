package org.ow2.proactive_grid_cloud_portal.shared.property;


abstract public class Property {
    public enum Type {
        STRING, INTEGER, BOOLEAN;
    }

    final String name;
    final Type type;
    String value;

    Property(String name, Type type) {
        this.name = name;
        this.type = type;
        this.value = getDefaultValue();
    }
    
    Property(String name, Type type, String value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    /**
     * Returns the key associated to this property
     * @return the key associated to this property
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns this property type
     * @return The type of this property
     */
    public Type getType() {
        return this.type;
    }
    
    /**
     * Returns true if and only if the property is
     * of the type <code>type</code>
     * 
     * @param type
     * @return true if and only if the property is
     * of the type <code>type</code>
     */
    public boolean isOfType(Type type) {
    	return this.getType() == type;
    }

    /**
     * Returns the value of this property
     * @return the value of this property
     */
    public String getValueAsString() {
    	return this.value;
    }

    /**
     * Set the value of this property
     * @param value new value of the property
     */
    public void setValue(String value) {
    	this.value = value;
    }

    /**
     * Check if the value is valid for this property
     * @param value a property value
     * @return true if and only if the value is valid for this property type
     */
    public abstract boolean isValid(String value);
    
    public abstract String getDefaultValue();
    
    public abstract Object getValue();

    @Override
    public String toString() {
        return getValueAsString();
    }
}
