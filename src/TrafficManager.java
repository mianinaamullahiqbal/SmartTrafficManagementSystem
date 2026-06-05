import java.util.*;

public class TrafficManager {

    private VehicleQueue queue;
    private HashMap<String, Vehicle> vehicleRecords;
    private RouteGraph graph;

    private int totalVehicles;
    private int emergencyVehicles;
    private int processedVehicles;

    public TrafficManager() {

        queue = new VehicleQueue();
        vehicleRecords = new HashMap<>();
        graph = new RouteGraph();
    }

    public void addVehicle(
            String owner,
            String driver,
            String number,
            String type,
            boolean emergency) {

        int priority = 4;

        if (emergency) {

            if (type.equalsIgnoreCase("Ambulance"))
                priority = 1;

            else if (type.equalsIgnoreCase("Fire Brigade"))
                priority = 2;

            else if (type.equalsIgnoreCase("Police"))
                priority = 3;
        }

        Vehicle vehicle =
                new Vehicle(
                        owner,
                        driver,
                        number,
                        type,
                        emergency,
                        priority);

        queue.addVehicle(vehicle);

        vehicleRecords.put(number, vehicle);

        totalVehicles++;

        if (emergency)
            emergencyVehicles++;

        System.out.println("Vehicle Added Successfully.");
    }

    public void processVehicle() {

        if (queue.isEmpty()) {

            System.out.println("No Vehicles Available.");
            return;
        }

        Vehicle vehicle = queue.processVehicle();

        processedVehicles++;

        System.out.println("\nProcessing Vehicle");
        System.out.println(vehicle);
    }

    public void displayRecords() {

        ArrayList<Vehicle> list =
                new ArrayList<>(vehicleRecords.values());

        Collections.sort(
                list,
                Comparator.comparing(
                        Vehicle::getVehicleNumber
                )
        );

        for (Vehicle vehicle : list) {
            System.out.println(vehicle);
        }
    }

    public void searchVehicle(String number) {

        Vehicle vehicle =
                vehicleRecords.get(number);

        if (vehicle == null) {
            System.out.println("Vehicle Not Found.");
        }
        else {
            System.out.println(vehicle);
        }
    }

    public void displayStatistics() {

        System.out.println("\n===== STATISTICS =====");

        System.out.println("Total Vehicles : "
                + totalVehicles);

        System.out.println("Emergency Vehicles : "
                + emergencyVehicles);

        System.out.println("Processed Vehicles : "
                + processedVehicles);

        System.out.println("Records Stored : "
                + vehicleRecords.size());
    }

    public void setupRoutes() {

        graph.addLocation("Johar Town");
        graph.addLocation("Wapda Town");
        graph.addLocation("Model Town");
        graph.addLocation("Garden Town");
        graph.addLocation("Gulberg");
        graph.addLocation("DHA");
        graph.addLocation("Cantt");
        graph.addLocation("Airport");
        graph.addLocation("Bahria Town");
        graph.addLocation("Thokar Niaz Baig");

        graph.addRoad("Johar Town", "Wapda Town", 3);
        graph.addRoad("Johar Town", "Model Town", 5);

        graph.addRoad("Wapda Town", "Thokar Niaz Baig", 4);

        graph.addRoad("Model Town", "Garden Town", 3);

        graph.addRoad("Garden Town", "Gulberg", 4);

        graph.addRoad("Gulberg", "Cantt", 5);

        graph.addRoad("Cantt", "Airport", 4);

        graph.addRoad("Cantt", "DHA", 3);

        graph.addRoad("DHA", "Airport", 5);

        graph.addRoad("Bahria Town", "Thokar Niaz Baig", 8);

        graph.addRoad("Bahria Town", "DHA", 10);
    }

    public void findShortestPath(
            String start,
            String end) {

        graph.shortestPath(start, end);
    }
}