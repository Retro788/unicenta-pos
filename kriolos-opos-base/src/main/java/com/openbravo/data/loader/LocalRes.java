// ..

package com.openbravo.data.loader;

import com.openbravo.beans.LocaleResources;

/**
 *
 * @author JG uniCenta
 */
public class LocalRes {
    
    // private static ResourceBundle m_Intl;
    private final static LocaleResources m_resources;
    
    static {
        m_resources = new LocaleResources();
        m_resources.addBundleName("data_messages");
    }
    
    /** Creates a new instance of LocalRes */
    private LocalRes() {
    }
       
    /**
     *
     * @param sKey
     * @return
     */
    public static String getIntString(String sKey) {      
        return m_resources.getString(sKey);
    }         
}
