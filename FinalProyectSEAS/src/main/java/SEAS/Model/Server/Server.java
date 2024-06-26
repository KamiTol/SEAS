package SEAS.Model.Server;

import SEAS.Model.Service.ModuleService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private final String ip;
    private final String port;
    private final String url;
    private final String serviceName;
    private final Remote service;
    private static Server server;

    public static Server getInstanceOf() throws RemoteException {
        if (server == null){
            server = new Server("192.168.1.22", "1099", "moduleService", new ModuleService());
        }
        return server;
    }

    public Server(String ip, String port, String serviceName, Remote service) {
        this.ip = ip;
        this.port = port;
        this.serviceName = serviceName;
        this.service = service;
        this.url = "//" + ip + ":" + port + "/" + serviceName;
    }

    public String getUrl() {
        return url;
    }

    public boolean deploy() {
        if (ip == null || port == null || serviceName == null) return false;

        try {
            System.setProperty("java.rmi.server.hostname", ip);
            LocateRegistry.createRegistry(Integer.parseInt(port));
            Naming.rebind(url, service);
            Logger.getLogger(this.getClass().getSimpleName()).log(Level.INFO, "Service is running on {0}", url);

            return true;
        } catch (RemoteException | MalformedURLException exception) {
            Logger.getLogger(this.getClass().getSimpleName()).log(Level.WARNING, exception.getMessage(), exception);
        }

        return false;
    }
}
