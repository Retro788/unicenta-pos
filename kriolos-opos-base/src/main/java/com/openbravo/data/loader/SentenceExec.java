// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 */
public interface SentenceExec {

    /**
     * Execute the statement on datasource
     * 
     * @return number of affect row 
     * @throws BasicException 
     */
    public int exec() throws BasicException;

    /**
     * Execute the statement on datasource
     * 
     * @param params passed to statement (e.g Preparestatement)
     * @return number of affect row 
     * @throws BasicException 
     */
    public int exec(Object params) throws BasicException;
}
