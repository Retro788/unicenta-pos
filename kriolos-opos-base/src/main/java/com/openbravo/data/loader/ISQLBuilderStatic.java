// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 */
@FunctionalInterface
public interface ISQLBuilderStatic {
    public String getSQL(SerializerWrite sw, Object params) throws BasicException;     
}
