// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 * @author Paulo Borges, 2021, 
 *
 */
public interface DataResultSet<T> extends DataRead, AutoCloseable {

    public T getCurrent() throws BasicException;

    public boolean next() throws BasicException;    

    @Override
    public void close() throws BasicException;

    public int updateCount() throws BasicException;           
}
