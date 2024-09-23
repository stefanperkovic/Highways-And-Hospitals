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


    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {

        if (highwayCost >= hospitalCost) {
            return (long) hospitalCost * n;
        }
        int[] roots = new int[n + 1];
        int subgraphs = n;
        for (int i = 0; i < cities.length; i++) {
            int city1 = cities[i][0];
            int city2 = cities[i][1];

            int root1 = find(city1, roots);

            int root2 = find(city2, roots);


            int result = union(root1, root2, roots);
            if (result == 1) {
                subgraphs--;
            }

        }

        return (long) highwayCost * (n - subgraphs) + (long) hospitalCost * subgraphs;
    }

    public static int union(int root1, int root2, int[] roots){
        if (root1 != root2) {
            int a = roots[root1];
            int b = roots[root2];
            if (a < b){
                roots[root1] += roots[root2];
                roots[root2] = root1;
            }
            else if(a > b) {
                roots[root2] += roots[root1];
                roots[root1] = root2;
            }
            else{
                roots[root1] += roots[root2] - 1;
                roots[root2] = root1;
            }
            return 1;
        }
        return 0;

    }

    public static int find(int city, int[] roots){
        int bottom_root = city;
        while (roots[bottom_root] > 0) {
            bottom_root = roots[bottom_root];
        }

        while (roots[city] > 0) {
            int temp = roots[city];
            roots[city] = bottom_root;
            city = temp;
        }
        return bottom_root;
    }


}
