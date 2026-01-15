package waterflow;
// Ulises Cantor
// Period 5
// 12/1/2025
// Menchukov
// Computer Programming 3
// This method checks to see if the water will eventually "fall" off the edge according to the rubric by utilizing recursion

/*
public class Water {

    // Precondition: valid map array, col and row are within range for map
    // Postcondition: returns a boolean based on if the water will eventually "fall" off
    public static boolean canFlowOff(int[][] map, int row, int col) {
        // base cases, check to see if the water is on the edge of the map array 
        if (col == 0 || col == map[0].length - 1|| row == 0 || row == map.length - 1){
            return true;
        }
        // checks the box below to see if it's in range, if its value is lower than the current box, and if it will eventually return true for falling off
        if ( row + 1 < map.length && map[row + 1][col] < map[row][col] && canFlowOff(map, row+1, col)){
            return true;
        }
        // checks the box above to see if it's in range, if its value is lower than the current box, and if it will eventually return true for falling off
        if ( row > 0 && map[row - 1][col] < map[row][col] && canFlowOff(map, row-1, col)){
            return true;
        } 
        // checks the right box to see if it's in range, if its value is lower than the current box, and if it will eventually return true for falling off
        if ( col + 1 < map[0].length && map[row][col + 1] < map[row][col] && canFlowOff(map, row, col+1)){
            return true;
        } 
        // checks the left right box to see if it's in range, if its value is lower than the current box, and if it will eventually return true for falling off
        if ( col > 0 && map[row][col - 1] < map[row][col] && canFlowOff(map, row, col-1)){
            return true;
        }
        // returns false if nothing else works
        return false;

    }

    public static void main(String[] args) {

        // testing map arrays
        int[][] map = {
                { 100, 99, 200, 200, 200, 200, 200, 200, 200, 200 },
                { 200, 98, 200, 200, 200, 200, 200, 200, 200, 200 },
                { 200, 97, 96, 200, 200, 200, 200, 200, 200, 200 },
                { 200, 200, 95, 200, 200, 200, 85, 84, 83, 200 },
                { 200, 200, 94, 93, 92, 200, 86, 200, 82, 200 },
                { 200, 150, 200, 200, 91, 200, 87, 200, 81, 200 },
                { 200, 200, 200, 200, 90, 89, 88, 200, 80, 200 },
                { 200, 150, 100, 200, 200, 200, 200, 200, 79, 200 },
                { 200, 200, 200, 200, 200, 200, 200, 200, 78, 77 },
                { 200, 98, 200, 200, 200, 200, 200, 200, 200, 76 }
        };

        int[][] map2 = {
                { 100, 200, 200, 200, 200, 200, 200, 200, 200, 200 },
                { 200, 200, 200, 200, 200, 200, 200, 200, 200, 200 },
                { 200, 10, 200, 200, 200, 200, 200, 200, 200, 200 },
                { 200, 11, 10, 200, 200, 6, 85, 84, 83, 200 },
                { 200, 200, 14, 15, 59, 200, 86, 200, 82, 200 },
                { 200, 11, 12, 200, 200, 200, 87, 200, 81, 200 },
                { 200, 10, 200, 200, 90, 89, 88, 200, 200, 200 },
                { 200, 9, 8, 200, 200, 200, 200, 200, 200, 200 },
                { 200, 200, 7, 200, 200, 200, 200, 200, 200, 200 },
                { 200, 98, 6, 200, 200, 200, 200, 200, 200, 200 }
        };

        // checks and prints if the water fell off each map with different test cases
        if (Water.canFlowOff(map, 6, 1)) { // should not fall off
            System.out.println("Fell off map1");
        } else {
            System.out.println("Didn't fall off map2");
        }

        if (Water.canFlowOff(map2, 7, 3)) { // should fall off
            System.out.println("Fell off map2");
        } else {
            System.out.println("Didn't fall off map2");
        }
    }

}
    */