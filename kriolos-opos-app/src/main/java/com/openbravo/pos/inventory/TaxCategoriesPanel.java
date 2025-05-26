// ..

package com.openbravo.pos.inventory;

import com.openbravo.data.gui.ListCellRendererBasic;
import com.openbravo.data.loader.ComparatorCreator;
import com.openbravo.data.loader.TableDefinition;
import com.openbravo.data.loader.Vectorer;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.ListProviderCreator;
import com.openbravo.data.user.DefaultSaveProvider;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.DataLogicSales;
import com.openbravo.pos.panels.JPanelTable;
import javax.swing.ListCellRenderer;

//file format
public class TaxCategoriesPanel extends JPanelTable {

    private TableDefinition ttaxcategories;
    private TaxCustCategoriesEditor jeditor;
    
    /** Creates a new instance of JPanelDuty */
    public TaxCategoriesPanel() {
    }
    
    /**
     *
     */
    @Override
    protected void init() {
        DataLogicSales dlSales = (DataLogicSales) app.getBean("com.openbravo.pos.forms.DataLogicSales");        
        ttaxcategories = dlSales.getTableTaxCategories();
        jeditor = new TaxCustCategoriesEditor(dirty);
    }
    
    /**
     *
     * @return
     */
    @Override
    public ListProvider getListProvider() {
        return new ListProviderCreator(ttaxcategories);
    }
    
    /**
     *
     * @return
     */
    @Override
    public DefaultSaveProvider getSaveProvider() {
        return new DefaultSaveProvider(ttaxcategories);      
    }
    
    /**
     *
     * @return
     */
    @Override
    public Vectorer getVectorer() {
        return ttaxcategories.getVectorerBasic(new int[]{1});
    }
    
    /**
     *
     * @return
     */
    @Override
    public ComparatorCreator getComparatorCreator() {
        return ttaxcategories.getComparatorCreator(new int[] {1});
    }
    
    /**
     *
     * @return
     */
    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(ttaxcategories.getRenderStringBasic(new int[]{1}));
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
        return AppLocal.getIntString("Menu.TaxCategories");
    }     
}