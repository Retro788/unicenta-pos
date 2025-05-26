// ..

package com.openbravo.pos.reports;

/**
 *
 * @author JG uniCenta
 */
public class ReportException extends Exception {
    
    /**
     *
     */
    public ReportException() {
    }

    /**
     *
     * @param msg
     */
    public ReportException(String msg) {
        super(msg);
    }

    /**
     *
     * @param e
     */
    public ReportException(Exception e) {
        super(e);
    }
}
