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
            return hospitalCost * cities.length;
        }


        boolean[][] connections = new boolean[n + 1][n + 1];
        for (int i = 0; i < cities.length; i++){
            int start = cities[i][0];
            int end = cities[i][1];
            connections[start][end] = true;
            connections[end][start] = true;
        }



        return 0;
    }

}
