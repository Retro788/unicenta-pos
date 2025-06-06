// ..
package com.openbravo.pos.sales;

import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.DataLogicSystem;
import com.openbravo.pos.ticket.TicketLineInfo;
import java.awt.BorderLayout;
import java.util.List;

/**
 *
 * @author JG uniCenta
 */
public class JRefundLines extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

    private JTicketLines ticketlines;
    private List<TicketLineInfo> m_aLines;

    private JPanelTicketEdits m_jTicketEdit;

    /**
     * Creates new form JRefundLines
     *
     * @param dlSystem
     * @param jTicketEdit
     */
    public JRefundLines(DataLogicSystem dlSystem, JPanelTicketEdits jTicketEdit) {

        m_jTicketEdit = jTicketEdit;

        initComponents();

        ticketlines = new JTicketLines(dlSystem.getResourceAsXML("Ticket.Line"));

        jPanel3.add(ticketlines, BorderLayout.CENTER);
    }

    /**
     *
     * @param aRefundLines
     */
    public void setLines(List<TicketLineInfo> aRefundLines) {

        m_aLines = aRefundLines;
        ticketlines.clearTicketLines();

        if (m_aLines != null) {
            for (int i = 0; i < m_aLines.size(); i++) {
                ticketlines.addTicketLine(m_aLines.get(i));
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        webLabel1 = new javax.swing.JLabel();
        m_jbtnAddOne = new javax.swing.JButton();
        m_jbtnAddLine = new javax.swing.JButton();
        m_jbtnAddAll = new javax.swing.JButton();

        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        setMinimumSize(new java.awt.Dimension(150, 200));
        setPreferredSize(new java.awt.Dimension(150, 200));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.BorderLayout());

        jPanel3.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(150, 200));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(150, 200));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(150, 200));

        webLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("pos_messages"); // NOI18N
        webLabel1.setText(bundle.getString("label.refunds")); // NOI18N
        webLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        webLabel1.setMaximumSize(new java.awt.Dimension(100, 30));
        webLabel1.setMinimumSize(new java.awt.Dimension(100, 30));
        webLabel1.setPreferredSize(new java.awt.Dimension(100, 30));

        m_jbtnAddOne.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jbtnAddOne.setText(AppLocal.getIntString("button.refundone")); // NOI18N
        m_jbtnAddOne.setToolTipText(bundle.getString("tooltip.refunditem")); // NOI18N
        m_jbtnAddOne.setFocusPainted(false);
        m_jbtnAddOne.setFocusable(false);
        m_jbtnAddOne.setMargin(new java.awt.Insets(8, 14, 8, 14));
        m_jbtnAddOne.setMaximumSize(new java.awt.Dimension(100, 30));
        m_jbtnAddOne.setMinimumSize(new java.awt.Dimension(100, 30));
        m_jbtnAddOne.setPreferredSize(new java.awt.Dimension(100, 50));
        m_jbtnAddOne.setRequestFocusEnabled(false);
        m_jbtnAddOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jbtnAddOneActionPerformed(evt);
            }
        });

        m_jbtnAddLine.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jbtnAddLine.setText(AppLocal.getIntString("button.refundline")); // NOI18N
        m_jbtnAddLine.setToolTipText(bundle.getString("tooltip.refundline")); // NOI18N
        m_jbtnAddLine.setFocusPainted(false);
        m_jbtnAddLine.setFocusable(false);
        m_jbtnAddLine.setMargin(new java.awt.Insets(8, 14, 8, 14));
        m_jbtnAddLine.setMaximumSize(new java.awt.Dimension(100, 50));
        m_jbtnAddLine.setMinimumSize(new java.awt.Dimension(100, 50));
        m_jbtnAddLine.setPreferredSize(new java.awt.Dimension(100, 50));
        m_jbtnAddLine.setRequestFocusEnabled(false);
        m_jbtnAddLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jbtnAddLineActionPerformed(evt);
            }
        });

        m_jbtnAddAll.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jbtnAddAll.setText(AppLocal.getIntString("button.refundall")); // NOI18N
        m_jbtnAddAll.setToolTipText(bundle.getString("tooltip.refundticket")); // NOI18N
        m_jbtnAddAll.setFocusPainted(false);
        m_jbtnAddAll.setFocusable(false);
        m_jbtnAddAll.setMargin(new java.awt.Insets(8, 14, 8, 14));
        m_jbtnAddAll.setMaximumSize(new java.awt.Dimension(100, 50));
        m_jbtnAddAll.setMinimumSize(new java.awt.Dimension(100, 50));
        m_jbtnAddAll.setPreferredSize(new java.awt.Dimension(100, 50));
        m_jbtnAddAll.setRequestFocusEnabled(false);
        m_jbtnAddAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jbtnAddAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(webLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(m_jbtnAddOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(m_jbtnAddLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(m_jbtnAddAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(webLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(m_jbtnAddOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(m_jbtnAddLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(m_jbtnAddAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_END);

        jPanel3.add(jPanel1, java.awt.BorderLayout.EAST);

        add(jPanel3, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents

    private void m_jbtnAddAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jbtnAddAllActionPerformed

        for (int i = 0; i < m_aLines.size(); i++) {
            TicketLineInfo oLine = (TicketLineInfo) m_aLines.get(i);
            TicketLineInfo oNewLine = new TicketLineInfo(oLine);
            oNewLine.setMultiply(-oLine.getMultiply());
            m_jTicketEdit.addTicketLine(oNewLine);
        }

    }//GEN-LAST:event_m_jbtnAddAllActionPerformed

    private void m_jbtnAddOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jbtnAddOneActionPerformed

        int index = ticketlines.getSelectedIndex();
        if (index >= 0) {
            TicketLineInfo oLine = (TicketLineInfo) m_aLines.get(index);
            TicketLineInfo oNewLine = new TicketLineInfo(oLine);
            oNewLine.setMultiply(-1.0);
            m_jTicketEdit.addTicketLine(oNewLine);
        }

    }//GEN-LAST:event_m_jbtnAddOneActionPerformed

    private void m_jbtnAddLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jbtnAddLineActionPerformed

        int index = ticketlines.getSelectedIndex();
        if (index >= 0) {
            TicketLineInfo oLine = (TicketLineInfo) m_aLines.get(index);
            TicketLineInfo oNewLine = new TicketLineInfo(oLine);
            oNewLine.setMultiply(-oLine.getMultiply());
            m_jTicketEdit.addTicketLine(oNewLine);
        }
    }//GEN-LAST:event_m_jbtnAddLineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton m_jbtnAddAll;
    private javax.swing.JButton m_jbtnAddLine;
    private javax.swing.JButton m_jbtnAddOne;
    private javax.swing.JLabel webLabel1;
    // End of variables declaration//GEN-END:variables

}
