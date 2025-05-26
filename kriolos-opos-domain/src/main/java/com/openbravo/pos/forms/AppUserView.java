// ..
package com.openbravo.pos.forms;

import com.openbravo.pos.forms.AppUser;

//file format
public interface AppUserView {

    /**
     *
     */
    public static final String ACTION_TASKNAME = "taskname";

    /**
     *  Current User
     * 
     * @return AppUser
     */
    public AppUser getUser();

    /**
     * Show Panel
     * 
     * @param sTaskClass
     */
    public void showTask(String sTaskClass);

    /**
     *
     * @param sTaskClass
     */
    public void executeTask(String sTaskClass);
    
    public void exitToLogin();
}
