// ..

package com.openbravo.pos.instance;

import java.rmi.Remote;
import java.rmi.RemoteException;

//file format
public interface AppMessage extends Remote {
    
    /**
     *
     * @throws RemoteException
     */
    public void restoreWindow() throws RemoteException;    
}
