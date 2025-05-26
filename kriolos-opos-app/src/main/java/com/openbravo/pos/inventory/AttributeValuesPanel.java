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
public class AttributeValuesPanel extends JPanelTable2 {

    private AttributeValuesEditor editor;
    private AttributeFilter filter;

    /**
     *
     */
    @Override
    protected void init() {

        filter = new AttributeFilter();
        filter.init(app);
        filter.addActionListener(new ReloadActionListener());

        row = new Row(
                new Field("ID", Datas.STRING, Formats.STRING),
                new Field("ATTRIBUTE_ID", Datas.STRING, Formats.STRING),
                new Field(AppLocal.getIntString("label.value"), Datas.STRING, Formats.STRING, true, true, true)
        );

        Table table = new Table(
                "attributevalue",
                new PrimaryKey("ID"),
                new Column("ATTRIBUTE_ID"),
                new Column("VALUE"));

        lpr = row.getListProvider(app.getSession(),
                "SELECT ID, ATTRIBUTE_ID, VALUE FROM attributevalue WHERE ATTRIBUTE_ID = ? ORDER BY VALUE ", filter);
        spr = row.getSaveProvider(app.getSession(), table);

        editor = new AttributeValuesEditor(dirty);
    }

    /**
     *
     * @throws BasicException
     */
    @Override
    public void activate() throws BasicException {
        super.activate();
        filter.activate();
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

        String attid = (String) filter.createValue();
        editor.setInsertId(attid); // must be set before load
        bd.setEditable(attid != null);
        bd.actionLoad();
    }

    /**
     *
     * @return
     */
    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.AttributeValues");
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