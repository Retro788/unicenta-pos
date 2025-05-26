// ..

package com.openbravo.editor;

/**
 *
 * @author adrian
 */
public class JEditorStringNumber extends JEditorText {

    public JEditorStringNumber() {
        super();
    }
    
    @Override
    protected int getMode() {
        return EditorKeys.MODE_INTEGER_POSITIVE;
    }

    @Override
    protected int getStartMode() {
        return MODE_123;
    }    
}
