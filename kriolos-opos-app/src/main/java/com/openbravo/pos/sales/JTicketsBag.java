// ..

package com.openbravo.pos.sales;

import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.forms.DataLogicSales;
import com.openbravo.pos.sales.restaurant.JTicketsBagRestaurantMap;
import com.openbravo.pos.sales.shared.JTicketsBagShared;
import com.openbravo.pos.sales.simple.JTicketsBagSimple;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author JG uniCenta
 */
public abstract class JTicketsBag extends JPanel {
    
    protected final static System.Logger LOGGER = System.getLogger(JTicketsBag.class.getName());
    /**
     *
     */
    protected AppView m_App;     

    /**
     *
     */
    protected DataLogicSales m_dlSales;

    /**
     *
     */
    protected TicketsEditor m_panelticket;    
    
    /**
     * 
     * @param oApp
     * @param panelticket 
     */
    public JTicketsBag(AppView oApp, TicketsEditor panelticket) {        
        m_App = oApp;     
        m_panelticket = panelticket;        
        m_dlSales = (DataLogicSales) m_App.getBean("com.openbravo.pos.forms.DataLogicSales");
    }
    
    /**
     * Active panel (Call on active panel)
     */
    public abstract void activate();

    /**
     * Desactive panel (Call on Desactive)
     * @return
     */
    public abstract boolean deactivate();

    /**
     * Delete Current tocket
     */
    public abstract void deleteTicket();
    
    /**
     *
     * @return
     */
    protected abstract JComponent getBagComponent();

    /**
     *
     * @return
     */
    protected abstract JComponent getNullComponent();
    
    /**
     *
     * @param sName
     * @param app
     * @param panelticket
     * @return
     */
    public static JTicketsBag createTicketsBag(String sName, AppView app, TicketsEditor panelticket) {
        switch (sName) {
            case "standard":
                return new JTicketsBagShared(app, panelticket);
            case "restaurant":
                return new JTicketsBagRestaurantMap(app, panelticket);
            case "simple":
            default:
                return new JTicketsBagSimple(app, panelticket);
            
        }
    }   
}