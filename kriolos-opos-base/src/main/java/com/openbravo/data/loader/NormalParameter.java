// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;
import java.util.ArrayList;

/**
 *
 * @author pauloborges
 */
public class NormalParameter implements DataWrite {

    private final String m_sSentence;
    private final ArrayList<Object> m_aParams;

    public NormalParameter(String sSentence) {
        m_sSentence = sSentence;
        m_aParams = new ArrayList<>();
    }

    @Override
    public void setDouble(int paramIndex, Double dValue) throws BasicException {
        ensurePlace(paramIndex - 1);
        m_aParams.set(paramIndex - 1, DataWriteUtils.getSQLValue(dValue));
    }

    @Override
    public void setBoolean(int paramIndex, Boolean bValue) throws BasicException {
        ensurePlace(paramIndex - 1);
        m_aParams.set(paramIndex - 1, DataWriteUtils.getSQLValue(bValue));
    }

    @Override
    public void setInt(int paramIndex, Integer iValue) throws BasicException {
        ensurePlace(paramIndex - 1);
        m_aParams.set(paramIndex - 1, DataWriteUtils.getSQLValue(iValue));
    }

    @Override
    public void setString(int paramIndex, String sValue) throws BasicException {
        ensurePlace(paramIndex - 1);
        m_aParams.set(paramIndex - 1, DataWriteUtils.getSQLValue(sValue));
    }

    @Override
    public void setTimestamp(int paramIndex, java.util.Date dValue) throws BasicException {
        ensurePlace(paramIndex - 1);
        m_aParams.set(paramIndex - 1, DataWriteUtils.getSQLValue(dValue));
    }

    @Override
    public void setBytes(int paramIndex, byte[] bValue) throws BasicException {
        ensurePlace(paramIndex - 1);
        m_aParams.set(paramIndex - 1, DataWriteUtils.getSQLValue(bValue));
    }

    @Override
    public void setObject(int paramIndex, Object value) throws BasicException {
        ensurePlace(paramIndex - 1);
        m_aParams.set(paramIndex - 1, DataWriteUtils.getSQLValue(value));
    }

    private void ensurePlace(int i) {
        m_aParams.ensureCapacity(i);
        while (i >= m_aParams.size()) {
            m_aParams.add(null);
        }
    }

    public String getSentence() {

        StringBuilder sNewSentence = new StringBuilder();
        int iCount = 0;
        int iPos;
        int iLast = 0;
        while ((iPos = m_sSentence.indexOf('?', iLast)) > 0) {
            sNewSentence.append(m_sSentence.substring(iLast, iPos));
            if (iCount < m_aParams.size() && m_aParams.get(iCount) != null) {
                sNewSentence.append(m_aParams.get(iCount));
            } else {
                sNewSentence.append(DataWriteUtils.getSQLValue((Object) null));
            }
            iCount++;
            iLast = iPos + 1;
        }
        sNewSentence.append(m_sSentence.substring(iLast));

        return sNewSentence.toString();
    }
}
