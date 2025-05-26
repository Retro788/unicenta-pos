// ..

package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

/**
 *
 * @author James Bolongan
 */

public class SerializerReadDate implements SerializerRead {

    /**
     *
     */
    public static final SerializerRead INSTANCE = new SerializerReadDate();

    /** Creates a new instance of SerializerReadImage */
    private SerializerReadDate() {
    }

    /**
     *
     * @param dr
     * @return
     * @throws BasicException
     */
    @Override
    public Object readValues(DataRead dr) throws BasicException {
        return Datas.TIMESTAMP.getValue(dr, 1);
    }
}
