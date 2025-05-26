// ..

package com.openbravo.pos.payment;

import com.openbravo.pos.forms.AppProperties;


/**
     * Creates a new instance of PaymentGatewayFac
 */
public class PaymentGatewayFac {
    
    /** Creates a new instance of PaymentGatewayFac */
    private PaymentGatewayFac() {
    }
    
    public static PaymentGateway getPaymentGateway(AppProperties props) {
        
        String sReader = props.getProperty("payment.gateway");
// JG 16 May 12 use switch
        switch (sReader) {
            case "external":
                return new PaymentGatewayExt();             
            default:
                return null;
        }
    }      
}
