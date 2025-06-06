// ..

package com.openbravo.pos.customers;

import com.openbravo.basic.BasicException;
import com.openbravo.data.gui.ListCellRendererBasic;
import com.openbravo.data.loader.ComparatorCreator;
import com.openbravo.data.loader.Vectorer;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.ListProviderCreator;
import com.openbravo.data.user.SaveProvider;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.panels.JPanelTable;
import javax.swing.ListCellRenderer;

//file format
public class CustomersPanel extends JPanelTable {

    private static final long serialVersionUID = 1L;
    
    private DataLogicCustomers dlCustomers;
    private CustomersView jeditor;
    
    public CustomersPanel() {}

    @Override
    protected void init() {
        this.jeditor = new CustomersView(app, dirty);
        this.dlCustomers  = (DataLogicCustomers) app.getBean("com.openbravo.pos.customers.DataLogicCustomers");
    }

    @Override
    public void activate() throws BasicException {     
        super.activate();
        jeditor.activate();     
    }

    @Override
    public ListProvider getListProvider() {
        return new ListProviderCreator(dlCustomers.getTableCustomers());
    }

    @Override
    public SaveProvider getSaveProvider() {
        return dlCustomers.getCustomerSaveProvider();
        /*return new DefaultSaveProvider(dlCustomers.getTableCustomers(), new int[] {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,            
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26});  
       */
    }

    @Override
    public Vectorer getVectorer() {
        return dlCustomers.getTableCustomers().getVectorerBasic(new int[]{1, 2, 3, 4});
    }

    @Override
    public ComparatorCreator getComparatorCreator() {
        return dlCustomers.getTableCustomers().getComparatorCreator(new int[] {1, 2, 3, 4});
    }

    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(dlCustomers.getTableCustomers().getRenderStringBasic(new int[]{3}));
    }

    @Override
    public EditorRecord getEditor() {
        return jeditor;
    }

    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.CustomersManagement");
    }    
}
