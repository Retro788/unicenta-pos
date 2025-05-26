// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 */
public class SerializerReadImage implements SerializerRead {
    
    /**
     *
     */
    public static final SerializerRead INSTANCE = new SerializerReadImage();
    
    /** Creates a new instance of SerializerReadImage */
    private SerializerReadImage() {
    }
    
    /**
     *
     * @param dr
     * @return
     * @throws BasicException
     */
    public Object readValues(DataRead dr) throws BasicException {
        return Datas.IMAGE.getValue(dr,1);
    }    
    
}
