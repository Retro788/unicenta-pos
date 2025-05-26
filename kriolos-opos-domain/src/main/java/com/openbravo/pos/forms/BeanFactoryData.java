// ..

package com.openbravo.pos.forms;

import com.openbravo.pos.forms.AppView;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

//file format
public class BeanFactoryData implements BeanFactoryApp {
    
    private static final Logger LOGGER = Logger.getLogger(BeanFactoryData.class.getName());
    
    private BeanFactoryApp bf;
    
    /** Creates a new instance of BeanFactoryData */
    public BeanFactoryData() {
    }
    
    /**
     *
     * @param app
     * @throws BeanFactoryException
     */
    @Override
    public void init(AppView app) throws BeanFactoryException {  
        
        try {
            
            String sfactoryname = this.getClass().getName();
            if (sfactoryname.endsWith("Create")) {
                sfactoryname = sfactoryname.substring(0, sfactoryname.length() - 6);
            }
            bf = (BeanFactoryApp) Class.forName(sfactoryname + app.getSession().DB.getName()).getDeclaredConstructor().newInstance();
            bf.init(app);                     
// JG 16 May use multicatch
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | BeanFactoryException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
            LOGGER.log(Level.WARNING, "Cannot found Bean ", ex);
            throw new BeanFactoryException(ex);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public Object getBean() {
        return bf.getBean();
    }         
}
