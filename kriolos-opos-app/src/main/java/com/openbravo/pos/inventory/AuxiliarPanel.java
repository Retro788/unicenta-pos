// ..

package com.openbravo.pos.inventory;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.Datas;
import com.openbravo.data.model.*;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.format.Formats;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.panels.AuxiliarFilter;
import com.openbravo.pos.panels.JPanelTable2;
import com.openbravo.pos.ticket.ProductInfoExt;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jaroslawwozniak
 * @author adrianromero
 */
public class AuxiliarPanel extends JPanelTable2 {

    private AuxiliarEditor editor;
    private AuxiliarFilter filter;

    /**
     *
     */
    @Override
    protected void init() {  
        
        filter = new AuxiliarFilter();
        filter.init(app);
        filter.addActionListener(new ReloadActionListener());
        
        row = new Row(
                new Field("ID", Datas.STRING, Formats.STRING),
                new Field("PRODUCT1", Datas.STRING, Formats.STRING),
                new Field("PRODUCT2", Datas.STRING, Formats.STRING),
                new Field(AppLocal.getIntString("label.prodref"), Datas.STRING, Formats.STRING, true, true, true),
                new Field(AppLocal.getIntString("label.prodbarcode"), Datas.STRING, Formats.STRING, false, true, true),
                new Field(AppLocal.getIntString("label.prodname"), Datas.STRING, Formats.STRING, true, true, true)
        );        
        Table table = new Table(
                "products_com",
                new PrimaryKey("ID"),
                new Column("PRODUCT"),
                new Column("PRODUCT2"));
         
        lpr = row.getListProvider(app.getSession(), 
                "SELECT COM.ID, COM.PRODUCT, COM.PRODUCT2, P.REFERENCE, P.CODE, P.NAME " +
                "FROM products_com COM, products P " +
                "WHERE COM.PRODUCT2 = P.ID AND COM.PRODUCT = ?", filter);
        spr = row.getSaveProvider(app.getSession(), table);              
        
        editor = new AuxiliarEditor(app, dirty);
    }

    /**
     *
     * @throws BasicException
     */
    @Override
    public void activate() throws BasicException {
        super.activate();
        filter.activate();
        reload(filter);
    }

    /**
     *
     * @return
     */
    @Override
    public Component getFilter(){
        return filter.getComponent();
    }
    
    /**
     *
     * @return
     */
    @Override
    public EditorRecord getEditor() {
        return editor;
    }

    /**
     *
     * @return
     */
    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.Auxiliar");
    } 
    
    private void reload(AuxiliarFilter filter) throws BasicException {
        ProductInfoExt prod = filter.getProductInfoExt();
        editor.setInsertProduct(prod); // must be set before load
        bd.setEditable(prod != null);
        bd.actionLoad();
    }
            
    private class ReloadActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                reload((AuxiliarFilter) e.getSource());
            } catch (BasicException w) {
            }
        }
    }
}
