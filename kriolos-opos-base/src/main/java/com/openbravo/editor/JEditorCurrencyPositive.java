// ..

package com.openbravo.editor;

import com.openbravo.format.Formats;

/**
 *
 * @author JG uniCenta
 */
public class JEditorCurrencyPositive extends JEditorDoublePositive {

    private static final long serialVersionUID = 1L;

    @Override
    protected Formats getFormat() {
        return Formats.CURRENCY;
    }     
}
