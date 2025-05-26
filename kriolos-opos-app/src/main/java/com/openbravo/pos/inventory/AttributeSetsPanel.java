// ..

package com.openbravo.pos.inventory;

import com.openbravo.data.loader.Datas;
import com.openbravo.data.model.*;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.format.Formats;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.panels.JPanelTable2;

//file format
public class AttributeSetsPanel extends JPanelTable2 {

    private EditorRecord editor;

    /** Creates a new instance of JPanelCategories */
    public AttributeSetsPanel() {
    }

    /**
     *
     */
    @Override
    protected void init() {

        row = new Row(
                new Field("ID", Datas.STRING, Formats.STRING),
                new Field(AppLocal.getIntString("label.name"), Datas.STRING, Formats.STRING, true, true, true)
        );

        Table table = new Table(
                "attributeset",
                new PrimaryKey("ID"),
                new Column("NAME"));

        lpr = row.getListProvider(app.getSession(), table);
        spr = row.getSaveProvider(app.getSession(), table);

        editor = new AttributeSetsEditor(dirty);
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
        return AppLocal.getIntString("Menu.AttributeSets");
    }
}
