// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JG uniCenta
 */
public class SerializerWriteInteger implements SerializerWrite<Object> {
    private final static Logger LOGGER = Logger.getLogger(SerializerWriteInteger.class.getName());
    public static final SerializerWrite INSTANCE = new SerializerWriteInteger();
    
    private SerializerWriteInteger() {}
    
    public void writeValues(DataWrite dp, Object parameters) throws BasicException {
  
        int posi = 1;
        try {
            if (parameters instanceof Object[]) {
                
                for (Object param : (Object[]) parameters) {
                    Datas.INT.setValue(dp, posi, (int) param);
                }
            } else {
                Datas.INT.setValue(dp, 1, (int) parameters);
            }

        } catch (Exception ex) {
            LOGGER.log(Level.WARNING, "Exception while set value on posi: "+posi,ex);
            throw new BasicException(ex);
        }
    }  
}