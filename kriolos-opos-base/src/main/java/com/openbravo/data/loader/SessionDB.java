// ..

package com.openbravo.data.loader;

//file format
public interface SessionDB {

    /**
     *
     * @return
     */
    public String TRUE();

    /**
     *
     * @return
     */
    public String FALSE();

    /**
     *
     * @return
     */
    public String INTEGER_NULL();

    /**
     *
     * @return
     */
    public String CHAR_NULL();

    /**
     *
     * @return
     */
    public String getName();

    /**
     *
     * @param s
     * @param sequence
     * @return
     */
    public SentenceFind getSequenceSentence(Session s, String sequence);

    /**
     *
     * @param s
     * @param sequence
     * @return
     */
    public SentenceExec resetSequenceSentence(Session s, String sequence);
    
}


