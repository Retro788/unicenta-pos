// ..

package com.openbravo.pos.forms;

import java.io.File;

//file format
public interface AppProperties {

    /**
     * Gets the configuration properties settings
     * @return config file
     */
    public File getConfigFile(); 

    /**
     * Gets the Host machine name
     * @return host name
     */
    public String getHost();    

    /**
     * Read the property from the key pair
     * @param sKey key pair value
     * @return key pair property
     */
    public String getProperty(String sKey);
}
