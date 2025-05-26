// ..
package com.openbravo.pos.admin;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;

/**
 *
 * @author adrianromero Created on 27 de febrero de 2007, 23:46
 *
 */
public class RoleInfoExt extends RoleInfo {

    protected byte[] m_aPermissions;

    public RoleInfoExt() {
        super();
        m_aPermissions = null;
    }

    @Override
    public void readValues(DataRead dr) throws BasicException {
        m_sName = dr.getString(1);
        m_aPermissions = dr.getBytes(2);
    }

    public static String[] getHeaders() {
        return new String[]{"Name"};
    }
    
    public String[] toStringArray() {
        return new String[]{m_sName};
    }
    
    public Comparable[] toComparableArray() {
        return new Comparable[]{m_sName};
    }
}
