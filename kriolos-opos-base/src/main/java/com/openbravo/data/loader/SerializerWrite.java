// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 * @param <T>
 */
@FunctionalInterface
public interface SerializerWrite<T> {
    public void writeValues(DataWrite dp, T parameters) throws BasicException;   
}
