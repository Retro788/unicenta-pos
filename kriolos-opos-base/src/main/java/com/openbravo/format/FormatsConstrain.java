// ..

package com.openbravo.format;

import java.text.ParseException;

/**
 *
 * @author JG uniCenta
 */
public abstract class FormatsConstrain {
    
    public abstract Object check(Object value) throws ParseException;
    public FormatsConstrain() {}
}
