// ..

package com.openbravo.pos.forms;

import java.awt.Color;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

//file format
public class MenuTitleDefinition implements MenuElement {
    
    /**
     *
     */
    public String KeyText;
    
    /**
     *
     * @param menu
     */
    @Override
    public void addComponent(JPanelMenu menu) {
       
        JLabel lbl = new JLabel(AppLocal.getIntString(KeyText));
        lbl.applyComponentOrientation(menu.getComponentOrientation());
        lbl.setBorder(new MatteBorder(new Insets(0, 0, 1, 0), new Color(0, 0, 0)));
        
        menu.addTitle(lbl);
    }  
}
