// ..

package com.openbravo.pos.inventory;

import com.openbravo.format.Formats;
import com.openbravo.pos.suppliers.SupplierInfo;
import com.openbravo.pos.util.StringUtils;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


//file format
public class InventoryRecord {
    
    private final Date m_dDate;
    private final MovementReason m_reason;
    private final LocationInfo m_locationOri;   
    private final List<InventoryLine> m_invlines;
    private final String user;
    private final SupplierInfo m_Supplier;
    private final String m_SupplierDoc;
    
    /** Creates a new instance of InventoryRecord
     * @param d
     * @param reason
     * @param location
     * @param invlines
     * @param currentUser
     * @param supplier
     * @param supplierdoc
     */
    public InventoryRecord(Date d, MovementReason reason, 
            LocationInfo location, String currentUser, 
            SupplierInfo supplier,
            List<InventoryLine> invlines, String supplierdoc) {

        m_dDate = d;
        m_reason = reason;
        m_locationOri = location;
        m_invlines = invlines;
        user = currentUser;
        m_Supplier = supplier;
        m_SupplierDoc = supplierdoc;
        
    }
    
    
    /**
     *
     * @return
     */
    public Date getDate() {
        return m_dDate;
    }   
    /**
     *
     * @return
     */
    public String printDate() {
        return Formats.TIMESTAMP.formatValue(m_dDate);
    }   
    
    /**
     *
     * @return
     */
    public MovementReason getReason() {
        return m_reason;
    }        
    /**
     *
     * @return
     */
    public String printReason() {
        return StringUtils.encodeXML(m_reason.toString());
    }  
    
    /**
     *
     * @return
     */
    public String getUser() {
        return user;
    }
    public String printUser() {
        return StringUtils.encodeXML(user.toString());
    }      

    /**
     *
     * @return
     */
    public LocationInfo getLocation() {
        return m_locationOri;
    }
    /**
     *
     * @return
     */
    public String printLocation() {
        return StringUtils.encodeXML(m_locationOri.toString());
    }    
    
    /**
     *
     * @return
     */
    public SupplierInfo getSupplier() {
        return m_Supplier;
    }    
    public String printSupplier() {
        return StringUtils.encodeXML(m_Supplier.toString());
    }  
    
    /**
     *
     * @return
     */
    public String getSupplierDoc() {
        return m_SupplierDoc;
    }    
    public String printSupplierDoc() {
        return StringUtils.encodeXML(m_SupplierDoc.toString());
    }     
       
    /**
     *
     * @return
     */
    public List<InventoryLine> getLines() {
        return m_invlines;
    }

    /**
     *
     * @return
     */
    public boolean isInput() {
        return m_reason.isInput();
    }
    
    /**
     *
     * @return
     */
    public double getSubTotal() {
        double dSuma = 0.0;
        InventoryLine oLine;            
        for (Iterator<InventoryLine> i = m_invlines.iterator(); i.hasNext();) {
            oLine = i.next();
            dSuma += oLine.getSubValue();
        }        
        return dSuma;
    }
    /**
     *
     * @return
     */
    public String printSubTotal() {
        return Formats.CURRENCY.formatValue(getSubTotal());
    }    

    /**
     *
     * @return
     */
    public double getTotalArticles() {
        double dSum = 0.0;
        InventoryLine oLine;            
        for (Iterator<InventoryLine> i = m_invlines.iterator(); i.hasNext();) {
            oLine = i.next();
            dSum += oLine.getMultiply();
        }        
        return dSum;
    }
    /**
     *
     * @return
     */
    public String printTotalArticles() {
        return Formats.DOUBLE.formatValue(getTotalArticles());
    }    
}
