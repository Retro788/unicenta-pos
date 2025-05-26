// ..

package com.openbravo.data.loader;

//file format
public class SessionDBHSQLDB implements SessionDB {

    /**
     *
     * @return
     */
    @Override
    public String TRUE() {
        return "TRUE";
    }

    /**
     *
     * @return
     */
    @Override
    public String FALSE() {
        return "FALSE";
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
        return "HSQLDB";
    }

    /**
     *
     * @param s
     * @param sequence
     * @return
     */
    @Override
    public SentenceFind getSequenceSentence(Session s, String sequence) {
        return new SequenceForGeneric(s, sequence);
        //return new StaticSentence(s, "CALL NEXT VALUE FOR " + sequence, null, SerializerReadInteger.INSTANCE);
    }
    
    /**
     *
     * @param s
     * @param sequence
     * @return
     */
    @Override
    public SentenceExec resetSequenceSentence(Session s, String sequence) {
        SequenceForGeneric seqGeneric = new SequenceForGeneric(s, sequence);
        return seqGeneric.reset();
        //return new StaticSentence(s, "CALL NEXT VALUE FOR " + sequence, null, SerializerReadInteger.INSTANCE);
    }    
}
