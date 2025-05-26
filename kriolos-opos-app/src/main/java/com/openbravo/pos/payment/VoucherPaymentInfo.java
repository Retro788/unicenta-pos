// ..
package com.openbravo.pos.payment;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.SerializableRead;
import com.openbravo.format.Formats;

/**
 * @deprecated Should use #PaymentInfoTicket 
 * @see PaymentInfoTicket
 * 
 * This will be removed after confirm no use
 * poolborge 2023/04/23
 * 
 */
public class VoucherPaymentInfo extends PaymentInfo implements SerializableRead {

    private static final long serialVersionUID = 8865238639097L;
    private double m_dTicket;
    private String m_sName;
    private String m_sVoucher;

    public VoucherPaymentInfo(double dTicket, String sName, String sVoucher) {
        m_dTicket = dTicket;
        m_sName = sName;
        m_sVoucher = sVoucher;
    }

    public VoucherPaymentInfo() {
        m_dTicket = 0.0;
        m_sName = null;
        m_sVoucher = null;
    }

    @Override
    public void readValues(DataRead dr) throws BasicException {
        m_sName = dr.getString(1);
        m_dTicket = dr.getDouble(2);
        m_sVoucher = dr.getString(3);
    }

    @Override
    public PaymentInfo copyPayment() {
        return new VoucherPaymentInfo(m_dTicket, m_sName, m_sVoucher);
    }

    @Override
    public String getName() {
        return m_sName;
    }

    @Override
    public double getTotal() {
        return m_dTicket;
    }

    @Override
    public String getTransactionID() {
        return null;
    }

    public String printPaid() {
        return Formats.CURRENCY.formatValue(m_dTicket);
    }

    public String printVoucherTotal() {
        return Formats.CURRENCY.formatValue(-m_dTicket);
    }

    @Override
    public double getPaid() {
        return m_dTicket;
    }

    @Override
    public double getChange() {
        return 0;
    }

    @Override
    public String getVoucher() {
        return m_sVoucher;
    }

    public String getCardType() {
        return null;
    }

    @Override
    public double getTendered() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getCardName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
