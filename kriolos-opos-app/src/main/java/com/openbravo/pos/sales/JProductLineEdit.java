// ..

package com.openbravo.pos.sales;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.Session;
import com.openbravo.format.Formats;
import com.openbravo.pos.forms.AppConfig;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.ticket.TicketLineInfo;
import com.openbravo.pos.util.AltEncrypter;
import java.sql.DriverManager;

//file format
public class JProductLineEdit extends javax.swing.JDialog {
    
    private TicketLineInfo returnLine;
    private TicketLineInfo m_oLine;
    private boolean m_bunitsok;
    private boolean m_bpriceok;
    private String productID;
    private Session s;
    private Connection con;  
    private String SQL;
    private PreparedStatement pstmt;  
            
    /** Creates new form JProductLineEdit */
    private JProductLineEdit(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }
    /** Creates new form JProductLineEdit */
    private JProductLineEdit(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
    }
    
    private TicketLineInfo init(AppView app, TicketLineInfo oLine) throws BasicException {

        initComponents();

        productID = oLine.getProductID();
        
        if (oLine.getTaxInfo() == null) {
            throw new BasicException(AppLocal.getIntString("message.cannotcalculatetaxes"));
        }

        m_jBtnPriceUpdate.setVisible(AppConfig.getInstance().getBoolean("db.prodpriceupdate"));        

        m_jBtnPriceUpdate.setEnabled(false);
        
        m_oLine = new TicketLineInfo(oLine);
        m_bunitsok = true;
        m_bpriceok = true;

//        m_jName.setEnabled(app.hasPermission("com.openbravo.pos.sales.JPanelTicketEdits"));
        m_jUnits.setEnabled(app.hasPermission("com.openbravo.pos.sales.JPanelTicketEdits"));        
        m_jPrice.setEnabled(app.hasPermission("com.openbravo.pos.sales.JPanelTicketEdits"));
        m_jPriceTax.setEnabled(app.hasPermission("com.openbravo.pos.sales.JPanelTicketEdits"));
        
        m_jName.setText(oLine.getProductName());        
        m_jUnits.setDoubleValue(oLine.getMultiply());
        m_jPrice.setDoubleValue(oLine.getPrice()); 
        m_jPriceTax.setDoubleValue(oLine.getPriceTax());
        
        jLblTaxName.setText(oLine.getTaxInfo().getName());
        m_jTaxrate.setText(Formats.PERCENT.formatValue(oLine.getTaxInfo().getRate()));
        
        m_jName.addPropertyChangeListener("Edition", new RecalculateName());
        m_jUnits.addPropertyChangeListener("Edition", new RecalculateUnits());
        m_jPrice.addPropertyChangeListener("Edition", new RecalculatePrice());
        m_jPriceTax.addPropertyChangeListener("Edition", new RecalculatePriceTax());

        m_jName.addEditorKeys(m_jKeys);
        m_jUnits.addEditorKeys(m_jKeys);
        m_jPrice.addEditorKeys(m_jKeys);
        m_jPriceTax.addEditorKeys(m_jKeys);
        
        if (m_jName.isEnabled()) {
            m_jName.activate();
        } else {
            m_jUnits.activate();
        }
        
        printTotals();

        getRootPane().setDefaultButton(m_jButtonOK);   
        returnLine = null;
        setVisible(true);
      
        return returnLine;
    }
    
    private void printTotals() {
        
        if (m_bunitsok && m_bpriceok) {
            m_jSubtotal.setText(m_oLine.printSubValue());
            m_jTotal.setText(m_oLine.printValue());
            m_jButtonOK.setEnabled(true);
       } else {
            m_jSubtotal.setText(null);
            m_jTotal.setText(null);
            m_jButtonOK.setEnabled(false);
        }
    }
    
    private class RecalculateUnits implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            Double value = m_jUnits.getValue();
            if (value == null || value == 0.0) {
                m_bunitsok = false;
            } else {
                m_oLine.setMultiply(value);
                m_bunitsok = true;                
            }

