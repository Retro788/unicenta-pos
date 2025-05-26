// ..

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
