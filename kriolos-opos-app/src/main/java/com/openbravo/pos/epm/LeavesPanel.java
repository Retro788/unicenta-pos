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
public class LeavesPanel extends JPanelTable {

    private TableDefinition tleaves;
    private LeavesView jeditor;

    /** Creates a new instance of LeavesPanel */
    public LeavesPanel() {
    }

    /**
     *
     */
    @Override
    protected void init() {
        DataLogicPresenceManagement dlPresenceManagement  = (DataLogicPresenceManagement) app.getBean("com.openbravo.pos.epm.DataLogicPresenceManagement");
        tleaves = dlPresenceManagement.getTableLeaves();
        jeditor = new LeavesView(app, dirty);
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
        return new ListProviderCreator(tleaves);
    }

    /**
     *
     * @return
     */
    @Override
    public DefaultSaveProvider getSaveProvider() {
        return new DefaultSaveProvider(tleaves, new int[] {0, 1, 2, 3, 4, 5});
    }

    /**
     *
     * @return
     */
    @Override
    public Vectorer getVectorer() {
        return tleaves.getVectorerBasic(new int[]{2, 5});
    }

    /**
     *
     * @return
     */
    @Override
    public ComparatorCreator getComparatorCreator() {
        return tleaves.getComparatorCreator(new int[] {2, 3, 4, 5});
    }

    /**
     *
     * @return
     */
    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tleaves.getRenderStringBasic(new int[]{2}));
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
        return AppLocal.getIntString("Menu.Leaves");
    }
}
