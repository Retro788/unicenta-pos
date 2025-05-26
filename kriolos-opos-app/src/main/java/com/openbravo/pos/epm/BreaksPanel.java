// ..

package com.openbravo.pos.epm;

import com.openbravo.basic.BasicException;
import com.openbravo.data.gui.ListCellRendererBasic;
import com.openbravo.data.loader.ComparatorCreator;
import com.openbravo.data.loader.TableDefinition;
import com.openbravo.data.loader.Vectorer;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.ListProviderCreator;
import com.openbravo.data.user.DefaultSaveProvider;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.panels.JPanelTable;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Ali Safdar and Aneeqa Baber
 */
public class BreaksPanel extends JPanelTable {

    private TableDefinition tbreaks;
    private BreaksView jeditor;

    /**
     *
     */
    public BreaksPanel() {
    }

    /**
     *
     */
    @Override
    protected void init() {
        DataLogicPresenceManagement dlPresenceManagement  = (DataLogicPresenceManagement) app.getBean("com.openbravo.pos.epm.DataLogicPresenceManagement");
        tbreaks = dlPresenceManagement.getTableBreaks();
        jeditor = new BreaksView(app, dirty);
    }

    /**
     *
     * @throws BasicException
     */
    @Override
    public void activate() throws BasicException {

        jeditor.activate();
        super.activate();
    }

    /**
     *
     * @return
     */
    @Override
    public ListProvider getListProvider() {
        return new ListProviderCreator(tbreaks);
    }

    /**
     *
     * @return
     */
    @Override
    public DefaultSaveProvider getSaveProvider() {
        return new DefaultSaveProvider(tbreaks, new int[] {0, 1, 2, 3});
    }

    /**
     *
     * @return
     */
    @Override
    public Vectorer getVectorer() {
        return tbreaks.getVectorerBasic(new int[]{1, 2});
    }

    /**
     *
     * @return
     */
    @Override
    public ComparatorCreator getComparatorCreator() {
        return tbreaks.getComparatorCreator(new int[] {1, 2});
    }

    /**
     *
     * @return
     */
    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tbreaks.getRenderStringBasic(new int[]{1}));
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
        return AppLocal.getIntString("Menu.Breaks");
    }
}
