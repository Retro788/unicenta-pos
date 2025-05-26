// ..

package com.openbravo.data.user;

import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 */
@FunctionalInterface
public interface Finder {

    /**
     *
     * @param obj
     * @return
     * @throws BasicException
     */
    public boolean match(Object obj) throws BasicException;
}
