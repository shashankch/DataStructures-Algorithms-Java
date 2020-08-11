package graphs;

import java.util.Arrays;
import java.util.Scanner;


// Time complexity
// ---> O(V^2)
// using priority queue to find min O(V(l0gV+V))

// using pq and adjacency list:  O((V+E)logV)
public class prims {

    public static int findMinVertex(int weights[], boolean visited[], int n) {


        int minVertex = -1;

        for (int i = 0; i < n; i++) {


            if (visited[i] == false && (minVertex == -1 || weights[i] < weights[minVertex])) {
                minVertex = i;
            }

        }

        return minVertex;


    }



    public static void primAlgo(int[][] edges, int V) {

        int parent[] = new int[V];
        int weights[] = new int[V];

        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            visited[i] = false;
            weights[i] = Integer.MAX_VALUE;
        }

        parent[0] = -1;
        weights[0] = 0;

        for (int i = 0; i < V; i++) {

            int minVertex = findMinVertex(weights, visited, V);

            visited[minVertex] = true;

            for (int j = 0; j < V; j++) {

                if (edges[minVertex][j] != 0 && visited[j] == false) {

                    if (edges[minVertex][j] < weights[j]) {

                        weights[j] = edges[minVertex][j];
                        parent[j] = minVertex;
                    }

                }
            }



        }



        for (int i = 1; i < V; i++) {

            if (parent[i] < i) {
                System.out.println(parent[i] + " " + i + " " + weights[i]);
            } else {
                System.out.println(i + " " + parent[i] + " " + weights[i]);
            }
        }


    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        int edges[][] = new int[V][V];

        for (int i = 0; i < V; i++) {

            for (int j = 0; j < V; j++) {

                edges[i][j] = 0;
            }
        }

        for (int i = 0; i < E; i++) {

            int f = sc.nextInt();
            int s = sc.nextInt();
            int w = sc.nextInt();

            edges[f][s] = w;
            edges[s][f] = w;

        }

        primAlgo(edges, V);



    }

}
