// ..

package com.openbravo.pos.forms;

import com.openbravo.pos.forms.AppView;

//file format
public interface BeanFactoryApp extends BeanFactory {

    /**
     *
     * @param app
     * @throws BeanFactoryException
     */
    public void init(AppView app) throws BeanFactoryException;

}
