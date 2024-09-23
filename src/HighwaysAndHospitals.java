import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Stefan Perkovic
 *
 */

public class HighwaysAndHospitals {

    /**
     * Calculates the minimum cost of providing hospital access to all cities
     * by either building hospitals or connecting cities with highways.
     *
     * @param n            The number of cities.
     * @param hospitalCost The cost of building a hospital.
     * @param highwayCost  The cost of building a highway.
     * @param cities       A 2D array representing connections between cities.
     * @return The minimum cost to provide hospital access.
     */
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // If highways are more expensive or equal to hospitals, just build hospitals in every city
        if (highwayCost >= hospitalCost) {
            return (long) hospitalCost * n;
        }
        int[] roots = new int[n + 1];
        int subgraphs = n;
        // Loops through each edge between cities
        for (int i = 0; i < cities.length; i++) {
            int city1 = cities[i][0];
            int city2 = cities[i][1];

            // Finds the furthest root of each city
            int root1 = find(city1, roots);
            int root2 = find(city2, roots);

            // Union the two roots if they are different
            int result = union(root1, root2, roots);
            if (result == 1) {
                subgraphs--;
            }

        }
        // Cost of highways + cost of hospitals for remaining subgraphs
        return (long) highwayCost * (n - subgraphs) + (long) hospitalCost * subgraphs;
    }
    /**
     * Unites two roots in the union-find structure.
     *
     * @param root1 The root of the first city.
     * @param root2 The root of the second city.
     * @param roots The roots array representing the disjoint sets.
     * @return 1 if the union was successful, 0 if they were already connected.
     */
    public static int union(int root1, int root2, int[] roots){
        // Only unite if the roots are different
        if (root1 != root2) {
            int a = roots[root1];
            int b = roots[root2];
            // Attach the smaller subgraph to the bigger
            if (a < b){
                roots[root1] += roots[root2];
                roots[root2] = root1;
            }
            else if(a > b) {
                roots[root2] += roots[root1];
                roots[root1] = root2;
            }
            else{
                // Subtract extra one because the sizes are equal,
                // so merging them will create one larger tree without increasing the size count
                roots[root1] += roots[root2] - 1;
                roots[root2] = root1;
            }
            return 1;
        }
        return 0;

    }
    /**
     * Finds the root of a given city, with path compression for optimization.
     *
     * @param city  The city for which to find the root.
     * @param roots The roots array representing the disjoint sets.
     * @return The root of the city.
     */
    public static int find(int city, int[] roots){
        int bottom_root = city;
        // Traverse up to find the root
        while (roots[bottom_root] > 0) {
            bottom_root = roots[bottom_root];
        }
        // Path compression: make each node point directly to the root
        while (roots[city] > 0) {
            int temp = roots[city];
            roots[city] = bottom_root;
            city = temp;
        }
        return bottom_root;
    }


}
