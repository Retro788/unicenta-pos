// ..

package com.openbravo.pos.inventory;

import com.openbravo.data.loader.IKeyed;

//file format
public class AttributeSetInfo implements IKeyed {

    private String id;
    private String name;

    /**
     *
     * @param id
     * @param name
     */
    public AttributeSetInfo(String id, String name) {
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

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
