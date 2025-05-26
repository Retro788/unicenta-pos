// ..

package com.openbravo.pos.config;

import com.openbravo.data.user.DirtyManager;
import com.openbravo.pos.util.StringParser;
import java.awt.Component;

/**
 *
 * @author adrian
 */
public interface ParametersConfig {

    /**
     *
     * @return
     */
    public Component getComponent();
    
    /**
     *
     * @param dirty
     */
    public void addDirtyManager(DirtyManager dirty);

    /**
     *
     * @param p
     */
    public void setParameters(StringParser p);

    /**
     *
     * @return
     */
    public String getParameters();

}
