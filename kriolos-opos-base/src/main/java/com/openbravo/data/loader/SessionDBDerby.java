// ..

package com.openbravo.data.loader;

//file format
public class SessionDBDerby implements SessionDB {

    /**
     *
     * @return
     */
    @Override
    public String TRUE() {
        return "1";
    }

    /**
     *
     * @return
     */
    @Override
    public String FALSE() {
        return "0";
    }

    /**
     *
     * @return
     */
    @Override
    public String INTEGER_NULL() {
        return "CAST(NULL AS INTEGER)";
    }

    /**
     *
     * @return
     */
    @Override
    public String CHAR_NULL() {
        return "CAST(NULL AS CHAR)";
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return "Derby";
    }

    /**
     *
     * @param s
     * @param sequence
     * @return
     */
    @Override
    public SentenceFind getSequenceSentence(Session s, String sequence) {
        return new SequenceForDerby(s, sequence);
    }
    
    /**
     *
     * @param s
     * @param sequence
     * @return
     */
    @Override
    public SentenceExec resetSequenceSentence(Session s, String sequence) {
        return new SequenceForDerby(s, sequence);    
}
}
