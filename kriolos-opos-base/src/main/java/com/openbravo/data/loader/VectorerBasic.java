// ..

package com.openbravo.data.loader;

import com.openbravo.format.Formats;
import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 */
public class VectorerBasic implements Vectorer {
    
    private int[] m_aiIndex;
    private String[] m_asHeaders;
    private Formats[] m_aFormats;
    
    /**
     *
     * @param asHeaders
     * @param aFormats
     * @param aiIndex
     */
    public VectorerBasic(String[] asHeaders, Formats[] aFormats, int[] aiIndex) {
        m_asHeaders = asHeaders;
        m_aFormats = aFormats;
        m_aiIndex = aiIndex;
    }
      
    /**
     *
     * @return
     * @throws BasicException
     */
    @Override
    public String[] getHeaders() throws BasicException {
        
        String[] asvalues = new String[m_aiIndex.length];
        for (int i = 0; i < m_aiIndex.length; i++) {
            asvalues[i] = m_asHeaders[m_aiIndex[i]];
        }
        
        return asvalues;
    }
    
    /**
     *
     * @param obj
     * @return
     * @throws BasicException
     */
    @Override
    public String[] getValues(Object obj) throws BasicException {
        Object[] avalues = (Object[]) obj;
        String[] asvalues = new String[m_aiIndex.length];
        for (int i = 0; i < m_aiIndex.length; i++) {
            asvalues[i] = m_aFormats[m_aiIndex[i]].formatValue(avalues[m_aiIndex[i]]);
        }
        
        return asvalues;
    }    
}
