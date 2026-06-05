public class Vehicle {

    private String ownerName;
    private String driverName;
    private String vehicleNumber;
    private String vehicleType;
    private boolean emergency;
    private int priority;

    public Vehicle(String ownerName, String driverName,
                   String vehicleNumber, String vehicleType,
                   boolean emergency, int priority) {

        this.ownerName = ownerName;
        this.driverName = driverName;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.emergency = emergency;
        this.priority = priority;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {

        return "\nOwner Name : " + ownerName +
                "\nDriver Name : " + driverName +
                "\nVehicle Number : " + vehicleNumber +
                "\nVehicle Type : " + vehicleType +
                "\nEmergency : " + emergency +
                "\nPriority : " + priority +
                "\n----------------------------";
    }
}