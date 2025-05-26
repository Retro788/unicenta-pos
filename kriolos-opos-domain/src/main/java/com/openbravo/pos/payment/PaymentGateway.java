// ..

package com.openbravo.pos.payment;

/**
 *
 * @author JG uniCenta
 */
public interface PaymentGateway {

    /**
     *
     * @param payinfo
     */
    public void execute(PaymentInfoMagcard payinfo);
}
