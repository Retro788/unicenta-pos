// ..

package com.openbravo.pos.forms;

//file format
public class BeanFactoryObj implements BeanFactory {
    
    private Object bean = null;
    
    /** Creates a new instance of BeanFactoryObj
     * @param bean */
    public BeanFactoryObj(Object bean) {
        this.bean = bean;
    }
    
    /**
     *
     * @return
     */
    @Override
    public Object getBean() {
        return bean;
    }
    
}
