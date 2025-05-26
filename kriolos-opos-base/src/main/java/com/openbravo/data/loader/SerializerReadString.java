// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;
    
/**
 *
 * @author JG uniCenta
 */
public class SerializerReadString implements SerializerRead<String> {
    
    /**
     *
     */
    public static final SerializerRead<String> INSTANCE = new SerializerReadString();
    
    /** Creates a new instance of SerializerReadImage */
    private SerializerReadString() {
    }
    
    /**
     *
     * @param dr
     * @return
     * @throws BasicException
     */
    public String readValues(DataRead dr) throws BasicException {
        return Datas.STRING.getValue(dr,1);
    }
}
