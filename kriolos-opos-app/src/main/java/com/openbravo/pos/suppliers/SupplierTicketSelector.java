// ..

package com.openbravo.pos.suppliers;

import com.openbravo.basic.BasicException;
import java.awt.Component;
import java.awt.event.ActionListener;

/**
 *
 * @author JG uniCenta - outline/prep for  eCommerce connector
 */
public interface SupplierTicketSelector {

    /**
     *
     * @throws BasicException
     */
    public void loadSupplierss() throws BasicException;

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