            printTotals();
        }
    }
    
    private class RecalculatePrice implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {

            Double value = m_jPrice.getValue();
            if (value == null || value == 0.0) {
                m_bpriceok = false;
            } else {
                m_oLine.setPrice(value);
                m_jPriceTax.setDoubleValue(m_oLine.getPriceTax());
                m_bpriceok = true;
                m_jBtnPriceUpdate.setEnabled(AppConfig.getInstance().getBoolean("db.prodpriceupdate"));                
            }

            printTotals();
        }
    }    
    
    private class RecalculatePriceTax implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {

            Double value = m_jPriceTax.getValue();
            if (value == null || value == 0.0) {
                m_bpriceok = false;
            } else {
                m_oLine.setPriceTax(value);
                m_jPrice.setDoubleValue(m_oLine.getPrice());
                m_bpriceok = true;
                m_jBtnPriceUpdate.setEnabled(AppConfig.getInstance().getBoolean("db.prodpriceupdate"));                                
            }

            printTotals();
        }
    }   
    
    private class RecalculateName implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            m_oLine.setProperty("product.name", m_jName.getText());
        }
    }   
    
    private static Window getWindow(Component parent) {
        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window)parent;
        } else {
            return getWindow(parent.getParent());
        }
    }

    /**
     *
     * @param parent
     * @param app
     * @param oLine
     * @return
     * @throws BasicException
     */
    public static TicketLineInfo showMessage(Component parent
            , AppView app
            , TicketLineInfo oLine) throws BasicException {
         
        Window window = getWindow(parent);
        
        JProductLineEdit myMsg;
        if (window instanceof Frame) { 
            myMsg = new JProductLineEdit((Frame) window, true);
        } else {
            myMsg = new JProductLineEdit((Dialog) window, true);
        }
        return myMsg.init(app, oLine);
    }        

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        m_jName = new com.openbravo.editor.JEditorString();
        m_jUnits = new com.openbravo.editor.JEditorDouble();
        m_jPrice = new com.openbravo.editor.JEditorCurrency();
        m_jPriceTax = new com.openbravo.editor.JEditorCurrency();
        m_jTaxrate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        m_jTotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        m_jSubtotal = new javax.swing.JLabel();
        m_jBtnPriceUpdate = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLblTaxName = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        m_jKeys = new com.openbravo.editor.JEditorKeys();
        jPanel1 = new javax.swing.JPanel();
        m_jButtonCancel = new javax.swing.JButton();
        m_jButtonOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(AppLocal.getIntString("label.editline")); // NOI18N

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 230));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText(AppLocal.getIntString("label.price")); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(110, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText(AppLocal.getIntString("label.item")); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(110, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText(AppLocal.getIntString("label.pricetax")); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(110, 30));

        m_jName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jName.setMinimumSize(new java.awt.Dimension(100, 30));
        m_jName.setPreferredSize(new java.awt.Dimension(150, 30));

        m_jUnits.setEnabled(false);
        m_jUnits.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jUnits.setPreferredSize(new java.awt.Dimension(150, 30));

        m_jPrice.setEnabled(false);
        m_jPrice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jPrice.setPreferredSize(new java.awt.Dimension(150, 30));

        m_jPriceTax.setEnabled(false);
        m_jPriceTax.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jPriceTax.setPreferredSize(new java.awt.Dimension(132, 30));

        m_jTaxrate.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.disabledBackground"));
        m_jTaxrate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jTaxrate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        m_jTaxrate.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow")), javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 4)));
        m_jTaxrate.setMaximumSize(new java.awt.Dimension(150, 30));
        m_jTaxrate.setMinimumSize(new java.awt.Dimension(150, 30));
        m_jTaxrate.setOpaque(true);
        m_jTaxrate.setPreferredSize(new java.awt.Dimension(150, 30));
        m_jTaxrate.setRequestFocusEnabled(false);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText(AppLocal.getIntString("label.tax")); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(110, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText(AppLocal.getIntString("label.totalcash")); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(110, 30));

        m_jTotal.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.disabledBackground"));
        m_jTotal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        m_jTotal.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow")), javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 4)));
        m_jTotal.setOpaque(true);
        m_jTotal.setPreferredSize(new java.awt.Dimension(150, 30));
        m_jTotal.setRequestFocusEnabled(false);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText(AppLocal.getIntString("label.subtotalcash")); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(110, 30));

        m_jSubtotal.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.disabledBackground"));
        m_jSubtotal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        m_jSubtotal.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow")), javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 4)));
        m_jSubtotal.setOpaque(true);
        m_jSubtotal.setPreferredSize(new java.awt.Dimension(150, 30));
        m_jSubtotal.setRequestFocusEnabled(false);

        m_jBtnPriceUpdate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jBtnPriceUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/filesave.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("pos_messages"); // NOI18N
        m_jBtnPriceUpdate.setText(bundle.getString("button.priceupdate")); // NOI18N
        m_jBtnPriceUpdate.setFocusPainted(false);
        m_jBtnPriceUpdate.setFocusable(false);
        m_jBtnPriceUpdate.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jBtnPriceUpdate.setPreferredSize(new java.awt.Dimension(110, 45));
        m_jBtnPriceUpdate.setRequestFocusEnabled(false);
        m_jBtnPriceUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jBtnPriceUpdateActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText(AppLocal.getIntString("label.units")); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(110, 30));

        jLblTaxName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblTaxName.setText("\"Taxes Name\"");
        jLblTaxName.setPreferredSize(new java.awt.Dimension(110, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(m_jUnits, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(m_jPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(m_jPriceTax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLblTaxName, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m_jTaxrate, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(m_jName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(m_jBtnPriceUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(m_jTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m_jSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(m_jName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(m_jUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(m_jPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_jPriceTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(m_jTaxrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLblTaxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_jSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(m_jTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(m_jBtnPriceUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.Y_AXIS));

        m_jKeys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jKeysActionPerformed(evt);
            }
        });
        jPanel4.add(m_jKeys);

        jPanel3.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        m_jButtonCancel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jButtonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/cancel.png"))); // NOI18N
        m_jButtonCancel.setText(AppLocal.getIntString("button.cancel")); // NOI18N
        m_jButtonCancel.setFocusPainted(false);
        m_jButtonCancel.setFocusable(false);
        m_jButtonCancel.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jButtonCancel.setPreferredSize(new java.awt.Dimension(110, 45));
        m_jButtonCancel.setRequestFocusEnabled(false);
        m_jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jButtonCancelActionPerformed(evt);
            }
        });
        jPanel1.add(m_jButtonCancel);

        m_jButtonOK.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jButtonOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/ok.png"))); // NOI18N
        m_jButtonOK.setText(AppLocal.getIntString("button.ok")); // NOI18N
        m_jButtonOK.setFocusPainted(false);
        m_jButtonOK.setFocusable(false);
        m_jButtonOK.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jButtonOK.setPreferredSize(new java.awt.Dimension(110, 45));
        m_jButtonOK.setRequestFocusEnabled(false);
        m_jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jButtonOKActionPerformed(evt);
            }
        });
        jPanel1.add(m_jButtonOK);

        jPanel3.add(jPanel1, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel3, java.awt.BorderLayout.EAST);

        setSize(new java.awt.Dimension(708, 394));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void m_jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jButtonCancelActionPerformed

        dispose();

    }//GEN-LAST:event_m_jButtonCancelActionPerformed

    private void m_jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jButtonOKActionPerformed

        returnLine = m_oLine;
        
        dispose();

    }//GEN-LAST:event_m_jButtonOKActionPerformed

    private void m_jKeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jKeysActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m_jKeysActionPerformed

    private void m_jBtnPriceUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jBtnPriceUpdateActionPerformed

        String db_password = (AppConfig.getInstance().getProperty("db.password"));

        if (AppConfig.getInstance().getProperty("db.user") != null 
                && db_password != null 
                && db_password.startsWith("crypt:")) {
            AltEncrypter cypher = new AltEncrypter("cypherkey" 
                    + AppConfig.getInstance().getProperty("db.user"));
            db_password = cypher.decrypt(db_password.substring(6));
        }

        try {

//            s = AppViewConnection.createSession();
            con = DriverManager.getConnection(
                    AppConfig.getInstance().getProperty("db.URL")
                    , AppConfig.getInstance().getProperty("db.user")
                    , db_password);

            pstmt = con.prepareStatement(
                    "UPDATE PRODUCTS SET PRICESELL = ? WHERE ID = ?");
            pstmt.setDouble(1, m_jPrice.getValue());
            pstmt.setString(2, productID);
            pstmt.executeUpdate();

            m_jBtnPriceUpdate.setEnabled(false);
            
            con.close();
            
        } catch (SQLException e) {

            return;
        }

        m_oLine.setUpdated(true);
    }//GEN-LAST:event_m_jBtnPriceUpdateActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLblTaxName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton m_jBtnPriceUpdate;
    private javax.swing.JButton m_jButtonCancel;
    private javax.swing.JButton m_jButtonOK;
    private com.openbravo.editor.JEditorKeys m_jKeys;
    private com.openbravo.editor.JEditorString m_jName;
    private com.openbravo.editor.JEditorCurrency m_jPrice;
    private com.openbravo.editor.JEditorCurrency m_jPriceTax;
    private javax.swing.JLabel m_jSubtotal;
    private javax.swing.JLabel m_jTaxrate;
    private javax.swing.JLabel m_jTotal;
    private com.openbravo.editor.JEditorDouble m_jUnits;
    // End of variables declaration//GEN-END:variables
    
}
