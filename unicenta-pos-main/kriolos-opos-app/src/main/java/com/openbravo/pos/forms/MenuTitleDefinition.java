//    KriolOS POS
//    Copyright (c) 2019-2023 KriolOS
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.

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
