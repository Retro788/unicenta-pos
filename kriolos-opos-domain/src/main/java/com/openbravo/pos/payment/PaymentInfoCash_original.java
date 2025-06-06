// ..

package com.openbravo.pos.payment;

import com.openbravo.format.Formats;

/**
 *
 * @author JG uniCenta
 */
public class PaymentInfoCash_original extends PaymentInfo {
    
    private final double m_dPaid;
    private final double m_dTotal;
    private double m_dTendered;    
    private final String m_dCardName =null;
//    private double m_dTip;    
    
    /** Creates a new instance of PaymentInfoCash
     * @param dTotal
     * @param dPaid */
    public PaymentInfoCash_original(double dTotal, double dPaid) {
        m_dTotal = dTotal;
        m_dPaid = dPaid;
    }
    
    @Override
    public PaymentInfo copyPayment(){
        return new PaymentInfoCash_original(m_dTotal, m_dPaid);
    }
    
    @Override
    public String getTransactionID(){
        return "no ID";
    }

    @Override
    public String getName() {
        return "cash";
    }   
    @Override
    public double getTotal() {
        return m_dTotal;
    }   
/**    public double getTip() {
        return m_dTip;
    }
     * @return 
*/
    @Override
    public double getPaid() {
        return m_dPaid;
    }

    @Override
    public double getTendered() {
        return m_dTendered;
    }

    @Override
    public double getChange(){
       return m_dPaid - m_dTotal;
   }

    @Override
   public String getCardName() {
       return m_dCardName;
   }
    public String printPaid() {
        return Formats.CURRENCY.formatValue(m_dPaid);
    }   
    public String printChange() {
        return Formats.CURRENCY.formatValue(m_dPaid - m_dTotal);
    }

    @Override
    public String getVoucher() {
        return null;
    }
    
}
