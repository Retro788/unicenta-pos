// ..

package com.openbravo.pos.sales;

import com.openbravo.pos.forms.AppView;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class KitchenDisplay {

    private final static Logger LOGGER = Logger.getLogger(KitchenDisplay.class.getName());

    private final AppView m_App;

    /**
     *
     * @param oApp
     */
    public KitchenDisplay(AppView oApp) {
        m_App = oApp;
    }

    /**
     *
     * @param ID
     * @param table
     * @param pickupID
     * @param product
     * @param multiply
     * @param attributes
     */
    public void addRecord(String ID, String table, String pickupID, String product, String multiply, String attributes) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();

        try {
            String SQL = "INSERT INTO KITCHENDISPLAY (ID, ORDERTIME, PLACE, PICKUPID, PRODUCT, MULTIPLY, ATTRIBUTES) VALUES (?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement pstmt = m_App.getSession().getConnection().prepareStatement(SQL);
            pstmt.setString(1, ID);
            pstmt.setString(2, dateFormat.format(date));
            pstmt.setString(3, table);
            pstmt.setString(4, pickupID);
            pstmt.setString(5, product);
            pstmt.setString(6, multiply);
            pstmt.setString(7, attributes);
            pstmt.executeUpdate();
            m_App.getSession().getConnection().commit();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "", e);
        }
    }

}
