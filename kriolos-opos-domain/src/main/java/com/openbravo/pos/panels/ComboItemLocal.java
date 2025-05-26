// ..

package com.openbravo.pos.panels;

import com.openbravo.data.loader.IKeyed;
import com.openbravo.pos.forms.AppLocal;

/**
 *
 * @author adrianromero
 * Created on February 12, 2007, 10:49 PM
 *
 */
public class ComboItemLocal implements IKeyed {

    /**
     *
     */
    protected Integer m_iKey;

    /**
     *
     */
    protected String m_sKeyValue;

    /**
     *
     * @param iKey
     * @param sKeyValue
     */
    public ComboItemLocal(Integer iKey, String sKeyValue) {
        m_iKey = iKey;
        m_sKeyValue = sKeyValue;
    }

    /**
     *
     * @return
     */
    @Override
    public Object getKey() {
        return m_iKey;
    }

    /**
     *
     * @return
     */
    public Object getValue() {
        return m_sKeyValue;
    }
    @Override
    public String toString() {
        return AppLocal.getIntString(m_sKeyValue);
    }
} 
