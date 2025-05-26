// ..
package com.openbravo.editor;

import com.openbravo.format.Formats;

/**
 *
 * @author JG uniCenta
 */
public class JEditorCurrency extends JEditorDouble {

    /**
     * Return Formats.Currency 
     * @return
     */
    @Override
    protected Formats getFormat() {
        return Formats.CURRENCY;
    }
}
