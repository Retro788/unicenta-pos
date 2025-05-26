// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author adrian
 */
public class BasicSentenceEnum implements SentenceEnum {
    
    private final BaseSentence sent;
    private DataResultSet SRS;
    
    /** Creates a new instance of AbstractSentenceEnum
     * @param sent */
    public BasicSentenceEnum(BaseSentence sent) {
        this.sent = sent;
        this.SRS = null;
    }
    
    /**
     *
     * @throws BasicException
     */
    @Override
    public void load() throws BasicException {
        load(null);
    }

    /**
     *
     * @param params
     * @throws BasicException
     */
    @Override
    public void load(Object[] params) throws BasicException {
        SRS = sent.openExec(params);
    }

    /**
     *
     * @return
     * @throws BasicException
     */
    @Override
    public Object getCurrent() throws BasicException {
        if (SRS == null) {
            throw new BasicException(LocalRes.getIntString("exception.nodataset"));
        } 
        
        return SRS.getCurrent();  
    }
    
    /**
     *
     * @return
     * @throws BasicException
     */
    @Override
    public boolean next() throws BasicException {
        if (SRS == null) {
            throw new BasicException(LocalRes.getIntString("exception.nodataset"));
        } 
        
        if (SRS.next()) {
            return true;  
        } else {
            SRS.close();
            SRS = null;
            sent.closeExec();
            return false;
        }
    }
}
