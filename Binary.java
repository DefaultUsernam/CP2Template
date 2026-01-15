// Ulises Cantor
// Menchukov
// Period 5
// 11/25/2025
// Computer Programming 3
// Binary Search written for a comparable T
/*
public class Binary {
    
     * 
     * Searches the specified array of objects using a binary search
     * 
     * algorithm.
     *
     * 
     * 
     * @param data the array to be searched
     * 
     * @param min the index of the last possible location of the target.
     * 
     * @param max the index of the first possible location of the target.
     * 
     * @param target the element being searched for
     * 
     * @return true if the desired element is found
     * 
     

    public static <T extends Comparable<T>>

            boolean binarySearch(T[] data, int min, int max, T target) {
        int mid = min + (max - min) / 2;
        int compared = target.compareTo(data[mid]);
        if (compared == 0) {
            return true;
        }
        else if (min == max) {
            return false;
        }
        else if (compared < 0) {
            return binarySearch(data, min, mid - 1, target);
        }
        else {
            return binarySearch(data, mid + 1, max, target);
        }
    }
}
*/