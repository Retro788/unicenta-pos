// ..

package com.openbravo.pos.forms;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

//file format
public class MenuPanelAction extends AbstractAction {

    private final AppUserView m_App;
    private final String m_sMyView;

    /** Creates a new instance of MenuPanelAction
     * @param app
     * @param icon
     * @param keytext
     * @param sMyView */
    public MenuPanelAction(AppUserView app, String icon, String keytext, String sMyView) {
        putValue(Action.SMALL_ICON, new ImageIcon(MenuPanelAction.class.getResource(icon)));
        putValue(Action.NAME, AppLocal.getIntString(keytext));
        putValue(Action.SHORT_DESCRIPTION, AppLocal.getIntString(keytext)); //used for tooltip text.
        putValue(AppUserView.ACTION_TASKNAME, sMyView);
        m_App = app;
        m_sMyView = sMyView;
    }
    @Override
    public void actionPerformed(ActionEvent evt) {

        m_App.showTask(m_sMyView);            
    }    
}
