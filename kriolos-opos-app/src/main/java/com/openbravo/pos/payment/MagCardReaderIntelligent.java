// ..

package com.openbravo.pos.payment;

public final class MagCardReaderIntelligent implements MagCardReader {
    
    private String m_sHolderName;
    private String m_sCardNumber;
    private String m_sExpirationDate;
    
    private StringBuffer m_sField;
    
    private static final int READING_HOLDER = 0;
    private static final int READING_NUMBER = 1;
    private static final int READING_DATE = 2;
    private static final int READING_FINISHED = 3;
    private int m_iAutomState;
            
    /** Creates a new instance of BasicMagCardReader */
    public MagCardReaderIntelligent() {
        reset();
    }
 
    public String getReaderName() {
        return "Basic magnetic card reader";
    }
    
    public void reset() {
        m_sHolderName = null;
        m_sCardNumber = null;
        m_sExpirationDate = null;
        m_sField = new StringBuffer();
        m_iAutomState = READING_HOLDER;
    }
    
    public void appendChar(char c) {
       
        switch (m_iAutomState) {
            case READING_HOLDER:
            case READING_FINISHED:
                if (c == 0x0009) {
                    m_sHolderName = m_sField.toString();
                    m_sField = new StringBuffer();
                    m_iAutomState = READING_NUMBER;
                } else if (c == 0x000A) {
                    m_sHolderName = null;
                    m_sCardNumber = null;
                    m_sExpirationDate = null;
                    m_sField = new StringBuffer();
                    m_iAutomState = READING_HOLDER;
                } else {
                    m_sField.append(c);
                    m_iAutomState = READING_HOLDER;
                }
                break;
            case READING_NUMBER:
                if (c == 0x0009) {
                    m_sCardNumber = m_sField.toString();
                    m_sField = new StringBuffer();
                    m_iAutomState = READING_DATE;
                } else if (c == 0x000A) {
                    m_sHolderName = null;
                    m_sCardNumber = null;
                    m_sExpirationDate = null;
                    m_sField = new StringBuffer();
                    m_iAutomState = READING_HOLDER;
                } else {
                    m_sField.append(c);
                }
                break;                
            case READING_DATE:
                if (c == 0x0009) {
                    m_sHolderName = m_sCardNumber;
                    m_sCardNumber = m_sExpirationDate;
                    m_sExpirationDate = null;
                    m_sField = new StringBuffer();
                } else if (c == 0x000A) {
                    m_sExpirationDate = m_sField.toString();
                    m_sField = new StringBuffer();
                    m_iAutomState = READING_FINISHED;
                } else {
                    m_sField.append(c);
                }
                break;  
        }
    }
    
    public boolean isComplete() {
        return m_iAutomState == READING_FINISHED;
    }
    
    public String getHolderName() {
        return m_sHolderName;
    }
    public String getCardNumber() {
        return m_sCardNumber;
    }
    public String getExpirationDate() {
        return m_sExpirationDate;
    }
    public String getTrack1() {
        return null;
    }
    public String getTrack2() {
        return null;
    }    
    public String getTrack3() {
        return null;
    }       

    @Override
    public String getEncryptedCardData() {
        return null;
    }

    @Override
    public String getEncryptionKey() {
        return null;
    }
}
