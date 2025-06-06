// ..

package com.openbravo.pos.inventory;

import com.openbravo.data.loader.IKeyed;

/**
 *
 * @author  adrianromero
 */
public class AttributeInfo implements IKeyed {

    private String id;
    private String name;

    /** Creates new CategoryInfo
     * @param id
     * @param name */
    public AttributeInfo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     *
     * @return
     */
    @Override
    public Object getKey() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}
