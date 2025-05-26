// ..

package com.openbravo.pos.epm;

/**
 *
 * @author Ali Safdar and Aneeqa Baber
 */
public class Break {

    private String m_sId;
    private String m_sName;
    private String m_sNotes;
    private boolean m_sVisible;

    /**
     *
     * @param id
     * @param name
     * @param notes
     * @param visible
     */
    public Break(String id, String name, String notes,  boolean visible) {
        m_sId = id;
        m_sName = name;
        m_sNotes = notes;
        m_sVisible = visible;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return m_sId;
    }

    /**
     *
     * @param Id
     */
    public void setId(String Id) {
        this.m_sId = Id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return m_sName;
    }

    /**
     *
     * @param Name
     */
    public void setName(String Name) {
        this.m_sName = Name;
    }

    /**
     *
     * @return
     */
    public String getNotes() {
        return m_sNotes;
    }

    /**
     *
     * @param Notes
     */
    public void setNotes(String Notes) {
        this.m_sNotes = Notes;
    }

    /**
     *
     * @return
     */
    public boolean isVisible() {
        return m_sVisible;
    }

    /**
     *
     * @param Visible
     */
    public void setVisible(boolean Visible) {
        this.m_sVisible = Visible;
    }
}
