// ..

package com.openbravo.pos.payment;

import com.openbravo.pos.forms.AppConfig;
import javax.swing.JPanel;

/**
 *
 * @author Mikel Irurita
 */
public interface PaymentConfiguration {
    
    /**
     *
     * @return
     */
    public JPanel getComponent();

    /**
     *
     * @param config
     */
    public void loadProperties(AppConfig config);

    /**
     *
     * @param config
     */
    public void saveProperties(AppConfig config);
    
}
