import java.util.*;

public class RouteGraph {

    private HashMap<String, HashMap<String, Integer>> graph;

    public RouteGraph() {
        graph = new HashMap<>();
    }

    public void addLocation(String location) {
        graph.putIfAbsent(location, new HashMap<>());
    }

    public void addRoad(String source,
                        String destination,
                        int distance) {

        graph.get(source).put(destination, distance);
        graph.get(destination).put(source, distance);
    }

    public void shortestPath(String start, String end) {

        if (!graph.containsKey(start)
                || !graph.containsKey(end)) {

            System.out.println("Invalid Location.");
            return;
        }

        HashMap<String, Integer> distance = new HashMap<>();
        HashMap<String, String> previous = new HashMap<>();

        PriorityQueue<String> pq =
                new PriorityQueue<>(
                        Comparator.comparingInt(distance::get)
                );

        for (String city : graph.keySet()) {
            distance.put(city, Integer.MAX_VALUE);
        }

        distance.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {

            String current = pq.poll();

            for (String neighbour :
                    graph.get(current).keySet()) {

                int newDistance =
                        distance.get(current)
                                + graph.get(current).get(neighbour);

                if (newDistance < distance.get(neighbour)) {

                    distance.put(neighbour, newDistance);
                    previous.put(neighbour, current);
                    pq.add(neighbour);
                }
            }
        }

        LinkedList<String> path = new LinkedList<>();

        String current = end;

        while (current != null) {
            path.addFirst(current);
            current = previous.get(current);
        }

        System.out.println("\n===== ROUTE DETAILS =====");

        for (String city : path) {
            System.out.println(city);
        }

        System.out.println("\nTotal Distance : "
                + distance.get(end)
                + " KM");

        System.out.println("Estimated Time : "
                + (distance.get(end) * 2)
                + " Minutes");
    }
}