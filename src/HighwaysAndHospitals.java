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
            return hospitalCost * cities.length;
        }


        boolean[][] connections = new boolean[n + 1][n + 1];
        for (int i = 0; i < cities.length; i++){
            int start = cities[i][0];
            int end = cities[i][1];
            connections[start][end] = true;
            connections[end][start] = true;
        }

        boolean[] visited = new boolean[n + 1];
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Long> sub_trees = new ArrayList<>(Long);
        for (int i = 1; i <= n; i++){
            if(!visited[i]){
                stack.push(i);
                visited[i] = true;
                while (!stack.isEmpty()){
                    int city = stack.pop();

                    for (int j = i; j <= n; j++){
                        if (connections[city][j]){
                            if (!visited[j]){
                                stack.push(j);
                                visited[j] = true;
                            }
                        }
                    }
                }


            }
        }


        return 0;
    }

}
