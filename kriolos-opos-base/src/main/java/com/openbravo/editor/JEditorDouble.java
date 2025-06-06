// ..
package com.openbravo.editor;

import com.openbravo.format.DoubleUtils;
import com.openbravo.format.Formats;

/**
 *
 * @author JG uniCenta
 */
public class JEditorDouble extends JEditorNumber<Double> {

    private static final long serialVersionUID = 1L;
    
    
    @Override
    protected Formats getFormat() {
        return Formats.DOUBLE;
    }

    @Override
    protected int getMode() {
        return EditorKeys.MODE_DOUBLE;
    }
    
    public void setDoubleValue(Double dvalue) {

        String sOldText = getText();
        setCurrentValue(dvalue);
        reprintText();
        firePropertyChange("Text", sOldText, getText());
    }

    @Override
    protected Double getCurrentValue() {
        String text = getText();
        if (text == null || text.equals("")) {
            return null;
        } else {
            try {
                //return priceWith00? Double.parseDouble(text)/100 : Double.parseDouble(text);
                return Double.parseDouble(text);
            } catch (NumberFormatException e) {
                return null;
            }
        }
    }
    
    private String formatDouble(Double value) {
        String sNumber = Double.toString(DoubleUtils.fixDecimals(value));
        if (sNumber.endsWith(".0")) {
            sNumber = sNumber.substring(0, sNumber.length() - 2);
        }
        return sNumber;
    }

    @Override
    protected void setCurrentValue(Double value) {
        if (value == null) {
            setSNumber("");
            setBNegative(false);
            setINumberStatus(NUMBER_ZERONULL);
        } else if (value >= 0.0) {
            setSNumber(formatDouble(value));
            setBNegative(false);
            setINumberStatus(NUMBER_ZERONULL);
        } else {
            setSNumber(formatDouble(-value));
            setBNegative(true);
            setINumberStatus(NUMBER_ZERONULL);
        }
    }

}
