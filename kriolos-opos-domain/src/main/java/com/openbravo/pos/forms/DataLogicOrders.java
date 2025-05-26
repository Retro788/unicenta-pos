// ..

package com.openbravo.pos.forms;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.*;
import com.openbravo.pos.forms.BeanFactoryDataSingle;

/**
 *
 * @author uniCenta
 */
public class DataLogicOrders extends BeanFactoryDataSingle {
    private SentenceExec m_addOrder;
    private SentenceExec m_resetPickup;
    
    /** Creates a new instance of DataLogicOrders */
    public DataLogicOrders() {            
    }
    
    /**
     *
     * @param s
     */
    @Override
    public void init(Session s){
        
        m_addOrder =  new StaticSentence(s
                , "INSERT INTO orders (orderid, qty, details, attributes, "
                        + "notes, ticketid, ordertime, displayid, auxiliary, "
                        + "completetime) " +
                  "VALUES (?, ?, ?, ?, ?, "
                        + "?, ?, ?, ?, ? ) "
                , new SerializerWriteBasic(new Datas[] {
                    Datas.STRING,   // OrderId
                    Datas.INT,      // Qty
                    Datas.STRING,   // Details
                    Datas.STRING,   // Attributes
                    Datas.STRING,   // Notes
                    Datas.STRING,   // TicketId
                    Datas.TIMESTAMP,   // OrderTime
                    Datas.INT,      // DisplayId
                    Datas.INT,     // Auxiliary
                    Datas.TIMESTAMP    // CompleteTime
                }));

        m_resetPickup =  s.DB.resetSequenceSentence(s, "pickup_number");
    }


    public final void addOrder(String orderId, Integer qty, 
            String details, String attributes, String notes, String ticketId, 
            String ordertime, Integer displayId, String auxiliary, String completetime
        ) throws BasicException {

        m_addOrder.exec(new Object[]{orderId, qty, details, attributes, notes, ticketId, 
                ordertime, displayId, auxiliary, completetime});    
    } 
    
    public final void resetPickup() throws BasicException {
        m_resetPickup.exec();    
    }      
}
