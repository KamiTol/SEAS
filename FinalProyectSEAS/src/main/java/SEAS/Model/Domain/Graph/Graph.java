package SEAS.Model.Domain.Graph;

import SEAS.Model.Domain.Route;

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
}
