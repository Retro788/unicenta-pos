// ..

package com.openbravo.pos.reports;

/**
 *
 * @author JG uniCenta
 */
public interface ReportFields {
    
    /**
     *
     * @param record
     * @param field
     * @return
     * @throws ReportException
     */
    public Object getField(Object record, String field) throws ReportException;   
}
