// ..

package com.openbravo.pos.inventory;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.Datas;
import com.openbravo.data.model.*;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.format.Formats;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.panels.JPanelTable2;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//file format
public class AttributeUsePanel extends JPanelTable2 {

    private AttributeUseEditor editor;
    private AttributeSetFilter filter;

    /**
     *
     */
    @Override
    protected void init() {

        filter = new AttributeSetFilter();
        filter.init(app);
        filter.addActionListener(new ReloadActionListener());

        row = new Row(
                new Field("ID", Datas.STRING, Formats.STRING),
                new Field("ATRIBUTESET_ID", Datas.STRING, Formats.STRING),
                new Field("ATTRIBUTE_ID", Datas.STRING, Formats.STRING),
                new Field(AppLocal.getIntString("label.order"), Datas.INT, Formats.INT, false, true, true),
                new Field(AppLocal.getIntString("label.name"), Datas.STRING, Formats.STRING, true, true, true)
        );

        Table table = new Table(
                "attributeuse",
                new PrimaryKey("ID"),
                new Column("attributeset_ID"),
                new Column("ATTRIBUTE_ID"),
                new Column("LINENO"));

        lpr = row.getListProvider(app.getSession(),
                "SELECT ATTUSE.ID, ATTUSE.attributeset_ID, ATTUSE.ATTRIBUTE_ID, ATTUSE.LINENO, ATT.NAME " +
                "FROM attributeuse ATTUSE, attribute ATT " +
                "WHERE ATTUSE.ATTRIBUTE_ID = ATT.ID AND ATTUSE.attributeset_ID = ? ORDER BY LINENO", filter);
        spr = row.getSaveProvider(app.getSession(), table);

        editor = new AttributeUseEditor(app, dirty);
    }

    /**
     *
     * @throws BasicException
     */
    @Override
    public void activate() throws BasicException {
        filter.activate();
        editor.activate();
        super.activate();
        reload();
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

    private void reload() throws BasicException {

        String attsetid = (String) filter.createValue();
        editor.setInsertId(attsetid); // must be set before load
        bd.setEditable(attsetid != null);
        bd.actionLoad();
    }

    /**
     *
     * @return
     */
    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.AttributeUse");
    }

    private class ReloadActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                reload();
            } catch (BasicException w) {
            }
        }
    }
}
