// ..

package com.openbravo.data.gui;

import com.openbravo.data.loader.LocalRes;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author JG uniCenta
 */
public class JImageEditor extends javax.swing.JPanel {
    
    private Dimension m_maxsize;
    private ZoomIcon m_icon;
    private BufferedImage m_Img = null;
    
    private static File m_fCurrentDirectory = null;
    private static NumberFormat m_percentformat = new DecimalFormat("#,##0.##%");
    
    private boolean viewMode = false;
    
    /** Creates new form JImageEditor */
    public JImageEditor() {
        initComponents();
        
        m_Img = null;
        m_maxsize = null;
        m_icon = new ZoomIcon();
        m_jImage.setIcon(m_icon);
        m_jPercent.setText(m_percentformat.format(m_icon.getZoom()));
        privateSetEnabled(isEnabled());
    }
    
    
    public void setViewMode(){
       viewMode = true; 
    }
    
    /**
     *
     * @param size
     */
    public void setMaxDimensions(Dimension size) {
        m_maxsize = size;
    }

    /**
     *
     * @return
     */
    public Dimension getMaxDimensions() {
        return m_maxsize;
    }
    
    @Override
    public void setEnabled(boolean value) {

        privateSetEnabled(value);
        super.setEnabled(value);
    }
    
    private void privateSetEnabled(boolean value) {
        //ViewMode Disable Open and Close Bu
        if(viewMode){
            m_jbtnopen.setEnabled(false);
            m_jbtnclose.setEnabled(false);
        }else{
           m_jbtnopen.setEnabled(value);
            m_jbtnclose.setEnabled(value && (m_Img != null));
        }
        m_jbtnzoomin.setEnabled(value && (m_Img != null));
        m_jbtnzoomout.setEnabled(value && (m_Img != null));
        m_jPercent.setEnabled(value && (m_Img != null));
        m_jScr.setEnabled(value && (m_Img != null));
    }
    
    /**
     *
     * @param img
     */
    public void setImage(BufferedImage img) {
        BufferedImage oldimg = m_Img;
        m_Img = img;
        m_icon.setIcon(m_Img == null ? null : new ImageIcon(m_Img));
        
        m_jPercent.setText(m_percentformat.format(m_icon.getZoom()));
     
        m_jImage.revalidate();
        m_jScr.revalidate();
        m_jScr.repaint();

        privateSetEnabled(isEnabled());
        
        firePropertyChange("image", oldimg, m_Img);
    }
    
    /**
     *
     * @return
     */
    public BufferedImage getImage() {
        return m_Img;
    }

    /**
     *
     * @return
     */
    public double getZoom() {
        return m_icon.getZoom();
    }
 
    /**
     *
     * @param zoom
     */
    public void setZoom(double zoom) {
        double oldzoom = m_icon.getZoom();
        m_icon.setZoom(zoom);
        
        m_jPercent.setText(m_percentformat.format(m_icon.getZoom()));
        
        m_jImage.revalidate();
        m_jScr.revalidate();
        m_jScr.repaint();
        
        firePropertyChange("zoom", oldzoom, zoom);
    }
    
    /**
     *
     */
    public void incZoom() {        
        double zoom = m_icon.getZoom();
        setZoom(zoom > 4.0 ? 8.0 : zoom * 2.0);
    }
    
    /**
     *
     */
    public void decZoom() {        
        double zoom = m_icon.getZoom();
        setZoom(zoom < 0.5 ? 0.25 : zoom / 2.0);
    }
    
    /**
     *
     */
    public void doLoad() {
        JFileChooser fc = new JFileChooser(m_fCurrentDirectory);
        
        fc.addChoosableFileFilter(new ExtensionsFilter(LocalRes.getIntString("label.imagefiles"), "png", "gif", "jpg", "jpeg", "bmp"));

        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {  
            try {
                BufferedImage img = ImageIO.read(fc.getSelectedFile());
                if (img != null) {
                    // compruebo que no exceda el tamano maximo.
                    if (m_maxsize != null && (img.getHeight() > m_maxsize.height || img.getWidth() > m_maxsize.width)) {
                        if (JOptionPane.showConfirmDialog(this, 
                                LocalRes.getIntString("message.resizeimage"), 
                                LocalRes.getIntString("title.editor"), 
                                JOptionPane.YES_NO_OPTION, 
                                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {          
                            // Redimensionamos la imagen para que se ajuste
                            img = resizeImage(img);
                        }                        
                    }
                    setImage(img);
                    m_fCurrentDirectory = fc.getCurrentDirectory();
                }
            } catch (IOException eIO) {
            }
        }
    }
    
    private BufferedImage resizeImage(BufferedImage img) {
        
        int myheight = img.getHeight();
        int mywidth = img.getWidth();
        
        if (myheight > m_maxsize.height) {
            mywidth = (int) (mywidth * m_maxsize.height / myheight); 
            myheight = m_maxsize.height;
        }
        if (mywidth > m_maxsize.width) {
            myheight = (int) (myheight * m_maxsize.width / mywidth);
            mywidth = m_maxsize.width;
        }

        BufferedImage thumb = new BufferedImage(mywidth, myheight, BufferedImage.TYPE_4BYTE_ABGR);

        double scalex = (double) mywidth / (double) img.getWidth(null);
        double scaley = (double) myheight / (double) img.getHeight(null);

        Graphics2D g2d = thumb.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        g2d.setColor(new Color(0, 0, 0, 0)); // Transparent

        g2d.fillRect(0, 0, mywidth, myheight);
        if (scalex < scaley) {
            g2d.drawImage(img, 0,(int) ((myheight - img.getHeight(null) * scalex) / 2.0)
            , mywidth, (int) (img.getHeight(null) * scalex),  null);
        } else {
           g2d.drawImage(img, (int) ((mywidth - img.getWidth(null) * scaley) / 2.0), 0
           , (int) (img.getWidth(null) * scaley), myheight, null);
        }
        g2d.dispose(); 
        
        return thumb;
    }
          
    private static class ZoomIcon implements Icon {
        
        private Icon ico;
        private double zoom;
        
        public ZoomIcon() {
            this.ico = null;
            this.zoom = 1.0;
        }
        @Override
        public int getIconHeight() {
            return ico == null ? 0 : (int) (zoom * ico.getIconHeight());
        }
        @Override
        public int getIconWidth() {
            return ico == null ? 0 : (int) (zoom * ico.getIconWidth());
        }
        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            if (ico != null) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                AffineTransform oldt = g2d.getTransform();
                g2d.transform(AffineTransform.getScaleInstance(zoom, zoom));
                ico.paintIcon(c, g2d, (int) (x / zoom), (int) (y / zoom));
                g2d.setTransform(oldt);
            }
        }
        public void setIcon(Icon ico) {
            this.ico = ico;
            this.zoom = 1.0;
        }
        public void setZoom(double zoom) {
            this.zoom = zoom;
        }
        public double getZoom() {
            return zoom;
        }
    }    
    private static class ExtensionsFilter extends FileFilter {
        
