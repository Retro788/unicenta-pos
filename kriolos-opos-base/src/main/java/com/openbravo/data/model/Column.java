// ..

package com.openbravo.data.model;

/**
 *
 * @author adrian
 */
public class Column {
    
    private String name;
    
    /**
     *
     * @param name
     */
    public Column(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }
    
    /**
     *
     * @return
     */
    public boolean isPK() {
        return false;
    }
}
