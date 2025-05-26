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
public class LocationsPanel extends JPanelTable {
    
    private TableDefinition tlocations;
    private LocationsView jeditor;
    
    /** Creates a new instance of LocationsPanel */
    public LocationsPanel() {
    }
    
    /**
     *
     */
    @Override
    protected void init() {   
        DataLogicSales dlSales = (DataLogicSales) app.getBean("com.openbravo.pos.forms.DataLogicSales");          
        tlocations = dlSales.getTableLocations();
        jeditor = new LocationsView(dirty);
    }
    
    /**
     *
     * @return
     */
    @Override
    public ListProvider getListProvider() {
        return new ListProviderCreator(tlocations);
    }
    
    /**
     *
     * @return
     */
    @Override
    public DefaultSaveProvider getSaveProvider() {
        return new DefaultSaveProvider(tlocations);        
    }
    
    /**
     *
     * @return
     */
    @Override
    public Vectorer getVectorer() {
        return tlocations.getVectorerBasic(new int[]{1, 2});
    }
    
    /**
     *
     * @return
     */
    @Override
    public ComparatorCreator getComparatorCreator() {
        return tlocations.getComparatorCreator(new int[] {1, 2});
    }
    
    /**
     *
     * @return
     */
    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tlocations.getRenderStringBasic(new int[]{1}));
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
        return AppLocal.getIntString("Menu.Locations");
    }      
}
