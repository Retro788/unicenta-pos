// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author  adrian
 */
@FunctionalInterface
public interface SerializerRead<T> {
    public T readValues(DataRead dr) throws BasicException;     
}
