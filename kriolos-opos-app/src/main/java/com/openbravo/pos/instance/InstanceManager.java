// ..
package com.openbravo.pos.instance;

import java.io.IOException;
import java.net.ServerSocket;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

//file format
public class InstanceManager {

    private static final Logger LOGGER = Logger.getLogger(InstanceManager.class.getName());
    private static final String APPLICATION_ID = "com.openbravo.pos.instance.Kriolos-POS";
    private Registry registry;
    private final AppMessage message;
    private final int RMI_PORT = 3005;

    /**
     * Creates a new instance of InstanceManager
     *
     * @param message
     * @throws java.rmi.RemoteException
     * @throws java.rmi.AlreadyBoundException
     */
    public InstanceManager(AppMessage message) throws RemoteException, AlreadyBoundException {
        this.message = message;
    }

    public static AppMessage queryInstance() throws RemoteException, NotBoundException {
        LOGGER.info("Query for instance identify by ID: " + APPLICATION_ID);
        return (AppMessage) LocateRegistry.getRegistry().lookup(APPLICATION_ID);
    }

    /**
     * Creates a new instance of InstanceQuery
     *
     * @return
     * @throws java.rmi.RemoteException
     * @throws java.rmi.AlreadyBoundException
     */
    public boolean registerInstance() throws RemoteException, AlreadyBoundException {
        LOGGER.info("Create a instance identify by ID: " + APPLICATION_ID + " on PORT: "+RMI_PORT);
        AppMessage stub = (AppMessage) UnicastRemoteObject.exportObject(this.message, 0);
        this.registry = LocateRegistry.createRegistry(RMI_PORT);
        this.registry.bind(APPLICATION_ID, stub);
        return true;
    }
}
