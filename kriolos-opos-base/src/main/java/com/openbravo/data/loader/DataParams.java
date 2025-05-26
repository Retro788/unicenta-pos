// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;
import java.util.Date;

//file format
public abstract class DataParams implements DataWrite {

    protected DataWrite datawrite;

    public abstract void writeValues() throws BasicException;

    @Override
    public void setInt(int paramIndex, Integer iValue) throws BasicException {
        datawrite.setInt(paramIndex, iValue);
    }

    @Override
    public void setString(int paramIndex, String sValue) throws BasicException {
        datawrite.setString(paramIndex, sValue);
    }

    @Override
    public void setDouble(int paramIndex, Double dValue) throws BasicException {
        datawrite.setDouble(paramIndex, dValue);
    }

    @Override
    public void setBoolean(int paramIndex, Boolean bValue) throws BasicException {
        datawrite.setBoolean(paramIndex, bValue);
    }

    @Override
    public void setTimestamp(int paramIndex, Date dValue) throws BasicException {
        datawrite.setTimestamp(paramIndex, dValue);
    }

    @Override
    public void setBytes(int paramIndex, byte[] value) throws BasicException {
        datawrite.setBytes(paramIndex, value);
    }

    @Override
    public void setObject(int paramIndex, Object value) throws BasicException {
        datawrite.setObject(paramIndex, value);
    }

    public DataWrite getDataWrite() {
        return datawrite;
    }

    public void setDataWrite(DataWrite dw) {
        this.datawrite = dw;
    }
}
