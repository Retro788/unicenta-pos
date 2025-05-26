// ..

package com.openbravo.data.loader;

//file format
public class SessionDBGeneric implements SessionDB {

    private String name;

    /**
     *
     * @param name
     */
    public SessionDBGeneric(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String TRUE() {
        return "TRUE";
    }

    /**
     *
     * @return
     */
    public String FALSE() {
        return "FALSE";
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
        return name;
    }

    /**
     *
     * @param s
     * @param sequence
     * @return
     */
    public SentenceFind getSequenceSentence(Session s, String sequence) {
        return new StaticSentence(s, "SELECT NEXTVAL('" + sequence + "')", null, SerializerReadInteger.INSTANCE);
    }
    
    /**
     *
     * @param s
     * @param sequence
     * @return
     */
    public SentenceExec resetSequenceSentence(Session s, String sequence){
        return new StaticSentence(s, "ALTER SEQUENCE " + sequence + " RESTART WITH 0", null, SerializerReadInteger.INSTANCE);   
}    
}