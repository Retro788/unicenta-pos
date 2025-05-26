// ..

package com.openbravo.pos.sales;

import java.awt.Component;

//file format
public interface JProductAttEditI {

    /**
     *
     * @return
     */
    public String getAttribute();

    /**
     *
     * @return
     */
    public String getValue();

    /**
     *
     * @return
     */
    public Component getComponent();

    /**
     *
     */
    public void assignSelection();
}
