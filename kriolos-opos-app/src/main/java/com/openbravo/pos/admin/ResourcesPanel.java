// ..

package com.openbravo.pos.admin;

import com.openbravo.data.gui.ListCellRendererBasic;
import com.openbravo.data.loader.ComparatorCreator;
import com.openbravo.data.loader.TableDefinition;
import com.openbravo.data.loader.Vectorer;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.ListProviderCreator;
import com.openbravo.data.user.DefaultSaveProvider;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.DataLogicSystem;
import com.openbravo.pos.panels.JPanelTable;
import javax.swing.ListCellRenderer;

//file format
public class ResourcesPanel extends JPanelTable {

    private static final long serialVersionUID = 1L;

    private TableDefinition<ResourceInfo> tresources;
    private ResourcesView jeditor;

    public ResourcesPanel() {}

    @Override
    protected void init() {
        DataLogicAdmin dlAdmin = (DataLogicAdmin) app.getBean("com.openbravo.pos.admin.DataLogicAdmin"); 
        DataLogicSystem dlSystem = (DataLogicSystem) app.getBean("com.openbravo.pos.forms.DataLogicSystem");
        tresources = dlSystem.getTableResources();         
        jeditor = new ResourcesView(dirty);           
    }

    @Override
    public boolean deactivate() {
        return super.deactivate();    
    }

    @Override
    public ListProvider<ResourceInfo> getListProvider() {
        return new ListProviderCreator(tresources);
    }

    @Override
    public DefaultSaveProvider getSaveProvider() {
        return new DefaultSaveProvider(tresources);        
    }

    @Override
    public Vectorer getVectorer() {
        return tresources.getVectorerBasic(new int[] {1});
    }

    @Override
    public ComparatorCreator getComparatorCreator() {
        return tresources.getComparatorCreator(new int[] {1, 2});
    }

    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tresources.getRenderStringBasic(new int[] {1}));
    }

    public EditorRecord getEditor() {
        return jeditor;
    }
 
    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.Resources");
    }        
}
