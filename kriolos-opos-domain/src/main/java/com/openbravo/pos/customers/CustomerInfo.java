// ..

package com.openbravo.pos.customers;

import com.openbravo.pos.domain.entity.businesspartner.BusinessPartner;

/** 
 * @author jack gerrard, adrianromero 
 */
public class CustomerInfo extends BusinessPartner {
    
    private static final long serialVersionUID = 9083257536541L;

    protected Double curdebt;     

    public CustomerInfo(String id) {
        super(id);
    }

    public Double getCurDebt() {
        return curdebt;
    }

    public void setCurDebt(Double curdebt) {
        this.curdebt = curdebt;
    }
}