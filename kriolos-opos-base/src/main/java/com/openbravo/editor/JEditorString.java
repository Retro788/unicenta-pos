// ..

package com.openbravo.editor;

/**
 *
 * @author JG uniCenta
 */
public class JEditorString extends JEditorText {

    private static final long serialVersionUID = 1L;

    
    public JEditorString() {
        super();
    }

    @Override
    protected final int getMode() {
        return EditorKeys.MODE_STRING;
    }

    @Override
    protected int getStartMode() {
        return MODE_Abc1;
    }
    
}

