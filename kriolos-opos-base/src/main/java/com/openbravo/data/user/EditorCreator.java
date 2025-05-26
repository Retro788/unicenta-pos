// ..

package com.openbravo.data.user;

import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 */
public interface EditorCreator<T> {
    public T createValue() throws BasicException;
}
