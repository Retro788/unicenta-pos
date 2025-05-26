// ..

package com.openbravo.data.model;

import com.openbravo.data.loader.Datas;
import com.openbravo.format.Formats;

/**
 *
 * @author adrian
 */
public class Field {
    
    private String label;
    private Datas data;
    private Formats format;
    
    private boolean searchable;
    private boolean comparable;
    private boolean title;
    
    /**
     *
     * @param label
     * @param data
     * @param format
     * @param title
     * @param searchable
     * @param comparable
     */
    public Field(String label, Datas data, Formats format, boolean title, boolean searchable, boolean comparable) {
        this.label = label;
        this.data = data;
        this.format = format;
        this.title = title;
        this.searchable = searchable;
        this.comparable = comparable;             
    }
    
    /**
     *
     * @param label
     * @param data
     * @param format
     */
    public Field(String label, Datas data, Formats format) {
        this(label, data, format, false, false, false);
    }
    
    /**
     *
     * @return
     */
    public String getLabel() {
        return label;
    }
    
    /**
     *
     * @return
     */
    public Formats getFormat() {
        return format;
    }
    
    /**
     *
     * @return
     */
    public Datas getData() {
        return data;
    }
    
    /**
     *
     * @return
     */
    public boolean isSearchable() {
        return searchable;
    }
    
    /**
     *
     * @return
     */
    public boolean isComparable() {
        return comparable;
    }
    
    /**
     *
     * @return
     */
    public boolean isTitle() {
        return title;
    }    
}
