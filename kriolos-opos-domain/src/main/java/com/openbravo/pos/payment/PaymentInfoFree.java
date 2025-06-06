// ..

package com.openbravo.pos.payment;

public class PaymentInfoFree extends PaymentInfo {
    
    private double m_dTotal;
    private double m_dTendered;
    private String m_dCardName =null;
//    private double m_dTip;    
   
    /** Creates a new instance of PaymentInfoFree
     * @param dTotal */
    public PaymentInfoFree(double dTotal) {
        m_dTotal = dTotal;
    }

    public PaymentInfo copyPayment(){
        return new PaymentInfoFree(m_dTotal);
    }    
    public String getTransactionID(){
        return "no ID";
    }
    public String getName() {
        return "free";
    }   
    public double getTotal() {
        return m_dTotal;
    }
    public double getPaid() {
        return (0.0); 
    }

/**
 * 
    public double getTip() {
        return m_dTip;
    }
*/
    
    public double getChange(){
       return (0.00);
   }
    public double getTendered() {
       return m_dTendered;
   }
    public String getCardName() {
       return m_dCardName;
   } 

/**    
    public boolean getIsProcessed() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setIsProcessed(boolean value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getReturnMessage() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
*/
    
    public String getVoucher() {
        return null;
    }    

}
