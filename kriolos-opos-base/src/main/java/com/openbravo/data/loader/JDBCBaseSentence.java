// ..
package com.openbravo.data.loader;

/**
 *
 * @author JG uniCenta
 */
public abstract class JDBCBaseSentence<T> extends BaseSentence<T> {
    
    protected Session session;

    public JDBCBaseSentence(Session s) {
        super();
        session = s;
    }
}
