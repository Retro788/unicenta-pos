// ..

package com.openbravo.pos.admin;

import com.openbravo.pos.resources.ImageResources;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JList;

/**
 *
 * @author JG uniCenta
 */
public class PeopleRenderer extends DefaultListCellRenderer {
                
    private final Icon icopeople;

    /** Creates a new instance of PeopleRenderer */
    public PeopleRenderer() {

        icopeople = ImageResources.getIcon("com/openbravo/images/user_sml.png");
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, null, index, isSelected, cellHasFocus);
        setText(value.toString());
        setIcon(icopeople);
        return this;
    }      
}
