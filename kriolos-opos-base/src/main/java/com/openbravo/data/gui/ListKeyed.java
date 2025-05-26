// ..

package com.openbravo.data.gui;

import com.openbravo.data.loader.IKeyed;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adrianromero
 * @param <K>
 */
public class ListKeyed<K extends IKeyed> extends ArrayList<K> {
    
    /**
     *
     * @param list
     */
    public ListKeyed(List<K> list) {
        this.addAll(list);
    }

    /**
     *
     * @param key
     * @return
     */
    public K get(Object key) {

        for (K elem : this) {
            if ((key == null && elem.getKey() == null) || (key != null && key.equals(elem.getKey()))) {
                return elem;
            }
        }
        return null;
    }
}
