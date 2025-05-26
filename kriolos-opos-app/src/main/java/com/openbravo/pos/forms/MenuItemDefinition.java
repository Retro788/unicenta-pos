// ..

package com.openbravo.pos.forms;

import java.awt.Dimension;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.SwingConstants;

//file format
public class MenuItemDefinition implements MenuElement {
    
    private Action act;
    
    /**
     *
     * @param act
     */
    public MenuItemDefinition(Action act) {
        this.act = act;
    }
    
    /**
     *
     * @param menu
     */
    @Override
    public void addComponent(JPanelMenu menu) {
        
        JButton btn = new JButton(act); 
        
        btn.setFocusPainted(false);
        btn.setFocusable(false);
        btn.setRequestFocusEnabled(false);
        btn.setHorizontalAlignment(SwingConstants.LEADING);
        btn.setPreferredSize(new Dimension(100, 100));        
        
        menu.addEntry(btn);
    }
}
