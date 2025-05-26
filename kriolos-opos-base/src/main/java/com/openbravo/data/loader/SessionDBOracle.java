// ..

package com.openbravo.data.loader;

//file format
public class SessionDBOracle implements SessionDB {

    /**
     *
     * @return
     */
    public String TRUE() {
        return "1";
    }

    /**
     *
     * @return
     */
    public String FALSE() {
        return "0";
    }

    /**
     *
     * @return
     */
    public String INTEGER_NULL() {
        return "CAST(NULL AS INTEGER)";
    }

    /**
     *
     * @return
     */
    public String CHAR_NULL() {
        return "CAST(NULL AS CHAR)";
    }

    /**
     *
     * @return
     */
    public String getName() {
        return "Oracle";
    }

    /**
     *
     * @param s
     * @param sequence
     * @return
     */
    public SentenceFind getSequenceSentence(Session s, String sequence) {
        return new StaticSentence(s, "SELECT " + sequence + ".NEXTVAL FROM DUAL", null, SerializerReadInteger.INSTANCE);
    }

    /**
     *
     * @param s
     * @param sequence
     * @return
     */
    public SentenceExec resetSequenceSentence(Session s, String sequence) {
        return new StaticSentence(s, "SELECT " + sequence + ".NEXTVAL FROM DUAL", null, SerializerReadInteger.INSTANCE);
    }
}