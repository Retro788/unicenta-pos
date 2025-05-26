// ..

package com.openbravo.editor;

import com.openbravo.basic.BasicException;

/**
 *
 * @author JG uniCenta
 */
public class JEditorPassword extends JEditorText {
    
    private static final char ECHO_CHAR = '*';
    private static final long serialVersionUID = 1L;

    public JEditorPassword() {
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

    @Override
    protected String getTextEdit() {
        
        StringBuilder s = new StringBuilder();
        s.append("<html>");
        s.append(getEcho(m_svalue));
        if (m_cLastChar != '\u0000') {
            s.append("<font color=\"#a0a0a0\">");
            s.append(ECHO_CHAR);
            s.append("</font>");
        }
        s.append("<font color=\"#a0a0a0\">_</font>");

        return s.toString(); 
    }

    public final String getPassword() {
        String sPassword = getText();
        return sPassword == null ? "" : sPassword;     
    }

    @Override
    protected String getTextFormat() throws BasicException {
        return "<html>" + getEcho(m_svalue);
    }    
    
    private String getEcho(String sValue) {
        
        if (sValue == null) {
            return "";
        } else {
            char[] c = new char[sValue.length()];
            for(int i = 0; i < sValue.length(); i++) {
                c[i] = ECHO_CHAR;
            }
            return new String(c);
        }
    }
}
