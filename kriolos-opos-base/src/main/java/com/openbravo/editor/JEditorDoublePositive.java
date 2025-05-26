// ..

package com.openbravo.editor;

import com.openbravo.format.Formats;

/**
 *
 * @author JG uniCenta
 */
public class JEditorDoublePositive extends JEditorDouble {

    private static final long serialVersionUID = 1L;

    @Override
    protected Formats getFormat() {
        return Formats.DOUBLE;
    }

    @Override
    protected int getMode() {
        return EditorKeys.MODE_DOUBLE_POSITIVE;
    }       
}
