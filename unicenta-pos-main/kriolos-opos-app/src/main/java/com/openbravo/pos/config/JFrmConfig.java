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
package com.openbravo.pos.config;

import com.openbravo.basic.BasicException;
import com.openbravo.pos.forms.AppConfig;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.AppProperties;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

//file format
public class JFrmConfig extends javax.swing.JFrame {

    private static final Logger LOGGER = Logger.getLogger(JFrmConfig.class.getName());
    private final JPanelConfiguration config;

    /**
     * Creates new form JFrmConfig
     *
     * @param props
     */
    public JFrmConfig(AppProperties props) {

        initComponents();

        String image = "/com/openbravo/images/app_logo_48x48.png";
        try {
            this.setIconImage(ImageIO.read(JFrmConfig.class.getResourceAsStream(image)));
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Exception load icon: "+image, e);
        }
        setTitle(AppLocal.APP_NAME + " - " + AppLocal.APP_VERSION + " - " + AppLocal.getIntString("Menu.Configuration"));

        addWindowListener(new MyFrameListener());

        config = new JPanelConfiguration(props);
        config.setCloseListener(new JPanelConfiguration.CloseEventListener() {
            @Override
            public void windowClosed(JPanelConfiguration.CloseEvent e) {
                dispose();         //This frame
                System.exit(0);    //Exit JVM
            }
        });

        getContentPane().add(config, BorderLayout.CENTER);

        try {
            config.activate();
        } catch (BasicException e) {
            LOGGER.log(Level.WARNING, "Exception config: ", e);
        }
    }

    private class MyFrameListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent evt) {
            if (config.deactivate()) {
                remove(config);
                dispose();
            }
        }

        @Override
        public void windowClosed(WindowEvent evt) {
            System.exit(0);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(final String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                File configFile = (args.length > 0 ? new File(args[0]) : null);
                AppConfig config = new AppConfig(configFile);
                config.load();

                final JFrmConfig configForm = new JFrmConfig(config);
                configForm.setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(0, 0));

        setSize(new java.awt.Dimension(808, 794));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
