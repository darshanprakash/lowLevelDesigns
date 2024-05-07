import java.util.LinkedList;
import java.util.Queue;

public class ParkingLot {
    private final ParkingSpot[][] spots;
    private final int numRows;
    private final int numColumns;
    private final Object lock = new Object();  // A lock object for synchronization

    public ParkingLot(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.spots = new ParkingSpot[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                spots[i][j] = new ParkingSpot(i, j);
            }
        }
    }

    public ParkingSpot findNearestFreeSpot() {
        synchronized (lock) {  // Synchronize on the lock object
            Queue<ParkingSpot> queue = new LinkedList<>();
            boolean[][] visited = new boolean[numRows][numColumns];

            // Define directions: up, down, left, right
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            // Assuming the entrance is at (0,0), enqueue the first spot
            queue.add(spots[0][0]);
            visited[0][0] = true;

            while (!queue.isEmpty()) {
                ParkingSpot currentSpot = queue.poll();

                if (!currentSpot.isOccupied()) {
                    return currentSpot;
                }

                int row = currentSpot.getRow();
                int col = currentSpot.getColumn();

                // Check all four possible directions
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // Check if new position is within bounds and not visited
                    if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numColumns && !visited[newRow][newCol]) {
                        queue.add(spots[newRow][newCol]);
                        visited[newRow][newCol] = true;
                    }
                }
            }

            return null; // If no spots are free
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        synchronized (lock) {  // Synchronize on the lock object
            ParkingSpot spot = findNearestFreeSpot();
            if (spot != null) {
                spot.parkVehicle(vehicle);
                return true;
            }
            return false;
        }
    }
}
