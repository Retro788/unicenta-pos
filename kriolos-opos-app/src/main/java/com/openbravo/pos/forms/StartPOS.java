// .
package com.openbravo.pos.forms;

import com.openbravo.pos.instance.InstanceManager;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.File;
import java.rmi.RemoteException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class StartPOS {

    private static final Logger LOGGER = Logger.getLogger(StartPOS.class.getName());

    public static void main(final String args[]) {
        // Establecer la localización en español
        Locale.setDefault(new Locale("es", "ES"));
        
        File configFile = (args.length > 0 ? new File(args[0]) : null);
        AppConfig config = new AppConfig(configFile);
        config.load();
        AppConfig.applySystemProperties(config);

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                final JRootFrame rootframe = new JRootFrame(config);
                if (1 != 1 && "true".equals(config.getProperty("machine.uniqueinstance"))) {

                    try {
                        InstanceManager.queryInstance().restoreWindow();
                    } catch (RemoteException | NotBoundException e) {
                        String msg = "Cannot start the application. Another instance is alreday running";
                        LOGGER.log(Level.WARNING, msg, e);
                        //Open A Window a Present a message to User
                        //Wait maximun 30 second and close
                        JOptionPane.showMessageDialog(null,
                                msg,
                                AppLocal.APP_NAME, JOptionPane.WARNING_MESSAGE);
                        System.exit(-1000);
                    }

                    // Register the running application
                    try {
                        final InstanceManager instmanager = new InstanceManager(rootframe);
                        instmanager.registerInstance();

                    } catch (RemoteException | AlreadyBoundException e) {
                        String msg = "Cannot start the application. Cannot register a new instance";
                        LOGGER.log(Level.WARNING, msg, e);
                        //Open A Window a Present a message to User
                        //Wait maximun 30 second and close
                        JOptionPane.showMessageDialog(null,
                                msg,
                                AppLocal.APP_NAME, JOptionPane.WARNING_MESSAGE);
                        System.exit(-1001);
                    }
                }
                
                rootframe.initFrame();
            }
        });
    }
}
