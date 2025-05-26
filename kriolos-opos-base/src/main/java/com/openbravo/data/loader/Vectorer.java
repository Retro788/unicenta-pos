// ..
package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 */
public interface Vectorer {

    public String[] getHeaders() throws BasicException;
    public String[] getValues(Object obj) throws BasicException;
}
