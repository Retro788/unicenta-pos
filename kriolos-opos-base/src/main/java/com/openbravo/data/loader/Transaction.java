// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;
import java.sql.SQLException;

/**
 *
 * @author adrianromero
 * Created on 26 de febrero de 2007, 21:50
 * @param <T>
 *
 */
public abstract class Transaction<T> {
    
    private Session s;
    
    /** Creates a new instance of Transaction
     * @param s */
    public Transaction(Session s) {
        this.s = s;
    }
    
    /**
     *
     * @return
     * @throws BasicException
     */
    public final T execute() throws BasicException {
        
        if (s.isTransaction()) {
            return transact();
        } else {
            try {
                try {    
                    s.begin();
                    T result = transact();
                    s.commit();
                    return result;
                } catch (BasicException e) {
                    s.rollback();
                    throw e;
                }
            } catch (SQLException eSQL) {
                throw new BasicException("Transaction error", eSQL);
            }
        }
    }
    
    /**
     *
     * @return
     * @throws BasicException
     */
    protected abstract T transact() throws BasicException;
}
