// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 */
public class SerializerWriteBasicComposed implements SerializerWrite<Object[]> {
    
    private Datas[][] m_classes;    
    
    /** Creates a new instance of SerializerWriteComposed
     * @param classes */
    public SerializerWriteBasicComposed(Datas[]... classes) {
         m_classes = classes;
    }
    
    /**
     *
     * @param dp
     * @param obj
     * @throws BasicException
     */
    public void writeValues(DataWrite dp, Object[] obj) throws BasicException {

        int index = 0;
        for (int i = 0; i < m_classes.length; i++) {
            Object[] val = (Object[]) obj[i];
            for (int j = 0; j < m_classes[i].length; j++) {
                index++;
                m_classes[i][j].setValue(dp, index, val[j]);
            }
        }
    }  
}
