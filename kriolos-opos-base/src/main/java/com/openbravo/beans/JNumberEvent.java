// ..

package com.openbravo.beans;

import java.util.EventObject;

/**
 *
 * @author adrianromero
 * @version 
 */
public class JNumberEvent extends EventObject {

    private char m_cKey;
    
    /**
     *
     * @param source
     * @param cKey
     */
    public JNumberEvent(Object source, char cKey) {
        super(source);
        m_cKey = cKey;
    }
    
    /**
     *
     * @return
     */
    public char getKey() {
        return m_cKey;
    }

}
