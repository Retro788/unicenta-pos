// ..

package com.openbravo.data.user;

/**
 *
 * @author adrianromero
 * Created on 22 de marzo de 2007, 0:00
 *
 */
public interface DocumentLoader {
    
    /**
     *
     * @param key
     * @return
     */
    public Object getValue(Object key);

    /**
     *
     * @param value
     * @return
     */
    public Object getKey(Object value);
}
