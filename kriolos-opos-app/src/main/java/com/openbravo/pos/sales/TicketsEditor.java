// ..

package com.openbravo.pos.sales;

import com.openbravo.pos.ticket.TicketInfo;

/**
 *
 * @author JG uniCenta
 */
public interface TicketsEditor {
    
    /**
     * Ticket
     * @param oTicket Ticket
     * @param oTicketExt extra information of ticket
     */
    public void setActiveTicket(TicketInfo oTicket, String oTicketExt);

    /**
     *
     * @return
     */
    public TicketInfo getActiveTicket(); 
}
