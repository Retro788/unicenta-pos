// ..

package com.openbravo.pos.sales.restaurant;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.IKeyed;
import com.openbravo.data.loader.SerializableRead;

/**
 *
 * @author adrianromero
 * Created on 26 de febrero de 2007, 23:49
 *
 */
public class FloorsInfo implements SerializableRead, IKeyed {
    
    private static final long serialVersionUID = 8906929819402L;
    
    private String id;
    private String name;
    
    /** Creates a new instance of FloorsInfo */
    public FloorsInfo() {
        id = null;
        name = null;
    }
   
    /**
     *
     * @return
     */
    @Override
    public Object getKey() {
        return id;
    }

    @Override
    public void readValues(DataRead dr) throws BasicException {
        id = dr.getString(1);
        name = dr.getString(2);
    }

    public void setID(String sID) {
        id = sID;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String sName) {
        name = sName;
    } 
    
    @Override
    public String toString(){
        return name;
    }       
}
