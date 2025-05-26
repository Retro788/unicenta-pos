// ..

package com.openbravo.pos.forms;

import com.openbravo.data.loader.Session;
import com.openbravo.pos.forms.AppView;

//file format
public abstract class BeanFactoryDataSingle implements BeanFactoryApp {
    
    /** Creates a new instance of BeanFactoryData */
    public BeanFactoryDataSingle() {
    }
    
    /**
     *
     * @param s
     */
    public abstract void init(Session s);

    /**
     *
     * @param app
     * @throws BeanFactoryException
     */
    @Override
    public void init(AppView app) throws BeanFactoryException {        
        init(app.getSession());                     
    }

    /**
     *
     * @return
     */
    @Override
    public Object getBean() {
        return this;
    }  
}
