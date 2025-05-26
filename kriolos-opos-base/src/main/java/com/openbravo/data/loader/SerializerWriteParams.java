// ..
package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;
import java.util.logging.Level;
import java.util.logging.Logger;

//file format
public class SerializerWriteParams implements SerializerWrite<DataParams> {

    private final static Logger LOGGER = Logger.getLogger(SerializerWriteParams.class.getName());
    public static final SerializerWrite INSTANCE = new SerializerWriteParams();

    @Override
    public void writeValues(DataWrite dp, DataParams obj) throws BasicException {

        try {
            obj.setDataWrite(dp);
            obj.writeValues();
            obj.setDataWrite(null);

        } catch (Exception ex) {
            LOGGER.log(Level.WARNING, "Exception while set DataParams",ex);
            throw new BasicException(ex);
        }
    }
}
