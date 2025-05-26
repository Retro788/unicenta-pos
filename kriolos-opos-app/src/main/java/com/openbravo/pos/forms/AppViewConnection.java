// ..
package com.openbravo.pos.forms;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.Session;
import com.openbravo.pos.util.AltEncrypter;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

//file format
public class AppViewConnection {

    private static final Logger LOGGER = Logger.getLogger(AppViewConnection.class.getName());
    private static final int MAX_BD = 10;

    private AppViewConnection() {
    }

    public static Session createSession(AppProperties props) throws BasicException {
       return  createSession(null, props);
    }
    
    public static Session createSession(Component parent, AppProperties props) throws BasicException{
    try {
            String dbURL = "";
            String sDBUser = "";
            String sDBPassword = "";
            DBProperties dbProperties = null;

            String dbID = "db";
            if ("true".equals(props.getProperty("db.multi"))) {
                
                List<String> dbNames = findAllDB(props);

                //expec db.name=DBMain or db1.name=DBSecond
                String chosedDbName = choseDB(parent, props, dbNames.toArray());
                LOGGER.log(Level.INFO, "Database Selected: "+chosedDbName);
                if(chosedDbName !=  null){
                    String[] dbNameParts = chosedDbName.split("[.]", 0);
                    //get prefix
                    if (dbNameParts != null && dbNameParts.length >= 2) {
                        dbID = dbNameParts[0];
                    }
                }
            }
            dbProperties = getDBProperties(props, dbID);

            sDBUser = dbProperties.sDBUser;
            sDBPassword = dbProperties.sDBPassword;
            dbURL = dbProperties.dbURL;
            
            LOGGER.log(Level.INFO, "Creae session for DB: "+dbURL);

            return new Session(dbURL, sDBUser, sDBPassword);

        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "Exception on session ", ex);
            throw new BasicException(AppLocal.getIntString("message.databaseconnectionerror"), ex);
        }
    }

    private static List<String> findAllDB(AppProperties props) {

        List<String> dbNames = new ArrayList<>();

        var defaulName = props.getProperty("db.name");
        dbNames.add("db.name="+defaulName); // Add defaul Data base

        for (int count = 1; count < MAX_BD; count++) {

            String curDbKey = "db" + count + ".name";
            String curName = props.getProperty(curDbKey);

            if (curName != null) {
                dbNames.add(curDbKey+"="+curName);
            }
        }

        return dbNames;
    }

    private static String choseDB(Component parent, AppProperties props, Object[] dbs) {

        ImageIcon icon = new ImageIcon("/com/openbravo/images/app_logo_48x48");
        Object chosedDbName = JOptionPane.showInputDialog(
                parent,
                AppLocal.getIntString("message.databasechoose"),
                "Database Selection",
                JOptionPane.OK_OPTION,
                icon,
                dbs,
                dbs[0]);

        return (String) chosedDbName;
    }

    private static DBProperties getDBProperties(AppProperties props, String dbID) {

        final DBProperties dbProps = new DBProperties();

        dbProps.sDBUser = props.getProperty(dbID + ".user");
        dbProps.sDBPassword = props.getProperty(dbID + ".password");
        if (dbProps.sDBUser != null && dbProps.sDBPassword != null && dbProps.sDBPassword.startsWith("crypt:")) {
            AltEncrypter cypher = new AltEncrypter("cypherkey" + dbProps.sDBUser);
            dbProps.sDBPassword = cypher.decrypt(dbProps.sDBPassword.substring(6));
        }

        dbProps.dbURL = props.getProperty(dbID + ".URL")
                + props.getProperty(dbID + ".schema")
                + props.getProperty(dbID + ".options");

        return dbProps;
    }

    private static class DBProperties {

        public String dbURL = null;
        public String sDBUser = null;
        public String sDBPassword = null;

        public String toString() {
            return "URL: " + dbURL + ", USER: " + sDBUser + ", PASS: " + sDBPassword;
        }
    }
}
