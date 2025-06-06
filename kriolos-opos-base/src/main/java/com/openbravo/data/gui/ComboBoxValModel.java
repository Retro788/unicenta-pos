// ..

package com.openbravo.data.gui;

import com.openbravo.data.loader.IKeyGetter;
import com.openbravo.data.loader.KeyGetterBuilder;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author  adrian
 */
public class ComboBoxValModel<E> extends AbstractListModel<E> implements ComboBoxModel<E> {  
   
    private List<E> m_aData;
    private IKeyGetter m_keygetter;
    private Object m_selected;
    
    /** Creates a new instance of ComboBoxValModel
     * @param aData
     * @param keygetter */
    public ComboBoxValModel(List<E> aData, IKeyGetter keygetter) {
        m_aData = aData;
        m_keygetter = keygetter;
        m_selected = null;
    }

    /**
     *
     * @param aData
     */
    public ComboBoxValModel(List<E> aData) {
        this(aData, KeyGetterBuilder.INSTANCE);
    }

    /**
     *
     * @param keygetter
     */
    public ComboBoxValModel(IKeyGetter keygetter) {
        this(new ArrayList<>(), keygetter);
    }

    /**
     *
     */
    public ComboBoxValModel() {
        this(new ArrayList<>(), KeyGetterBuilder.INSTANCE);
    }
    
    /**
     *
     * @param c
     */
    public void add(E c) {
        m_aData.add(c);
    }

    /**
     *
     * @param c
     */
    public void del(E c) {
        m_aData.remove(c);
    }

    /**
     *
     * @param index
     * @param c
     */
    public void add(int index, E c) {
        m_aData.add(index, c);
    }
    
    /**
     *
     * @param aData
     */
    public void refresh(List<E> aData) {
        m_aData = aData;
        m_selected = null;
    }
    
    /**
     *
     * @return
     */
    public Object getSelectedKey() {
        if (m_selected == null) {
            return null;
        } else {
            return m_keygetter.getKey(m_selected);  // Si casca, excepcion parriba
        }
    }

    /**
     *
     * @return
     */
    public String getSelectedText() {
        if (m_selected == null) {
            return null;
        } else {
            return m_selected.toString();
        }
    }
    
    /**
     *
     * @param aKey
     */
    public void setSelectedKey(Object aKey) {
        setSelectedItem(getElementByKey(aKey));
    }
    
    /**
     *
     */
    public void setSelectedFirst() {
        m_selected = (m_aData.isEmpty()) ? null : m_aData.get(0);
    }
    
    /**
     *
     * @param aKey
     * @return
     */
    public E getElementByKey(Object aKey) {
        E value = null;
        if (aKey != null) {
            for (E valueEM : m_aData) {
                if (aKey.equals(m_keygetter.getKey(valueEM))) {
                    value = valueEM;
                    break;
                }
            }           
        }
        return value;
    }
    
    @Override
    public E getElementAt(int index) {
        return m_aData.get(index);
    }
    
    @Override
    public Object getSelectedItem() {
        return m_selected;
    }
    
    @Override
    public int getSize() {
        return m_aData.size();
    }   

    @Override
    public void setSelectedItem(Object anItem) {
        
        if ((m_selected != null && !m_selected.equals(anItem)) || m_selected == null && anItem != null) {
            m_selected = anItem;
            fireContentsChanged(this, -1, -1);
        }
    }
    
}
