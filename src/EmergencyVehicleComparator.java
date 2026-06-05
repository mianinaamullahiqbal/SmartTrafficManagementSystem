import java.util.Comparator;

public class EmergencyVehicleComparator implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        return Integer.compare(v1.getPriority(), v2.getPriority());
    }
}