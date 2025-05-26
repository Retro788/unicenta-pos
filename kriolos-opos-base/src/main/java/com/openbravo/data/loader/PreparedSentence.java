// ..
package com.openbravo.data.loader;

/**
 *
 * @author adrianromero
 * @param <W>
 * @param <T>
 */
public class PreparedSentence<W, T> extends PreparedSentenceExec<W, T> {

    /*
    public PreparedSentence(Session s, ISQLBuilderStatic sentence, SerializerWrite<W> serwrite, SerializerRead<T> serread) {
        super(s, sentence, serwrite, serread);
    }

    public PreparedSentence(Session s, ISQLBuilderStatic sentence) {
        this(s, sentence, null, null);
    }

    public PreparedSentence(Session s, ISQLBuilderStatic sentence, SerializerWrite<W> serwrite) {
        this(s, sentence, serwrite, null);
    }
 

    public PreparedSentence(Session s, String sentence, SerializerWrite<W> serwrite, SerializerRead<T> serread) {
        this(s, new NormalBuilder(sentence), serwrite, serread);
    }

    public PreparedSentence(Session s, String sentence, SerializerWrite<W> serwrite) {
        this(s, new NormalBuilder(sentence), serwrite, null);
    }

    public PreparedSentence(Session s, String sentence) {
        this(s, new NormalBuilder(sentence), null, null);
    }
   */
    /* */
    public PreparedSentence(Session session, String sqlSentence, Datas[] param, int[] index) {
        super( session,  sqlSentence, param, index);
    }

    public PreparedSentence(Session s, String sentence, SerializerWrite<W> serwrite) {
        super(s, sentence, serwrite);
    }

    public PreparedSentence(Session s, String sentence, SerializerWrite<W> serwrite, SerializerRead<T> serread) {
        super(s, sentence, serwrite, serread);
    }

}
