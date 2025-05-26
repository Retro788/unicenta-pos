// ..

package com.openbravo.pos.sales.simple;

import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.sales.*;
import com.openbravo.pos.sales.shared.JTicketsBagShared;

/**
 *
 * @author JG uniCenta
 */
public class JTicketsBagSimple extends JTicketsBagShared {
    
    /**
     * 
     * @param app
     * @param panelticket 
     */
    public JTicketsBagSimple(AppView app, TicketsEditor panelticket) {
        super(app, panelticket);
        this.setEnabledPanel(true);
        this.disableAllButtons();
        this.setEnabledButtonDel(true);
    }

 
    
}
