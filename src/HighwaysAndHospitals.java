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
        // If highways are more expensive or equal to hospitals, just build hospitals in every city
        if (highwayCost >= hospitalCost){
            System.out.println((long) hospitalCost * n);
            return (long) hospitalCost * n;
        }
        int[] roots = new int[n + 1];
        for (int i = 0; i < cities.length; i++){
            int city1 = cities[i][0];
            int city2 = cities[i][1];

            int x = city1;
            while (roots[x] > 0){
                roots[x] = roots[roots[x]];
                x = roots[x];
            }

            int z = city2;
            while (roots[z] > 0){
                roots[z] = roots[roots[z]];
                z = roots[z];
            }


            if (x != z){

                roots[z] = x;
            }

        }
        int subgraphs = 0;
        for (int i = 1; i < roots.length; i++){
            if (roots[i] <= 0){
                subgraphs++;
            }
        }
        System.out.println((long) highwayCost * (n - subgraphs) + (long)hospitalCost * subgraphs);
        return (long) highwayCost * (n - subgraphs) + (long)hospitalCost * subgraphs;

    }

}
