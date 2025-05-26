// ..

package com.openbravo.data.loader;

/**
 *
 * @author  adrian
 */
public abstract class QBFCompareEnum {
    
    /**
     *
     */
    public final static QBFCompareEnum COMP_NONE = new QBFCompareEnum(0, "qbf.none") { 
        @Override
        public String getExpression(String sField, String sSQLValue) { return null; }
    };

    /**
     *
     */
    public final static QBFCompareEnum COMP_ISNULL = new QBFCompareEnum(1, "qbf.null") {
        @Override
        public String getExpression(String sField, String sSQLValue) { return sField + " IS NULL"; }
    };

    /**
     *
     */
    public final static QBFCompareEnum COMP_ISNOTNULL = new QBFCompareEnum(2, "qbf.notnull") {
        @Override
        public String getExpression(String sField, String sSQLValue) { return sField + " IS NOT NULL"; }
    };

    /**
     *
     */
    public final static QBFCompareEnum COMP_RE = new QBFCompareEnum(3, "qbf.re") {
        @Override
        public String getExpression(String sField, String sSQLValue) { return sField + " LIKE " + sSQLValue; }
    };

    /**
     *
     */
    public final static QBFCompareEnum COMP_EQUALS = new QBFCompareEnum(3, "qbf.equals") {
        @Override
        public String getExpression(String sField, String sSQLValue) { return sField + " = " + sSQLValue; }
    };

    /**
     *
     */
    public final static QBFCompareEnum COMP_DISTINCT = new QBFCompareEnum(4, "qbf.distinct") {
        @Override
        public String getExpression(String sField, String sSQLValue) { return sField + " <> " + sSQLValue; }
    };

    /**
     *
     */
    public final static QBFCompareEnum COMP_GREATER = new QBFCompareEnum(5, "qbf.greater") {
        @Override
        public String getExpression(String sField, String sSQLValue) { return sField + " > " + sSQLValue; }
    };

    /**
     *
     */
    public final static QBFCompareEnum COMP_LESS = new QBFCompareEnum(6, "qbf.less") {
        @Override
        public String getExpression(String sField, String sSQLValue) { return sField + " < " + sSQLValue; }
    };

    /**
     *
     */
    public final static QBFCompareEnum COMP_GREATEROREQUALS = new QBFCompareEnum(7, "qbf.greaterequals") {
        @Override
        public String getExpression(String sField, String sSQLValue) { return sField + " >= " + sSQLValue; }
    };

    /**
     *
     */
    public final static QBFCompareEnum COMP_LESSOREQUALS = new QBFCompareEnum(8, "qbf.lessequals") {
        @Override
        public String getExpression(String sField, String sSQLValue) { return sField + " <= " + sSQLValue; }
    };
//    public final static QBFCompareEnum COMP_STARTSWITH = new QBFCompareEnum(9, "qbf.startswith") {
//        public String getExpression(String sField, String sSQLValue) { return sField + " LIKE " ... + sSQLValue; }
//    };
//    public final static int COMP_ENDSWITH = 12;
//    public final static int COMP_CONTAINS = 13;    
    
    private final int m_iValue; 
    private final String m_sKey;
    
    private QBFCompareEnum(int iValue, String sKey) {
        m_iValue = iValue;
        m_sKey = sKey;
    }

    /**
     *
     * @return
     */
    public int getCompareInt() {
        return m_iValue;
    }
    @Override
    public String toString() {
        return LocalRes.getIntString(m_sKey);
    }

    /**
     *
     * @param sField
     * @param sSQLValue
     * @return
     */
    public abstract String getExpression(String sField, String sSQLValue);
}
