// ..


package com.openbravo.data.user;

/**
 *
 * @author  adrian
 */
public interface StateListener extends java.util.EventListener {
 
    /**
     *
     * @param iState
     */
    public void updateState(int iState);   
}
