// ..

package com.openbravo.data.loader;

import java.util.Comparator;

/**
 *
 * @author JG uniCenta
 */
public interface ComparatorCreator<E> {

    /**
     *
     * @return
     */
    public String[] getHeaders();

    /**
     *
     * @param index
     * @return
     */
    public Comparator<E> createComparator(int[] index);
}
