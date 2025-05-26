// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JG uniCenta
 */
public class SerializerWriteBuilder implements SerializerWrite<SerializableWrite> {

    private final static Logger LOGGER = Logger.getLogger(SerializerWriteBuilder.class.getName());
    public static final SerializerWrite INSTANCE = new SerializerWriteBuilder();

    private SerializerWriteBuilder() {}

    public void writeValues(DataWrite dp, SerializableWrite obj) throws BasicException {
        try {
            obj.writeValues(dp);
        } catch (Exception ex) {
            LOGGER.log(Level.WARNING, "Exception while writeValues",ex);
            throw new BasicException(ex);
        }
    }
}
