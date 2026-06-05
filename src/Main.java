import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TrafficManager manager =
                new TrafficManager();

        manager.setupRoutes();

        int choice;

        do {

            System.out.println(
                    "\n===== SMART TRAFFIC MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Normal Vehicle");
            System.out.println("2. Add Emergency Vehicle");
            System.out.println("3. Process Vehicle");
            System.out.println("4. Display Records");
            System.out.println("5. Find Shortest Route");
            System.out.println("6. Traffic Signal");
            System.out.println("7. Search Vehicle");
            System.out.println("8. Statistics");
            System.out.println("0. Exit");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Owner Name : ");
                    String owner = sc.nextLine();

                    System.out.print("Driver Name : ");
                    String driver = sc.nextLine();

                    System.out.print("Vehicle Number : ");
                    String number = sc.nextLine();

                    System.out.print("Vehicle Type : ");
                    String type = sc.nextLine();

                    manager.addVehicle(
                            owner,
                            driver,
                            number,
                            type,
                            false);

                    break;

                case 2:

                    System.out.print("Owner Name : ");
                    String eOwner = sc.nextLine();

                    System.out.print("Driver Name : ");
                    String eDriver = sc.nextLine();

                    System.out.print("Vehicle Number : ");
                    String eNumber = sc.nextLine();

                    System.out.print(
                            "Type (Ambulance/Fire Brigade/Police) : ");

                    String eType = sc.nextLine();

                    manager.addVehicle(
                            eOwner,
                            eDriver,
                            eNumber,
                            eType,
                            true);

                    break;

                case 3:
                    manager.processVehicle();
                    break;

                case 4:
                    manager.displayRecords();
                    break;

                case 5:

                    System.out.println(
                            "\nLocations:");

                    System.out.println(
                            "Johar Town, Wapda Town, Model Town");

                    System.out.println(
                            "Garden Town, Gulberg, DHA");

                    System.out.println(
                            "Cantt, Airport, Bahria Town");

                    System.out.println(
                            "Thokar Niaz Baig");

                    System.out.print("Start : ");
                    String start = sc.nextLine();

                    System.out.print("Destination : ");
                    String end = sc.nextLine();

                    manager.findShortestPath(start, end);

                    break;

                case 6:

                    TrafficSignal signal =
                            new TrafficSignal();

                    signal.startSignal();

                    break;

                case 7:

                    System.out.print(
                            "Enter Vehicle Number : ");

                    String search =
                            sc.nextLine();

                    manager.searchVehicle(search);

                    break;

                case 8:

                    manager.displayStatistics();

                    break;

                case 0:

                    System.out.println(
                            "System Closed.");

                    break;

                default:

                    System.out.println(
                            "Invalid Choice.");
            }

        } while (choice != 0);
    }
}