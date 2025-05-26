// ..

package com.openbravo.pos.catalog;

import com.openbravo.basic.BasicException;
import java.awt.Component;
import java.awt.event.ActionListener;

//file format
public interface CatalogSelector {
    
    /**
     *
     * @throws BasicException
     */
    public void loadCatalog() throws BasicException;

    /**
     *
     * @param id
     */
    public void showCatalogPanel(String id);

    /**
     *
     * @param value
     */
    public void setComponentEnabled(boolean value);

    /**
     *
     * @return
     */
    public Component getComponent();
    
    /**
     *
     * @param l
     */
    public void addActionListener(ActionListener l);  

    /**
     *
     * @param l
     */
    public void removeActionListener(ActionListener l);    
}
