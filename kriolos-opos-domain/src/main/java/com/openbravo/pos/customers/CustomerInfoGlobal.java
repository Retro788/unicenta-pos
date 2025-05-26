// ..
//
//    For BrowseEditableData
package com.openbravo.pos.customers;

import com.openbravo.data.user.BrowsableEditableData;

/**
 *
 * @author HS uniCenta
 */
public class CustomerInfoGlobal {

    private static CustomerInfoGlobal INSTANCE;
    private CustomerInfoExt customerInfoExt;
    private BrowsableEditableData editableData;

    private CustomerInfoGlobal() {}

    public static CustomerInfoGlobal getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CustomerInfoGlobal();
        }

        return INSTANCE;
    }

    public CustomerInfoExt getCustomerInfoExt() {
        return customerInfoExt;
    }

    public void setCustomerInfoExt(CustomerInfoExt customerInfoExt) {
        this.customerInfoExt = customerInfoExt;
    }

    public BrowsableEditableData getEditableData() {
        return editableData;
    }

    public void setEditableData(BrowsableEditableData editableData) {
        this.editableData = editableData;
    }

}
