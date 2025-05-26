// ..

package com.openbravo.editor;

import java.awt.Component;

/**
 *
 * @author JG uniCenta
 */
public interface EditorComponent {
    
    /**
     *
     * @param ed
     */
    public void addEditorKeys(EditorKeys ed);    

    /**
     *
     * @return
     */
    public Component getComponent();
    
    /**
     *
     */
    public void deactivate();

    /**
     *
     * @param c
     */
    public void typeChar(char c);

    /**
     *
     * @param c
     */
    public void transChar(char c);
}
