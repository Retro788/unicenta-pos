// ..

package com.openbravo.pos.businesspartner;

import com.openbravo.pos.domain.entity.businesspartner.BusinessPartner;
import com.openbravo.pos.resources.ImageResources;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JList;

/**
 *
 * @author JG uniCenta, poolborges
 */
public class BusinessPartnerListCellRenderer<BusinessPartner> extends DefaultListCellRenderer {
                
    private final Icon icon;

    /** 
     * Creates a new instance of CustomerRenderer 
     */
    public BusinessPartnerListCellRenderer() {

        icon = ImageResources.ICON_CUSTOMER.getIcon();
        
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, 
            int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, null, index, isSelected, cellHasFocus);

        setIcon(icon);
        setText(value.toString());
        
        return this;
    }      
}
