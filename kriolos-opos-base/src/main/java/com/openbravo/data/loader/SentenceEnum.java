// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 */
public interface SentenceEnum {
    
    /**
     *
     * @throws BasicException
     */
    public void load() throws BasicException;

    /**
     *
     * @param params
     * @throws BasicException
     */
    public void load(Object[] params) throws BasicException;

    /**
     *
     * @return
     * @throws BasicException
     */
    public Object getCurrent() throws BasicException;

    /**
     *
     * @return
     * @throws BasicException
     */
    public boolean next() throws BasicException;    
}
