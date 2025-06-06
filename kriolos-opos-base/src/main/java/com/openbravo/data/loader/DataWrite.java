// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author  adrian
 */
public interface DataWrite {

    public void setInt(int paramIndex, Integer iValue) throws BasicException;

    public void setString(int paramIndex, String sValue) throws BasicException;

    public void setDouble(int paramIndex, Double dValue) throws BasicException;

    public void setBoolean(int paramIndex, Boolean bValue) throws BasicException;

    public void setTimestamp(int paramIndex, java.util.Date dValue) throws BasicException;
    
    public void setBytes(int paramIndex, byte[] value) throws BasicException;

    public void setObject(int paramIndex, Object value) throws BasicException;
}
