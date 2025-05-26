// ..
package com.openbravo.pos.payment;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.SerializableRead;
import com.openbravo.format.Formats;

public class PaymentInfoTicket extends PaymentInfo implements SerializableRead {

    private static final long serialVersionUID = 8865238639097L;
    
    private double m_dTicket;
    private String m_sName;
    private String m_transactionID;
    private double m_dTendered;
    private String m_dCardName;
    private String m_sVoucher;

    /**
     * Used For: Cheque, Bank , Slip, Voucher
     *
     * @param ticketAmount Amount
     * @param sName Name for purpose (e.g: cheque,  bank, slip, voucherin, debt, debtpaid, cashrefund)
     */
    public PaymentInfoTicket(double ticketAmount, String sName) {
        this(ticketAmount, sName, null, null);
    }

    /**
     * Used For: Voucher
     *
     * @param ticketAmount Amount
     * @param sName Name for purpose (e.g: cheque,  bank, slip, voucherin, debt, debtpaid, cashrefund)
     * @param transactionID Transaction ID (Context of what)
     * @param sVoucher Voucher Number
     */
    public PaymentInfoTicket(double ticketAmount, String sName, String transactionID, String sVoucher) {
        m_sName = sName;
        m_dTicket = ticketAmount;
        m_transactionID = transactionID;
        m_sVoucher = sVoucher;
        m_dCardName = null;
        m_dTendered = 0.00;
    }

    /**
     * Used for: Voucher
     *
     * @param ticketAmount
     * @param sName Name for purpose (e.g: cheque,  bank, slip, voucherin, debt, debtpaid, cashrefund)
     * @param sVoucher Voucher Number
     */
    public PaymentInfoTicket(double ticketAmount, String sName, String sVoucher) {
        this(ticketAmount, sName, null, sVoucher);
    }

    public PaymentInfoTicket() {
        this(0.0, null, null, null);
    }

    @Override
    public void readValues(DataRead dr) throws BasicException {
        m_sName = dr.getString(1);
        m_dTicket = dr.getDouble(2);
        m_transactionID = dr.getString(3);
        if (dr.getDouble(4) != null) {
            m_dTendered = dr.getDouble(4);
        }
        m_dCardName = dr.getString(5);    
    }

    @Override
    public PaymentInfo copyPayment() {
        return new PaymentInfoTicket(m_dTicket, m_sName);
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
        return m_transactionID;
    }

    @Override
    public double getPaid() {
        return (0.0);
    }

    @Override
    public double getChange() {
        return m_dTendered - m_dTicket;
    }

    @Override
    public double getTendered() {
        return (0.0);
    }

    @Override
    public String getCardName() {
        return m_dCardName;
    }

    public String printPaid() {
        return Formats.CURRENCY.formatValue(m_dTicket);
    }

    public String printVoucherTotal() {
        return Formats.CURRENCY.formatValue(-m_dTicket);
    }

    public String printChange() {
        return Formats.CURRENCY.formatValue(m_dTendered - m_dTicket);
    }

    public String printTendered() {
        return Formats.CURRENCY.formatValue(m_dTendered);
    }

    @Override
    public String getVoucher() {
        return m_sVoucher;
    }

    public String printVoucher() {
        return m_sVoucher;
    }
}
