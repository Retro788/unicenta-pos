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

package com.openbravo.pos.config;

import com.openbravo.pos.forms.AppConfig;
import java.awt.Component;

//file format
public interface PanelConfig {

    /**
     *
     * @param config
     */
    public void loadProperties(AppConfig config);    

    /**
     *
     * @param config
     */
    public void saveProperties(AppConfig config);   

    /**
     *
     * @return
     */
    public boolean hasChanged();

    /**
     *
     * @return
     */
    public Component getConfigComponent();    
}
