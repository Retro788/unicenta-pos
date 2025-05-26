// ..

package com.openbravo.pos.sales;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.DataWrite;
import com.openbravo.data.loader.SerializableRead;
import com.openbravo.data.loader.SerializableWrite;

/**
 * @author JG uniCenta
 * Sept 2018
 * Recall + Reprint of last ticket
 * Allows for reprint ticket from any terminal rather than only local
*/
public class ReprintTicketInfo implements SerializableRead, SerializableWrite {
    
    private static final long serialVersionUID = 7640633837719L;
    private String id;
    private String total;
    private String ticketDate;
    private String UserName;

    
    /** Creates a new instance of ReprintTicketInfo */
    public ReprintTicketInfo() {
    }
    
    /**
     *
     * @param dr
     * @throws BasicException
     */
    @Override
    public void readValues(DataRead dr) throws BasicException {
        id = dr.getString(1);
        total = dr.getString(2);
        ticketDate = dr.getString(3);
        UserName = dr.getString(4);

    }   

    /**
     *
     * @param dp
     * @throws BasicException
     */
    @Override
    public void writeValues(DataWrite dp) throws BasicException {
        dp.setString(1, id);
        dp.setString(2, total);
        dp.setString(3, ticketDate);
        dp.setString(4, UserName);       
    }
    
    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }
    
    public String getTotal() {
        return total;
    }
    
    public String getTicketDate() {
        return ticketDate;
    }    
    
    public String getUserName() {
        return UserName;
    }
}