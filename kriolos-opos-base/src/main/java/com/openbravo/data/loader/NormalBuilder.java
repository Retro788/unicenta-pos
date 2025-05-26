// ..
package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JG uniCenta
 */
public class NormalBuilder implements ISQLBuilderStatic {

    private final static Logger LOGGER = Logger.getLogger(NormalBuilder.class.getName());
    private String m_sSentence;

    public NormalBuilder(String sSentence) {
        m_sSentence = sSentence;
    }

    @Override
    public String getSQL(SerializerWrite sw, Object params) throws BasicException {
        String sql = null;
        try {

            NormalParameter mydw = new NormalParameter(m_sSentence);
            if (sw != null) {
                sw.writeValues(mydw, params);
            }
            sql = mydw.getSentence();
        } catch (Exception ex) {
            LOGGER.log(Level.WARNING, "Exception while get SQL String",ex);
            throw new BasicException(ex);
        }

        return sql;
    }
}
