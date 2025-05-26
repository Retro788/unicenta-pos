// ..
package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JG uniCenta
 */
public class SequenceForMySQL extends BaseSentence {

    private BaseSentence sent1;
    private final BaseSentence sent2;
    private final Session session;
    private final String sequencename;

    public SequenceForMySQL(Session s, String sSeqTable) {
        this.session = s;
        this.sequencename = sSeqTable;
        sent1 = new StaticSentence(s, "UPDATE " + sSeqTable + " SET ID = LAST_INSERT_ID(ID + 1)");
        sent2 = new StaticSentence(s, "SELECT LAST_INSERT_ID()", null, SerializerReadInteger.INSTANCE);
    }

    @Override
    public DataResultSet openExec(Object params) throws BasicException {
        sent1.exec();
        return sent2.openExec(null);
    }

    @Override
    public DataResultSet moreResults() throws BasicException {
        return sent2.moreResults();
    }

    @Override
    public void closeExec() throws BasicException {
        sent2.closeExec();
    }

    public SentenceExec reset() {
        return new StaticSentence(session, "UPDATE " + sequencename + " SET ID=1");
    }
}
