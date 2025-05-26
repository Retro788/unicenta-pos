// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author  adrian
 */
public class ImportSentence extends BaseSentence {
    
    public ImportSentence() {}
    
    /**
     *
     * @throws BasicException
     */
    @Override
    public void closeExec() throws BasicException {
    }
    
    /**
     *
     * @return
     * @throws BasicException
     */
    @Override
    public DataResultSet moreResults() throws BasicException {
        return null;
    }
    
    /**
     *
     * @param params
     * @return
     * @throws BasicException
     */
    @Override
    public DataResultSet openExec(Object params) throws BasicException {
        return null;
    }
}
