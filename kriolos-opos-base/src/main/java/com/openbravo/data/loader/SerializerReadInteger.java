// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 */
public class SerializerReadInteger implements SerializerRead<Integer> {
    
    /**
     *
     */
    public static final SerializerRead INSTANCE = new SerializerReadInteger();
    
    /** Creates a new instance of SerializerReadInteger */
    private SerializerReadInteger() {
    }
    
    /**
     *
     * @param dr
     * @return
     * @throws BasicException
     */
    public Integer readValues(DataRead dr) throws BasicException {
        return Datas.INT.getValue(dr,1);
    }    
}
