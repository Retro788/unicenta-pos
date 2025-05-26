// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 */
public class SerializerWriteBasicExt implements SerializerWrite<Object[]> {
    
    private final Datas[] paramsTypeOfData;
    private final int[] paramsIndexOfValue;

    public SerializerWriteBasicExt(Datas[] classes, int[] index) {
        paramsTypeOfData = classes;
        paramsIndexOfValue = index;
    }

    /**
     * 
     * @param dp Datawrite
     * @param obj Params value
     * @throws BasicException 
     */
    @Override
    public void writeValues(DataWrite dp, Object[] obj) throws BasicException {

        for (int i = 0; i < paramsIndexOfValue.length; i++) {
            paramsTypeOfData[paramsIndexOfValue[i]].setValue(dp, i + 1, obj[paramsIndexOfValue[i]]);
        }
    }
    
}