// ..

package com.openbravo.pos.inventory;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.Datas;
import com.openbravo.data.model.*;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.format.Formats;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.panels.BundleFilter;
import com.openbravo.pos.panels.JPanelTable2;
import com.openbravo.pos.ticket.ProductInfoExt;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Jack
 */
public class BundlePanel extends JPanelTable2 {

    private BundleEditor editor;
    private BundleFilter filter;

    @Override
    protected void init() {  
        
        filter = new BundleFilter();
        filter.init(app);
        filter.addActionListener(new ReloadActionListener());
        
        row = new Row(
                new Field("ID", Datas.STRING, Formats.STRING),
                new Field("PRODUCT", Datas.STRING, Formats.STRING),
                new Field("PRODUCT_BUNDLE", Datas.STRING, Formats.STRING),
                new Field("QUANTITY", Datas.DOUBLE, Formats.DOUBLE),
                new Field(AppLocal.getIntString("label.prodref"), Datas.STRING, Formats.STRING, true, true, true),
                new Field(AppLocal.getIntString("label.prodbarcode"), Datas.STRING, Formats.STRING, false, true, true),
                new Field(AppLocal.getIntString("label.prodname"), Datas.STRING, Formats.STRING, true, true, true)
        );        
        Table table = new Table(
                "products_bundle",
                new PrimaryKey("ID"),
                new Column("PRODUCT"),
                new Column("PRODUCT_BUNDLE"),
                new Column("QUANTITY"));
         
        lpr = row.getListProvider(app.getSession(), 
                "SELECT "
                        + "B.ID, B.PRODUCT, "
                        + "B.PRODUCT_BUNDLE, B.QUANTITY, "
                        + "P.REFERENCE, P.CODE, P.NAME " +
                "FROM products_bundle B, products P " +
                "WHERE B.PRODUCT_BUNDLE = P.ID AND B.PRODUCT = ?", filter);
        spr = row.getSaveProvider(app.getSession(), table);              
        
        editor = new BundleEditor(app, dirty);
    }

    @Override
    public void activate() throws BasicException {
        super.activate();
        filter.activate();
        reload(filter);
    }

    @Override
    public Component getFilter(){
        return filter.getComponent();
    }
    
    @Override
    public EditorRecord getEditor() {
        return editor;
    }  
    
    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.Bundle");
    } 
    
    private void reload(BundleFilter filter) throws BasicException {
        ProductInfoExt prod = filter.getProductInfoExt();
        editor.setInsertProduct(prod);
        bd.setEditable(prod != null);
        bd.actionLoad();
    }
            
    private class ReloadActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                reload((BundleFilter) e.getSource());
            } catch (BasicException w) {
            }
        }
    }
}