        private String message;
        private String[] extensions;
        
        public ExtensionsFilter(String message, String... extensions) {
            this.message = message;
            this.extensions = extensions;            
        }
        
        @Override
        public boolean accept(java.io.File f) {
            if (f.isDirectory()) {
                return true;
            } else {
                String sFileName = f.getName();
                int ipos = sFileName.lastIndexOf('.');
                if (ipos >= 0) {
                    String sExt = sFileName.substring(ipos + 1);
                    for(String s : extensions) {
                        if (s.equalsIgnoreCase(sExt)) {
                            return true;
                        }
                    }
                }                        
                return false;
            }   
        }
        
        @Override
        public String getDescription() {
            return message;
        }      
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        m_jScr = new javax.swing.JScrollPane();
        m_jImage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        m_jbtnopen = new javax.swing.JButton();
        m_jbtnclose = new javax.swing.JButton();
        m_jbtnzoomin = new javax.swing.JButton();
        m_jPercent = new javax.swing.JLabel();
        m_jbtnzoomout = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        m_jScr.setBackground(new java.awt.Color(255, 255, 255));
        m_jScr.setOpaque(false);

        m_jImage.setBackground(new java.awt.Color(255, 255, 255));
        m_jImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        m_jImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/no_photo.png"))); // NOI18N
        m_jImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        m_jImage.setMaximumSize(new java.awt.Dimension(200, 200));
        m_jImage.setMinimumSize(new java.awt.Dimension(120, 120));
        m_jImage.setPreferredSize(new java.awt.Dimension(200, 200));
        m_jScr.setViewportView(m_jImage);

        add(m_jScr, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 5));
        jPanel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(0, 1, 0, 2));

        m_jbtnopen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/camera.png"))); // NOI18N
        m_jbtnopen.setToolTipText("Open Folder");
        m_jbtnopen.setPreferredSize(new java.awt.Dimension(50, 45));
        m_jbtnopen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jbtnopenActionPerformed(evt);
            }
        });
        jPanel2.add(m_jbtnopen);

        m_jbtnclose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/fileclose.png"))); // NOI18N
        m_jbtnclose.setToolTipText("Remove Picture");
        m_jbtnclose.setPreferredSize(new java.awt.Dimension(50, 45));
        m_jbtnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jbtncloseActionPerformed(evt);
            }
        });
        jPanel2.add(m_jbtnclose);

        m_jbtnzoomin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/viewmag+.png"))); // NOI18N
        m_jbtnzoomin.setToolTipText("Zoom In");
        m_jbtnzoomin.setPreferredSize(new java.awt.Dimension(50, 45));
        m_jbtnzoomin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jbtnzoominActionPerformed(evt);
            }
        });
        jPanel2.add(m_jbtnzoomin);

        m_jPercent.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        m_jPercent.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow")), javax.swing.BorderFactory.createEmptyBorder(1, 4, 1, 4)));
        m_jPercent.setOpaque(true);
        m_jPercent.setPreferredSize(new java.awt.Dimension(10, 30));
        jPanel2.add(m_jPercent);

        m_jbtnzoomout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/viewmag-.png"))); // NOI18N
        m_jbtnzoomout.setToolTipText("Zoom Out");
        m_jbtnzoomout.setPreferredSize(new java.awt.Dimension(50, 45));
        m_jbtnzoomout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jbtnzoomoutActionPerformed(evt);
            }
        });
        jPanel2.add(m_jbtnzoomout);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void m_jbtnzoomoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jbtnzoomoutActionPerformed

        decZoom();
        
    }//GEN-LAST:event_m_jbtnzoomoutActionPerformed

    private void m_jbtnzoominActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jbtnzoominActionPerformed

        incZoom();
        
    }//GEN-LAST:event_m_jbtnzoominActionPerformed

    private void m_jbtncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jbtncloseActionPerformed
        
        setImage(null);
        
    }//GEN-LAST:event_m_jbtncloseActionPerformed

    private void m_jbtnopenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jbtnopenActionPerformed
        
        doLoad();
        
    }//GEN-LAST:event_m_jbtnopenActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel m_jImage;
    private javax.swing.JLabel m_jPercent;
    private javax.swing.JScrollPane m_jScr;
    private javax.swing.JButton m_jbtnclose;
    private javax.swing.JButton m_jbtnopen;
    private javax.swing.JButton m_jbtnzoomin;
    private javax.swing.JButton m_jbtnzoomout;
    // End of variables declaration//GEN-END:variables
    
}
