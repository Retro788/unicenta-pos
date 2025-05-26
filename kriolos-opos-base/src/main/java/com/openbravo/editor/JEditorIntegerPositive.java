// ..
package com.openbravo.editor;

import static com.openbravo.editor.JEditorNumber.NUMBER_ZERONULL;
import com.openbravo.format.Formats;

/**
 * 
 * @author JG uniCenta
 */
public class JEditorIntegerPositive extends JEditorNumber<Integer> {

    private static final long serialVersionUID = 1L;

    @Override
    protected Formats getFormat() {
        return Formats.INT;
    }

    @Override
    protected int getMode() {
        return EditorKeys.MODE_INTEGER_POSITIVE;
    }

    public void setValueInteger(int value) {

        String sOldText = getText();
        setCurrentValue(value);
        reprintText();
        firePropertyChange("Text", sOldText, getText());
    }


    @Override
    protected Integer getCurrentValue() {
        try {
            return Integer.parseInt(getText());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    protected void setCurrentValue(Integer value) {
        if (value >= 0) {
            setSNumber(Integer.toString(value));
            setBNegative(false);
            setINumberStatus(NUMBER_ZERONULL);
        } else {
            setSNumber(Integer.toString(-value));
            setBNegative(true);
            setINumberStatus(NUMBER_ZERONULL);
        }
    }

}
