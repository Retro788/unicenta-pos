// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JG uniCenta
 */
public class SerializerReadClass<T extends SerializableRead> implements SerializerRead<SerializableRead> {

    private static final Logger LOGGER = Logger.getLogger(SerializerReadClass.class.getName());
    private final Class<T> m_clazz;

    public SerializerReadClass(Class<T> clazz) {
        m_clazz = clazz;
    }

    @Override
    public T readValues(DataRead dr) throws BasicException {
        T sr = null;
        try {
            sr = m_clazz.getDeclaredConstructor().newInstance();
            sr.readValues(dr);
        } catch (java.lang.InstantiationException | IllegalAccessException | ClassCastException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
            LOGGER.log(Level.WARNING, "Exception on casting or read value ", ex);
        }
        
        return sr;
    }
}
