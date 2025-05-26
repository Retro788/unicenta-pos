// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author adrianromero
 * Created on February 6, 2007, 4:06 PM
 *
 */
public abstract class SentenceExecTransaction implements SentenceExec {
    
    private Session m_s;
    
    /**
     *
     * @param s
     */
    public SentenceExecTransaction(Session s) {
        m_s = s;
    }
    
    /**
     *
     * @return
     * @throws BasicException
     */
    public final int exec() throws BasicException {
        return exec((Object[]) null);
    }

    /**
     *
     * @param params
     * @return
     * @throws BasicException
     */
    public final int exec(Object[] params) throws BasicException {
        Transaction<Integer> t = new Transaction<Integer>(m_s) {
            public Integer transact() throws BasicException{
                return execInTransaction(params);
            }
        };
        
        return t.execute();
    }

    /**
     *
     * @param params
     * @return
     * @throws BasicException
     */
    public final int exec(final Object params) throws BasicException {
        return exec((Object[])params);
    }
    
    /**
     *
     * @param params
     * @return
     * @throws BasicException
     */
    protected abstract int execInTransaction(Object[] params) throws BasicException; 
}

