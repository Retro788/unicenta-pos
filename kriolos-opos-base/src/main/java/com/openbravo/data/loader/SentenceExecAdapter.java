// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 */
public abstract class SentenceExecAdapter implements SentenceExec {
    
    /**
     *
     * @return
     * @throws BasicException
     */
    public int exec() throws BasicException {
        return exec((Object) null);
    }

    /**
     *
     * @param params
     * @return
     * @throws BasicException
     */
    public abstract int exec(Object[] params) throws BasicException;

    /**
     *
     * @param params
     * @return
     * @throws BasicException
     */
    public abstract int exec(Object params) throws BasicException;    
}
