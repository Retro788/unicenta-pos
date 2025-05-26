// ..
package com.openbravo.pos.reports;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.BaseSentence;
import com.openbravo.data.loader.DataResultSet;
import com.openbravo.pos.forms.AppLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author JG uniCenta
 */
public class JRDataSourceBasic implements JRDataSource {

    private static final Logger LOGGER = Logger.getLogger(JRDataSourceBasic.class.getName());

    private BaseSentence sent;
    private DataResultSet SRS = null;
    private Object current = null;

    private ReportFields m_fields = null;

    /**
     * Creates a new instance of JRDataSourceBasic
     *
     * @param sent
     * @param fields
     * @param params
     * @throws com.openbravo.basic.BasicException
     */
    public JRDataSourceBasic(BaseSentence sent, ReportFields fields, Object params) throws BasicException {

        this.sent = sent;
        SRS = sent.openExec((Object[])params);
        m_fields = fields;
    }

    /**
     *
     * @param jrField
     * @return
     * @throws JRException
     */
    @Override
    public Object getFieldValue(JRField jrField) throws JRException {

        try {
            return m_fields.getField(current, jrField.getName());
        } catch (ReportException ex) {
            LOGGER.log(Level.SEVERE, "Exception on JRDataSourceBasic", ex);
            throw new JRException(ex);
        }
    }

    /**
     *
     * @return @throws JRException
     */
    @Override
    public boolean next() throws JRException {

        if (SRS == null) {
            LOGGER.log(Level.SEVERE, "SRS is null");
            throw new JRException(AppLocal.getIntString("exception.unavailabledataset"));
        }

        try {
            if (SRS.next()) {
                current = SRS.getCurrent();
                return true;
            } else {
                current = null;
                SRS = null;
                sent.closeExec();
                sent = null;
                return false;
            }
        } catch (BasicException e) {
            LOGGER.log(Level.SEVERE, "Exception on JRDataSourceBasic", e);
            throw new JRException(e);
        }
    }
}
