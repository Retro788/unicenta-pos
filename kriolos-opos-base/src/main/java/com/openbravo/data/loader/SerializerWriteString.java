// ..
package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JG uniCenta
 */
public class SerializerWriteString implements SerializerWrite {

    private final static Logger LOGGER = Logger.getLogger(SerializerWriteString.class.getName());
    public static final SerializerWrite<String> INSTANCE = new SerializerWriteString();

    private SerializerWriteString() {}

    @Override
    public void writeValues(DataWrite dp, Object parameters) throws BasicException {

        int posi = 1;
        try {
            if (parameters instanceof Object[]) {
                
                for (Object param : (Object[]) parameters) {
                    Datas.STRING.setValue(dp, posi++, (String) param);
                }
            } else {
                Datas.STRING.setValue(dp, 1, (String) parameters);
            }

        } catch (BasicException ex) {
            LOGGER.log(Level.WARNING, "Exception while set value for parameter on posi: "+posi,ex);
            throw new BasicException(ex);
        }
    }
}
