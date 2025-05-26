// ..

package com.openbravo.data.model;

/**
 *
 * @author adrian
 */
public class PrimaryKey extends Column {
    
    /**
     *
     * @param name
     */
    public PrimaryKey(String name) {
        super(name);
    }
    
    /**
     *
     * @return
     */
    @Override
    public boolean isPK() {
        return true;
    }
}
