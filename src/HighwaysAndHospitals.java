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
            return hospitalCost * n;
        }
        int[] roots = new int[n + 1];
        for (int i = 0; i < cities[0].length; i++){
            if (roots[cities[i][0]] != roots[cities[i][1]]){
                roots[cities[i][1]] = cities[i][0];
            }

        }







    }

}
