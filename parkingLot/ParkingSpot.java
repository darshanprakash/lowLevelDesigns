public class ParkingSpot {
    private int row;
    private int column;
    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSpot(int row, int column) {
        this.row = row;
        this.column = column;
        this.vehicle = null;
        this.isOccupied = false;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
