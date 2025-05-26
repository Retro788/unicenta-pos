// ..

package com.openbravo.basic;

/**
 *
 * @author JG uniCenta
 */
public class BasicException extends java.lang.Exception {

    private static final long serialVersionUID = 1L;

    public BasicException() {}
    
    public BasicException(String msg) {
        super(msg);
    }
    
    public BasicException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    public BasicException(Throwable cause) {
        super(cause);
    }
}
