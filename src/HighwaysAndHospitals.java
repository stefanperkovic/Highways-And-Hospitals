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
        for (int i = 0; i < cities.length; i++) {
            int city1 = cities[i][0];
            int city2 = cities[i][1];
            int root1 = city1;

            while (roots[root1] != 0) {
                root1 = roots[root1];
            }
            while (roots[city1] != 0) {
                int temp = roots[city1];
                roots[city1] = root1;
                city1 = temp;
            }
            int root2 = city2;
            while (roots[root2] != 0) {
                root2 = roots[root2];
            }
            while (roots[city2] != 0) {
                int temp = roots[city2];
                roots[city2] = root2;
                city2 = temp;
            }

            union(root1, root2, roots);


        }
        int subgraphs = 0;
        for (int i = 1; i < roots.length; i++) {
            if (roots[i] == 0) {
                subgraphs++;
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
        }


    }


}
