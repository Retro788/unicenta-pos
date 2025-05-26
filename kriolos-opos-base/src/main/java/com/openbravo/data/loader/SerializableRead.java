// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 */
@FunctionalInterface
public interface SerializableRead {
    public void readValues(DataRead dr) throws BasicException; 
}
