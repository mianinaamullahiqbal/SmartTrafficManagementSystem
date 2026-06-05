import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class VehicleQueue {

    private Queue<Vehicle> normalQueue;
    private PriorityQueue<Vehicle> emergencyQueue;

    public VehicleQueue() {

        normalQueue = new LinkedList<>();
        emergencyQueue = new PriorityQueue<>(
                new EmergencyVehicleComparator()
        );
    }

    public void addVehicle(Vehicle vehicle) {

        if (vehicle.isEmergency()) {
            emergencyQueue.add(vehicle);
        } else {
            normalQueue.add(vehicle);
        }
    }

    public Vehicle processVehicle() {

        if (!emergencyQueue.isEmpty()) {
            return emergencyQueue.poll();
        }

        return normalQueue.poll();
    }

    public boolean isEmpty() {
        return normalQueue.isEmpty() && emergencyQueue.isEmpty();
    }
}