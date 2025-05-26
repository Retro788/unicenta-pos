// ..

package com.openbravo.pos.payment;

import java.awt.*;

//file format
public class JPaymentSelectCustomer extends JPaymentSelect {

    private static final long serialVersionUID = 1L;

    protected JPaymentSelectCustomer(java.awt.Frame parent, boolean modal, ComponentOrientation o) {
        super(parent, modal, o);
    }

    protected JPaymentSelectCustomer(java.awt.Dialog parent, boolean modal, ComponentOrientation o) {
        super(parent, modal, o);
    }

    public static JPaymentSelect getDialog(Component parent) {

        Window window = getWindow(parent);
        
        if (window instanceof Frame) { 
            return new JPaymentSelectCustomer((Frame) window, true, parent.getComponentOrientation());
        } else {
            return new JPaymentSelectCustomer((Dialog) window, true, parent.getComponentOrientation());
        } 
    }

    @Override
    protected void addTabs() {
        addTabPayment(new JPaymentSelect.JPaymentCashCreator());
        addTabPayment(new JPaymentSelect.JPaymentChequeCreator());
        addTabPayment(new JPaymentSelect.JPaymentVoucherCreator());
        addTabPayment(new JPaymentSelect.JPaymentBankCreator());
        addTabPayment(new JPaymentSelect.JPaymentMagcardCreator());
        addTabPayment(new JPaymentSelect.JPaymentSlipCreator());
    }

    @Override
    protected void setStatusPanel(boolean isPositive, boolean isComplete) {
        setAddEnabled(isPositive && !isComplete);
        setOKEnabled(isPositive);
    }

    @Override
    protected PaymentInfo getDefaultPayment(double total) {
        return new PaymentInfoCash(total, total);        
    }    
}
