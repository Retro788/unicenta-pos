// ..

package com.openbravo.pos.payment;

/**
 *
 * @author JG uniCenta
 */
public class PaymentGatewayExt implements PaymentGateway {
    
    /** Creates a new instance of PaymentGatewayExt */
    public PaymentGatewayExt() {
    }
  
    /**
     *
     * @param payinfo
     */
    @Override
    public void execute(PaymentInfoMagcard payinfo) {
        payinfo.paymentOK("OK", payinfo.getTransactionID() , "");
    }
}
