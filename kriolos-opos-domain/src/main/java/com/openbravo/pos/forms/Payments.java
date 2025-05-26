// ..
package com.openbravo.pos.forms;

import java.util.HashMap;

/**
 *
 * @author Jack Gerrard
 */
public class Payments {

    private final HashMap<String, Double> paymentPaid;
    private final HashMap<String, Double> paymentTendered;
    private final HashMap<String, String> rtnMessage;
    private final HashMap<String, String> paymentVoucher;

    /**
     *
     */
    public Payments() {
        paymentPaid = new HashMap<>();
        paymentTendered = new HashMap<>();
        rtnMessage = new HashMap<>();
        paymentVoucher = new HashMap<>();

    }

    /**
     *
     * @param pName
     * @param pAmountPaid
     * @param pTendered
     * @param rtnMsg
     */
    public void addPayment(String pName, Double pAmountPaid, Double pTendered, String rtnMsg) {
        if (paymentPaid.containsKey(pName)) {
            paymentPaid.put(pName, paymentPaid.get(pName) + pAmountPaid);
            paymentTendered.put(pName, paymentTendered.get(pName) + pTendered);
            rtnMessage.put(pName, rtnMsg);
        } else {
            paymentPaid.put(pName, pAmountPaid);
            paymentTendered.put(pName, pTendered);
            rtnMessage.put(pName, rtnMsg);
        }
    }

    /**
     *
     * @param pName
     * @param pAmountPaid
     * @param pTendered
     * @param rtnMsg
     * @param pVoucher
     */
    public void addPayment(String pName, Double pAmountPaid, Double pTendered, String rtnMsg, String pVoucher) {
        if (paymentPaid.containsKey(pName)) {
            paymentPaid.put(pName, paymentPaid.get(pName) + pAmountPaid);
            paymentTendered.put(pName, paymentTendered.get(pName) + pTendered);
            rtnMessage.put(pName, rtnMsg);
            paymentVoucher.put(pName, pVoucher);

        } else {
            paymentPaid.put(pName, pAmountPaid);
            paymentTendered.put(pName, pTendered);
            rtnMessage.put(pName, rtnMsg);
            if (pVoucher != null) {
                paymentVoucher.put(pName, pVoucher);
            } else {
                pVoucher = "0";
                paymentVoucher.put(pName, pVoucher);
            }
        }
    }

    /**
     *
     * @param pName
     * @return
     */
    public Double getTendered(String pName) {
        return paymentTendered.get(pName);
    }

    /**
     *
     * @param pName
     * @return
     */
    public Double getPaidAmount(String pName) {
        return paymentPaid.get(pName);
    }

    /**
     *
     * @return
     */
    public Integer getSize() {
        return paymentPaid.size();
    }

    /**
     *
     * @param pName
     * @return
     */
    public String getRtnMessage(String pName) {
        return rtnMessage.get(pName);
    }

    public String getVoucher(String pName) {
        return paymentVoucher.get(pName);
    }

    public String getFirstElement() {
        String rtnKey = paymentPaid.keySet().iterator().next();
        return rtnKey;
    }

    /**
     *
     * @param pName
     */
    public void removeFirst(String pName) {
        paymentPaid.remove(pName);
        paymentTendered.remove(pName);
        rtnMessage.remove(pName);
    }

}
