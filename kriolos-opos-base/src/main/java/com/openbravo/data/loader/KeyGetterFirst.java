// ..

package com.openbravo.data.loader;

/**
 *
 * @author  adrian
 */
public class KeyGetterFirst implements IKeyGetter {
    
    private final int [] m_aElems;
    
    /** Creates a new instance of KeyGetterBasic
     * @param aElems */
    public KeyGetterFirst(int[] aElems) {
        m_aElems = aElems;
    }
    
    /**
     *
     * @param value
     * @return
     */
    @Override
    public Object getKey(Object value) {
        if (value == null) {
            return null;
        } else {
            Object[] avalue = (Object []) value;
            return avalue[m_aElems[0]];
        }
    }   
}
