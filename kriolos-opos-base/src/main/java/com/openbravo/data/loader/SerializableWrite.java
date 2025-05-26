// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 */
@FunctionalInterface
public interface SerializableWrite {
    public void writeValues(DataWrite dp) throws BasicException;   
}
