// ..

package com.openbravo.pos.epm;

import com.openbravo.pos.resources.ImageResources;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JList;

/**
 *
 * @author Ali Safdar and Aneeqa Baber
 */
public class EmployeeRenderer extends DefaultListCellRenderer {
                
    private Icon icoemployee;

    /** Creates a new instance of EmployeeRenderer */
    public EmployeeRenderer() {
        icoemployee = ImageResources.getIcon("com/openbravo/images/user.png");
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, null, index, isSelected, cellHasFocus);
        setText(value.toString());
        setIcon(icoemployee);
        return this;
    }      
}
