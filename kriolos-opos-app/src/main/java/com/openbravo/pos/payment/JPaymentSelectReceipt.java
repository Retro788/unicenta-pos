// ..

package com.openbravo.pos.payment;

import java.awt.*;

/**
 * PaymentSelect for Receipt Payment
 * 
 * @author adrianromero
 */
public class JPaymentSelectReceipt extends JPaymentSelect {

    private static final long serialVersionUID = 1L;

    protected JPaymentSelectReceipt(java.awt.Frame parent, boolean modal, ComponentOrientation o) {
        super(parent, modal, o);
    }

    protected JPaymentSelectReceipt(java.awt.Dialog parent, boolean modal, ComponentOrientation o) {
        super(parent, modal, o);
    }

    public static JPaymentSelect getDialog(Component parent) {
         
        Window window = getWindow(parent);
        
        if (window instanceof Frame) { 
            return new JPaymentSelectReceipt((Frame) window, true, parent.getComponentOrientation());
        } else {
            return new JPaymentSelectReceipt((Dialog) window, true, parent.getComponentOrientation());
        }
    }

    @Override
    protected void addTabs() {
        
        addTabPayment(new JPaymentSelect.JPaymentCashCreator());
        addTabPayment(new JPaymentSelect.JPaymentChequeCreator());
        addTabPayment(new JPaymentSelect.JPaymentVoucherCreator());            
        addTabPayment(new JPaymentSelect.JPaymentMagcardCreator());                
        addTabPayment(new JPaymentSelect.JPaymentFreeCreator());                
        addTabPayment(new JPaymentSelect.JPaymentDebtCreator());
        addTabPayment(new JPaymentSelect.JPaymentBankCreator());        
        addTabPayment(new JPaymentSelect.JPaymentSlipCreator());  
    }

    @Override
    protected void setStatusPanel(boolean isPositive, boolean isComplete) {
        
        setAddEnabled(isPositive && !isComplete);
        setOKEnabled(isComplete);
    }

    @Override
    protected PaymentInfo getDefaultPayment(double total) {
        return new PaymentInfoCash(total, 0);        
    }
}
