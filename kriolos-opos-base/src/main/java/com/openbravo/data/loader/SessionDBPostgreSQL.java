// ..

package com.openbravo.data.loader;

//file format
public class SessionDBPostgreSQL implements SessionDB {

    /**
     *
     * @return
     */
    @Override
    public String TRUE() {
        return "True";
    }

    /**
     *
     * @return
     */
    @Override
    public String FALSE() {
        return "False";
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
        return "PostgreSQL";
    }

    /**
     *
     * @param s
     * @param sequence
     * @return
     */
    @Override
    public SentenceFind getSequenceSentence(Session s, String sequence) {
        return new StaticSentence(s, "SELECT NEXTVAL('" + sequence + "')", null, SerializerReadInteger.INSTANCE);
    }
    
    /**
     *
     * @param s
     * @param sequence
     * @return
     */
    @Override
    public SentenceExec resetSequenceSentence(Session s, String sequence){
        return new StaticSentence(s, "ALTER SEQUENCE " + sequence + " RESTART WITH '0'", null, SerializerReadInteger.INSTANCE);   
    }
}
