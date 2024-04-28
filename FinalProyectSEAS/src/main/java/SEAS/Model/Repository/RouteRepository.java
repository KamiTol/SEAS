package SEAS.Model.Repository;

import SEAS.Model.Domain.Route;
import SEAS.Model.shared.FileJsonAdapter;
import java.util.List;

public class RouteRepository {
    private FileJsonAdapter<Route> fileJsonAdapter;
    private String path;

    public RouteRepository(String path) {
        this.path = path;
        this.fileJsonAdapter = FileJsonAdapter.getInstance();
    }

    public boolean insert(Route route){
        List<Route> routes = fileJsonAdapter.getObjects(path, Route[].class);
        routes.add(route);
        return fileJsonAdapter.writeObjects(path, routes);
    }

    public boolean delete(String origin, String destination){
        List<Route> routes = fileJsonAdapter.getObjects(path, Route[].class);
        for (Route route : routes) {
            if (route.getStart().equals(origin) && route.getEnd().equals(destination)){
                routes.remove(route);
                return fileJsonAdapter.writeObjects(path, routes);
            }
        }
        return false;
    }

    public boolean update(Route route){
        List<Route> routes = fileJsonAdapter.getObjects(path, Route[].class);
        for (Route r : routes) {
            if (r.getStart().equals(route.getStart()) && r.getEnd().equals(route.getEnd())) {
                r.setDistance(route.getDistance());
                return fileJsonAdapter.writeObjects(path, routes);
            }
        }
        return false;
    }

    public Route getRoute(String origin, String destination){
        List<Route> routes = fileJsonAdapter.getObjects(path, Route[].class);
        for (Route route : routes) {
            if (route.getStart().equals(origin) && route.getEnd().equals(destination)){
                return route;
            }
        }
        return null;
    }

    public List<Route> getRoutes(){
        return fileJsonAdapter.getObjects(path, Route[].class);
    }
}
