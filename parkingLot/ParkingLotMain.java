public class ParkingLotMain {

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5, 5);  // Create a 5x5 parking lot.
        Vehicle car1 = new Vehicle("ABC123", VehicleType.CAR);

        boolean parked = parkingLot.parkVehicle(car1);
        if (parked) {
            System.out.println("Vehicle parked successfully.");
        } else {
            System.out.println("Failed to park the vehicle.");
        }
    }
}
