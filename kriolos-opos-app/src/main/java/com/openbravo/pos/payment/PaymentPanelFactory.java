// ..

package com.openbravo.pos.payment;

//file format
public class PaymentPanelFactory {

    private PaymentPanelFactory() {}
    
    public static PaymentPanel getPaymentPanel(String sReader, JPaymentNotifier notifier) {
        switch (sReader) {
            case "Intelligent":
                return new PaymentPanelMagCard(new MagCardReaderIntelligent(), notifier);
            case "Generic":
                return new PaymentPanelMagCard(new MagCardReaderGeneric(), notifier);
            case "Keyboard":
                return new PaymentPanelKeyboard(notifier);
            case "EMV":
                return new PaymentPanelEMV(notifier);
            default:
           return new PaymentPanelBasic(notifier);
        }
    }      
}
