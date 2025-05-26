// ..

package com.openbravo.pos.admin;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.IKeyed;
import com.openbravo.data.loader.SerializableRead;

/**
 *
 * @author adrianromero
 * Created on 27 de febrero de 2007, 23:27
 *
 */
public class PeopleInfo implements SerializableRead, IKeyed {
    
    private static final long serialVersionUID = 9110127845966L;
    private String id;
    private String name;
    
    public PeopleInfo() {
        id = null;
        name = null;
    }

    @Override
    public Object getKey() {
        return id;
    }

    @Override
    public void readValues(DataRead dr) throws BasicException {
        id = dr.getString(1);
        name = dr.getString(2);
    }

    public String getID() {
        return id;
    }
    public void setID(String sID) {
        id = sID;
    }

    public String getName() {
        return name;
    }

    public void setName(String sValue) {
        name = sValue;
    }    
    
    @Override
    public String toString() {
        return name;
    }
}
