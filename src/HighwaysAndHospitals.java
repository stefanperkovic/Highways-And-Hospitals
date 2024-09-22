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

                x = roots[x];
            }
            while (roots[city1] > 0){
                int temp = roots[city1];
                roots[city1] = x;
                city1 = temp;
            }

            int z = city2;
            while (roots[z] > 0){
                z = roots[x];
            }
            while (roots[city2] > 0){
                int temp = roots[city2];
                roots[city2] = x;
                city2 = temp;
            }

            if (x != z){
                int a = roots[x];
                int b = roots[z];
                if (a >= b){
                    roots[x] += roots[z] - 1;
                    roots[z] = x;
                }
                else{
                    roots[z] += roots[x] - 1;
                    roots[x] = z;
                }


            }

        }
        int subgraphs = 0;
        for (int i = 1; i < roots.length; i++){
            if (roots[i] < 0){
                subgraphs++;
            }
        }
        System.out.println((long) highwayCost * (n - subgraphs) + (long)hospitalCost * subgraphs);
        return (long) highwayCost * (n - subgraphs) + (long)hospitalCost * subgraphs;

    }

}
