// ..

package com.openbravo.pos.panels;

import com.openbravo.basic.BasicException;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.DefaultSaveProvider;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.DataLogicSales;

//file format
public class JPanelPayments extends JPanelTable {
    
    private PaymentsEditor jeditor;    
    private DataLogicSales m_dlSales = null;
    
    /** Creates a new instance of JPanelPayments */
    public JPanelPayments() {
    }
    
    /**
     *
     */
    @Override
    protected void init() {
        m_dlSales = (DataLogicSales) app.getBean("com.openbravo.pos.forms.DataLogicSales");         
        jeditor = new PaymentsEditor(app, dirty);    
    }
    
    /**
     *
     * @return
     */
    @Override
    public ListProvider getListProvider() {
        return null;
    }
    
    /**
     *
     * @return
     */
    @Override
    public DefaultSaveProvider getSaveProvider() {
        return  new DefaultSaveProvider(null
                , m_dlSales.getPaymentMovementInsert()
                , m_dlSales.getPaymentMovementDelete());
    }
    
    /**
     *
     * @return
     */
    @Override
    public EditorRecord getEditor() {
        return jeditor;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.Payments");
    }    
    
    @Override
    public void activate() throws BasicException {         
        super.activate();
    }
    
    @Override
    public boolean deactivate() {
        return super.deactivate();
    }
}
