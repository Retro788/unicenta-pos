// ..

package com.openbravo.data.user;

import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import java.beans.*;

/**
 *
 * @author  adrian
 */
public class DirtyManager implements DocumentListener, ChangeListener, ActionListener, PropertyChangeListener {
    
    private boolean m_bDirty;    

    /**
     *
     */
    private final List<DirtyListener> listeners = new ArrayList();
    
    /** Creates a new instance of DirtyManager */
    public DirtyManager() {
        m_bDirty = false;
    }
    
    /**
     *
     * @param l
     */
    public void addDirtyListener(DirtyListener l) {
        listeners.add(l);
    }

    /**
     *
     * @param l
     */
    public void removeDirtyListener(DirtyListener l) {
        listeners.remove(l);
    }

    /**
     *
     */
    protected void fireChangedDirty() {
        
        listeners.stream().forEach((DirtyListener listener) -> {
            listener.changedDirty(m_bDirty);
        });
    }
    
    /**
     *
     * @param bValue
     */
    public void setDirty(boolean bValue) {
        
        if (m_bDirty != bValue) {
            m_bDirty = bValue;
            fireChangedDirty();
        }
    }

    /**
     *
     * @return
     */
    public boolean isDirty() {
        return m_bDirty;
    }
    
    @Override
    public void changedUpdate(DocumentEvent e) {
        setDirty(true);
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        setDirty(true);
    }    
    @Override
    public void removeUpdate(DocumentEvent e) {
        setDirty(true);
    }    
    
    @Override
    public void stateChanged(ChangeEvent e) {
        setDirty(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        setDirty(true);
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //if ("image".equals(evt.getPropertyName())) {
            setDirty(true);
        //}
    }
    
}
