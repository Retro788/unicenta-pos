// ..

package com.openbravo.pos.customers;

import java.io.Serializable;
import java.util.Date;

/**
 * @author poolborges
 */
public class ReservationInfo implements Serializable {

    private static final long serialVersionUID = 9083257536541L;

    protected String id;
    protected Date createdDate;
    protected Date dateNew;
    protected String taxId;
    protected String customerSearchKey;
    protected String name;
    protected int numChairs;
    protected boolean isDone;
    protected String description;

    public ReservationInfo(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return getName();
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getDateNew() {
        return dateNew;
    }

    public void setDateNew(Date dateNew) {
        this.dateNew = dateNew;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getCustomerSearchKey() {
        return customerSearchKey;
    }

    public void setCustomerSearchKey(String customerSearchKey) {
        this.customerSearchKey = customerSearchKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumChairs() {
        return numChairs;
    }

    public void setNumChairs(int numChairs) {
        this.numChairs = numChairs;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}