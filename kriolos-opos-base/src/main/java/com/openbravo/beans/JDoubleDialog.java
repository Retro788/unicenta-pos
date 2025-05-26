// ..

package com.openbravo.beans;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.Icon;
import javax.swing.SwingUtilities;

/**
 *
 * @author  adrian
 */
public class JDoubleDialog extends JNumberDialog<Double> {

    public JDoubleDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        m_jnumber = new com.openbravo.editor.JEditorDoublePositive();
        init();
    }

    public JDoubleDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        m_jnumber = new com.openbravo.editor.JEditorDoublePositive();
        init();
    }

    private void init() {
        m_jnumber.setValue(0.0);
        setup();
    }

    public static Double showComponent(Component parent, String title) {
        return showComponent(parent, title, null, null);
    }

    public static Double showComponent(Component parent, String title, String message) {
        return showComponent(parent, title, message, null);
    }

    public static Double showComponent(Component parent, String title, String message, Icon icon){
    
        Window window = SwingUtilities.windowForComponent(parent);
        
        JDoubleDialog entryDialog;
        if (window instanceof Frame) { 
            entryDialog = new JDoubleDialog((Frame) window, true);
        } else {
            entryDialog = new JDoubleDialog((Dialog) window, true);
        }
        
        entryDialog.setTitle(title, message, icon);
        entryDialog.setVisible(true);
        return entryDialog.getValue();
    }
}
