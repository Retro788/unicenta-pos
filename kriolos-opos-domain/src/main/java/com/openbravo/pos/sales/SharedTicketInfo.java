// ..

package com.openbravo.pos.sales;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.DataWrite;
import com.openbravo.data.loader.SerializableRead;
import com.openbravo.data.loader.SerializableWrite;
import com.openbravo.pos.ticket.TicketInfo;

public class SharedTicketInfo implements SerializableRead, SerializableWrite {
    
    private static final long serialVersionUID = 7640633837719L;

    private String id;
    private String name;
    private String username;
    private String status;
    private Integer pickupId;
    private TicketInfo ticketInfo;


    @Override
    public void readValues(DataRead dr) throws BasicException {
        id = dr.getString(1);
        name = dr.getString(2);
        username = dr.getString(3);
        status = dr.getString(4);  
        pickupId = dr.getInt(5);
        //MISSING READ MEDIUM_BLOB (Object

    }   

    @Override
    public void writeValues(DataWrite dp) throws BasicException {
        dp.setString(1, id);
        dp.setString(2, name);
        dp.setString(3, username);
        dp.setString(4, status);  
        dp.setInt(5, pickupId);  
        dp.setObject(6, ticketInfo);
    }

    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getAppUser() {
        return username;
    }
    
    public String getStatus() {
        return status;  
    }

    public String getUserName() {
        return username;
    }

    public Integer getPickupId() {
        return pickupId;
    }

    public TicketInfo getTicketInfo() {
        return ticketInfo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String UserName) {
        this.username = UserName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPickupId(Integer pickupId) {
        this.pickupId = pickupId;
    }

    public void setTicketInfo(TicketInfo ticketInfo) {
        this.ticketInfo = ticketInfo;
    }
    
    
}
