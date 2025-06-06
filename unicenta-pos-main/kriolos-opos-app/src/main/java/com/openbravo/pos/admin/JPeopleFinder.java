//    KriolOS POS
//    Copyright (c) 2019-2023 KriolOS
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.
package com.openbravo.pos.admin;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.QBFCompareEnum;
import com.openbravo.data.user.EditorCreator;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.ListProviderCreator;
import com.openbravo.pos.forms.AppLocal;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;

//file format
public class JPeopleFinder extends javax.swing.JDialog implements EditorCreator {

    private static final long serialVersionUID = 1L;

    private PeopleInfo selectedPeople;
    private ListProvider<PeopleInfo> lpr;

    /**
     * Creates new form JPeopleFinder
     */
    private JPeopleFinder(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }

    /**
     * Creates new form JPeopleFinder
     */
    private JPeopleFinder(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
    }

    /**
     *
     * @param parent
     * @param dlPeople
     * @return
     */
    public static JPeopleFinder getPeopleFinder(Component parent, DataLogicAdmin dlPeople) {
        Window window = getWindow(parent);

        JPeopleFinder myMsg;
        if (window instanceof Frame) {
            myMsg = new JPeopleFinder((Frame) window, true);
        } else {
            myMsg = new JPeopleFinder((Dialog) window, true);
        }
        myMsg.init(dlPeople);
        myMsg.applyComponentOrientation(parent.getComponentOrientation());
        return myMsg;
    }

    /**
     *
     * @return
     */
    public PeopleInfo getSelectedPeople() {
        return selectedPeople;
    }

    private void init(DataLogicAdmin dlPeople) {

        initComponents();

        jScrollPane1.getVerticalScrollBar().setPreferredSize(new Dimension(35, 35));
        m_jtxtName.addEditorKeys(m_jKeys);
        m_jtxtName.reset();
        lpr = new ListProviderCreator(dlPeople.getPeopleList(), this);
        jListPeople.setCellRenderer(new PeopleRenderer());

        getRootPane().setDefaultButton(jcmdOK);

        selectedPeople = null;
    }

    public void search(PeopleInfo people) {

        if (people == null || people.getName() == null || people.getName().equals("")) {
            m_jtxtName.reset();
            cleanSearch();
        } else {
            m_jtxtName.setText(people.getName());
            executeSearch();
        }
    }

    private void cleanSearch() {
        jListPeople.setModel(new PeopleListModel(new ArrayList()));
    }

    public void executeSearch() {
        try {
            jListPeople.setModel(new PeopleListModel(lpr.loadData()));
            if (jListPeople.getModel().getSize() > 0) {
                jListPeople.setSelectedIndex(0);
            }
        } catch (BasicException e) {
        }
    }

    /**
     *
     * @return creates object for search method
     * @throws BasicException
     */
    @Override
    public Object createValue() throws BasicException {

        Object[] afilter = new Object[12];

        if (m_jtxtName.getText() == null
                || m_jtxtName.getText().equals("")) {
            afilter[0] = QBFCompareEnum.COMP_NONE;
            afilter[1] = null;
        } else {
            afilter[0] = QBFCompareEnum.COMP_RE;
            afilter[1] = "%" + m_jtxtName.getText() + "%";
        }

        return afilter;
    }

