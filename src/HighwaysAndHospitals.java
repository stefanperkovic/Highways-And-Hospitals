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

        if (highwayCost >= hospitalCost){
            return (long) hospitalCost * n;
        }
        int[] roots = new int[n + 1];
        for (int i = 0; i < cities.length; i++){
            int city1 = cities[i][0];
            int city2 = cities[i][1];
            int x = city1;

            while (roots[x] != 0){
                x = roots[x];
            }
            while (roots[city1] != 0){
                int temp = roots[city1];
                roots[city1] = x;
                city1 = temp;
            }

            int z = city2;
            while (roots[z] != 0){
                z = roots[z];
            }
            while (roots[city2] != 0){
                int temp = roots[city2];
                roots[city2] = z;
                city2 = temp;
            }


            if (city1 != city2){
                roots[city2] = city1;
            }

        }
        int subgraphs = 0;
        for (int i = 1; i < roots.length; i++){
            if (roots[i] == 0){
                subgraphs++;
            }
        }

        return (long) highwayCost * (n - subgraphs) + (long)hospitalCost * subgraphs;

    }

}
