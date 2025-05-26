// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 */
public interface SentenceFind<T> {

    public T find() throws BasicException;

    public T find(Object... params) throws BasicException;
}
