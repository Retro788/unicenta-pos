// ..

package com.openbravo.pos.epm;

import com.openbravo.data.loader.IKeyed;

/**
 *
 * @author  Ali Safdar and Aneeqa Baber
 */
public class LeavesInfo implements IKeyed {

    private static final long serialVersionUID = 8936482715929L;
    private String m_sID;
    private String m_sName;
    private String m_sEmployeeID;
    private String m_sStartDate;
    private String m_sEndDate;
    private String m_sNotes;


    /** Creates new LeavesInfo
     * @param id
     * @param name
     * @param notes
     * @param startdate
     * @param employeeid
     * @param enddate */
    public LeavesInfo(String id, String name, String employeeid, String startdate, String enddate, String notes) {
        m_sID = id;
        m_sName = name;
        m_sEmployeeID = employeeid;
        m_sStartDate = startdate;
        m_sEndDate = enddate;
        m_sNotes = notes;
    }

    /**
     *
     * @return
     */
    @Override
    public Object getKey() {
        return m_sID;
    }

    /**
     *
     * @param sID
     */
    public void setID(String sID) {
        m_sID = sID;
    }

    /**
     *
     * @return
     */
    public String getID() {
        return m_sID;
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
     * @param sName
     */
    public void setName(String sName) {
        m_sName = sName;
    }

    @Override
    public String toString(){
        return m_sName;
    }

    /**
     *
     * @return
     */
    public String getEmployeeID() {
        return m_sEmployeeID;
    }

    /**
     *
     * @param EmployeeID
     */
    public void setEmployeeID(String EmployeeID) {
        this.m_sEmployeeID = EmployeeID;
    }

    /**
     *
     * @return
     */
    public String getStartDate() {
        return m_sStartDate;
    }

    /**
     *
     * @param StartDate
     */
    public void setStartDate(String StartDate) {
        this.m_sStartDate = StartDate;
    }

    /**
     *
     * @return
     */
    public String getEndDate() {
        return m_sEndDate;
    }

    /**
     *
     * @param EndDate
     */
    public void setEndDate(String EndDate) {
        this.m_sEndDate = EndDate;
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
}
