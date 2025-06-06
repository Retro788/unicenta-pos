// ..
package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 */
public class SequenceForDerby extends BaseSentence {

    private BaseSentence sent1;
    private BaseSentence sent2;
    private BaseSentence sent3;

    public SequenceForDerby(Session s, String sSeqTable) {

        sent1 = new StaticSentence(s, "DELETE FROM  " + sSeqTable);
        sent2 = new StaticSentence(s, "INSERT INTO " + sSeqTable + " VALUES (DEFAULT)");
        sent3 = new StaticSentence(s, "SELECT IDENTITY_VAL_LOCAL() FROM " + sSeqTable, null, SerializerReadInteger.INSTANCE);
    }

    @Override
    public DataResultSet openExec(Object params) throws BasicException {
        sent1.exec();
        sent2.exec();
        return sent3.openExec(null);
    }

    @Override
    public DataResultSet moreResults() throws BasicException {
        return sent3.moreResults();
    }

    @Override
    public void closeExec() throws BasicException {
        sent3.closeExec();
    }
}
