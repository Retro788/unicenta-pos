// ..

package com.openbravo.pos.sales.restaurant;

import com.openbravo.data.gui.ListCellRendererBasic;
import com.openbravo.data.loader.Datas;
import com.openbravo.data.loader.TableDefinition;
import com.openbravo.data.loader.Vectorer;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.ListProviderCreator;
import com.openbravo.data.user.DefaultSaveProvider;
import com.openbravo.format.Formats;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.panels.JPanelTable;
import javax.swing.ListCellRenderer;

//file format
public class JPanelFloors extends JPanelTable {
    
    private TableDefinition tfloors;
    private FloorsEditor jeditor;
    
    /** Creates a new instance of JPanelFloors */
    public JPanelFloors() {
    }
    
    /**
     *
     */
    @Override
    protected void init() {
        tfloors = new TableDefinition(app.getSession(),
            "floors"
            , new String[] {"ID", "NAME", "IMAGE"}
            , new String[] {"ID", AppLocal.getIntString("label.name"), "IMAGE"}
            , new Datas[] {Datas.STRING, Datas.STRING, Datas.IMAGE}
            , new Formats[] {Formats.NULL, Formats.STRING}
            , new int[] {0}
        );  
        jeditor = new FloorsEditor(dirty); 
    }
    
    /**
     *
     * @return
     */
    @Override
    public ListProvider getListProvider() {
        return new ListProviderCreator(tfloors);
    }
    
    /**
     *
     * @return
     */
    @Override
    public Vectorer getVectorer() {
        return tfloors.getVectorerBasic(new int[]{1});
    }
    
    /**
     *
     * @return
     */
    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tfloors.getRenderStringBasic(new int[]{1}));
    }
    
    /**
     *
     * @return
     */
    @Override
    public DefaultSaveProvider getSaveProvider() {
        return new DefaultSaveProvider(tfloors);      
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
        return AppLocal.getIntString("Menu.Floors");
    }     
}
