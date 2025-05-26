// ..

package com.openbravo.pos.reports;

import java.util.HashMap;
import java.util.Map;
import com.openbravo.pos.forms.AppLocal;

/**
 *
 * @author JG uniCenta
 */
public class ReportFieldsArray implements ReportFields {
    
    private Map m_keys = null;
    
    /** Creates a new instance of ReportFieldsArray
     * @param afields */
    public ReportFieldsArray(String[] afields) {
               
        // Creo el mapa de claves
        m_keys = new HashMap();
        for (int i = 0; i < afields.length; i++) {
            m_keys.put(afields[i], i);
        }
    }
    
    /**
     *
     * @param record
     * @param field
     * @return
     * @throws ReportException
     */
    @Override
    public Object getField(Object record, String field) throws ReportException {
        
        Integer i = (Integer) m_keys.get(field);
        if (i == null) {
            throw new ReportException(AppLocal.getIntString("exception.unavailablefield", new Object[] {field}));
        } else {
            Object[] arecord = (Object[]) record;
            if (arecord == null || i.intValue() < 0 
                    || i.intValue() >= arecord.length) {
                throw new ReportException(AppLocal.getIntString("exception.unavailablefields"));
            } else {
                return arecord[i.intValue()];
            }
        }        
    }
}