    private static Window getWindow(Component parent) {
        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window) parent;
        } else {
            return getWindow(parent.getParent());
        }
    }

    private static class PeopleListModel extends javax.swing.AbstractListModel<PeopleInfo> {

        private final java.util.List<PeopleInfo> m_data;

        public PeopleListModel(java.util.List<PeopleInfo> data) {
            m_data = data;
        }

        @Override
        public PeopleInfo getElementAt(int index) {
            return m_data.get(index);
        }

        @Override
        public int getSize() {
            return m_data.size();
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
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLblName = new javax.swing.JLabel();
        m_jtxtName = new com.openbravo.editor.JEditorString();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPeople = new javax.swing.JList();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        m_jKeys = new com.openbravo.editor.JEditorKeys();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jcmdCancel = new javax.swing.JButton();
        jcmdOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(AppLocal.getIntString("form.usertitle")); // NOI18N
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel3.setPreferredSize(new java.awt.Dimension(450, 231));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLblName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLblName.setText(AppLocal.getIntString("label.prodname")); // NOI18N
        jLblName.setMaximumSize(new java.awt.Dimension(60, 15));
        jLblName.setMinimumSize(new java.awt.Dimension(60, 15));
        jLblName.setPreferredSize(new java.awt.Dimension(110, 30));

        m_jtxtName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jtxtName.setPreferredSize(new java.awt.Dimension(250, 30));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(m_jtxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(m_jtxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLblName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        m_jtxtName.getAccessibleContext().setAccessibleName("");

        jPanel5.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jListPeople.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jListPeople.setFocusable(false);
        jListPeople.setRequestFocusEnabled(false);
        jListPeople.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListPeopleMouseClicked(evt);
            }
        });
        jListPeople.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListPeopleValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListPeople);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/reload.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("pos_messages"); // NOI18N
        jButton1.setText(bundle.getString("button.reset")); // NOI18N
        jButton1.setToolTipText("Clear Filter");
        jButton1.setActionCommand("Reset ");
        jButton1.setFocusable(false);
        jButton1.setPreferredSize(new java.awt.Dimension(110, 45));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1);
        jButton1.getAccessibleContext().setAccessibleDescription("");

        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/ok.png"))); // NOI18N
        jButton3.setText(AppLocal.getIntString("button.executefilter")); // NOI18N
        jButton3.setToolTipText("Execute Filter");
        jButton3.setFocusPainted(false);
        jButton3.setPreferredSize(new java.awt.Dimension(110, 45));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3);
        jButton3.getAccessibleContext().setAccessibleDescription("");

        jPanel4.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel2.add(m_jKeys, java.awt.BorderLayout.NORTH);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jcmdCancel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcmdCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/cancel.png"))); // NOI18N
        jcmdCancel.setText(AppLocal.getIntString("button.cancel")); // NOI18N
        jcmdCancel.setFocusPainted(false);
        jcmdCancel.setFocusable(false);
        jcmdCancel.setMargin(new java.awt.Insets(8, 16, 8, 16));
        jcmdCancel.setPreferredSize(new java.awt.Dimension(110, 45));
        jcmdCancel.setRequestFocusEnabled(false);
        jcmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdCancelActionPerformed(evt);
            }
        });
        jPanel1.add(jcmdCancel);

        jcmdOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/ok.png"))); // NOI18N
        jcmdOK.setText(AppLocal.getIntString("button.ok")); // NOI18N
        jcmdOK.setEnabled(false);
        jcmdOK.setFocusPainted(false);
        jcmdOK.setFocusable(false);
        jcmdOK.setMargin(new java.awt.Insets(8, 16, 8, 16));
        jcmdOK.setMaximumSize(new java.awt.Dimension(103, 44));
        jcmdOK.setMinimumSize(new java.awt.Dimension(103, 44));
        jcmdOK.setPreferredSize(new java.awt.Dimension(110, 45));
        jcmdOK.setRequestFocusEnabled(false);
        jcmdOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdOKActionPerformed(evt);
            }
        });
        jPanel1.add(jcmdOK);

        jPanel8.add(jPanel1, java.awt.BorderLayout.LINE_END);

        jPanel2.add(jPanel8, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_END);

        setSize(new java.awt.Dimension(758, 497));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void jcmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdOKActionPerformed

        selectedPeople = (PeopleInfo) jListPeople.getSelectedValue();
        dispose();

    }//GEN-LAST:event_jcmdOKActionPerformed

    private void jcmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdCancelActionPerformed

        dispose();

    }//GEN-LAST:event_jcmdCancelActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        executeSearch();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jListPeopleValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListPeopleValueChanged

        jcmdOK.setEnabled(jListPeople.getSelectedValue() != null);

    }//GEN-LAST:event_jListPeopleValueChanged

    private void jListPeopleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPeopleMouseClicked

        if (evt.getClickCount() == 2) {
            selectedPeople = (PeopleInfo) jListPeople.getSelectedValue();
            dispose();
        }

    }//GEN-LAST:event_jListPeopleMouseClicked

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    m_jtxtName.reset();

    cleanSearch();
}//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLblName;
    private javax.swing.JList jListPeople;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jcmdCancel;
    private javax.swing.JButton jcmdOK;
    private com.openbravo.editor.JEditorKeys m_jKeys;
    private com.openbravo.editor.JEditorString m_jtxtName;
    // End of variables declaration//GEN-END:variables
}
