// ..
package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;
import java.util.Date;

/**
 *
 * @author adrian
 */
public class UpdateDataResultSet<T> implements DataResultSet<T> {

    private final int m_iUpdateCount;

    public UpdateDataResultSet(int iUpdateCount) {
        m_iUpdateCount = iUpdateCount;
    }

    @Override
    public Integer getInt(int columnIndex) throws BasicException {
        throw new BasicException(LocalRes.getIntString("exception.nodataset"));
    }

    @Override
    public String getString(int columnIndex) throws BasicException {
        throw new BasicException(LocalRes.getIntString("exception.nodataset"));
    }

    @Override
    public Double getDouble(int columnIndex) throws BasicException {
        throw new BasicException(LocalRes.getIntString("exception.nodataset"));
    }

    @Override
    public Boolean getBoolean(int columnIndex) throws BasicException {
        throw new BasicException(LocalRes.getIntString("exception.nodataset"));
    }

    @Override
    public Date getTimestamp(int columnIndex) throws BasicException {
        throw new BasicException(LocalRes.getIntString("exception.nodataset"));
    }

    @Override
    public byte[] getBytes(int columnIndex) throws BasicException {
        throw new BasicException(LocalRes.getIntString("exception.nodataset"));
    }

    @Override
    public T getObject(int columnIndex) throws BasicException {
        throw new BasicException(LocalRes.getIntString("exception.nodataset"));
    }

    @Override
    public DataField[] getDataField() throws BasicException {
        throw new BasicException(LocalRes.getIntString("exception.nodataset"));
    }

    @Override
    public T getCurrent() throws BasicException {
        throw new BasicException(LocalRes.getIntString("exception.nodataset"));
    }

    @Override
    public boolean next() throws BasicException {
        throw new BasicException(LocalRes.getIntString("exception.nodataset"));
    }

    @Override
    public void close() throws BasicException {}

    @Override
    public int updateCount() throws BasicException {
        return m_iUpdateCount;
    }
}
