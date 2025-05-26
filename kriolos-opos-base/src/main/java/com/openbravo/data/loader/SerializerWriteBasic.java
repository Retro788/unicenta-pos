// ..
package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 */
public class SerializerWriteBasic implements SerializerWrite<Object[]> {

    private final Datas<Object>[] m_classes;

    public SerializerWriteBasic(Datas... classes) {
        m_classes = classes;
    }

    @Override
    public void writeValues(DataWrite dp, Object[] obj) throws BasicException {

        for (int i = 0; i < m_classes.length; i++) {
            m_classes[i].setValue(dp, i + 1, obj[i]);
        }
    }

}
