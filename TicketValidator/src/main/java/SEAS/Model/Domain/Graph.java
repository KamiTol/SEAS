package SEAS.Model.Domain;

import java.util.*;

public class Graph {
    private Map<String, List<Route>> routes;

    public Graph() {
        this.routes = new HashMap<>();
    }

    public void addRoute(Route route) {
        routes.putIfAbsent(route.getStart(), new ArrayList<>());
        routes.get(route.getStart()).add(route);
    }

    public Map<String, Integer> dijkstra(String start, Map<String, List<Route>> routes) {
        Map<String, Integer> distances = new HashMap<>();
        Set<String> visited = new HashSet<>();
        PriorityQueue<Route> queue = new PriorityQueue<>(Comparator.comparingInt(Route::getDistance));

        for (String node : routes.keySet()) {
            distances.put(node, node.equals(start) ? 0 : Integer.MAX_VALUE);
        }

        queue.add(new Route(start, start, 0));

        while (!queue.isEmpty()) {
            Route currentRoute = queue.poll();
            String currentNode = currentRoute.getEnd();

            if (!visited.add(currentNode)) {
                continue;
            }

            int currentDistance = distances.get(currentNode);

            for (Route route : routes.get(currentNode)) {
                int distanceThroughCurrentNode = currentDistance + route.getDistance();
                String neighborNode = route.getEnd();

                if (distanceThroughCurrentNode < distances.get(neighborNode)) {
                    distances.put(neighborNode, distanceThroughCurrentNode);
                    queue.add(new Route(currentNode, neighborNode, distanceThroughCurrentNode));
                }
            }
        }
        return distances;
    }

    public int getDistanceBetweenStations(String start, String end) {
        List<Route> routesFromStart = routes.get(start);
        if (routesFromStart == null) {
            return -1;  // Return -1 if there are no routes from the start station
        }
        for (Route route : routesFromStart) {
            if (route.getEnd().equals(end)) {
                return route.getDistance();
            }
        }
        return -1;  // Return -1 if there is no direct route to the end station from the start station
    }

    public int getTotalDistance(List<String> stationNames) {
        int totalDistance = 0;
        for (int i = 0; i < stationNames.size() - 1; i++) {
            int distance = getDistanceBetweenStations(stationNames.get(i), stationNames.get(i + 1));
            if (distance == -1) {
                return -1;  // Devuelve -1 si no hay una ruta directa entre algún par de estaciones
            }
            totalDistance += distance;
        }
        return totalDistance;
    }

    public Map<String, List<Route>> getRoutes() {
        return this.routes;
    }
}
