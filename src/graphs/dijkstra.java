package graphs;

import java.util.Scanner;

// single source shortest path.. should not have -ve weights.
// Time complexity
// O(V^2)---> for every V --> we do V times minvertex and V times neighbours=> V(2*V)
// adjacency list improves complexity: O(V+E)
// use priority queue for minVertex:O(logV)
// here sort needed for pq pairs(Vertex no,dist) sort based on distance(changes)
// O(V^2) ---> O(V(log+V))  ---> O((V+E)logV)
public class dijkstra {

    public static int findMinVertex(int weights[], boolean visited[], int n) {


        int minVertex = -1;

        for (int i = 0; i < n; i++) {


            if (visited[i] == false && (minVertex == -1 || weights[i] < weights[minVertex])) {
                minVertex = i;
            }

        }

        return minVertex;


    }



    public static void dijAlgo(int[][] edges, int V) {

        int dist[] = new int[V];


        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
        }


        dist[0] = 0;

        for (int i = 0; i < V - 1; i++) {

            int minVertex = findMinVertex(dist, visited, V);

            visited[minVertex] = true;

            for (int j = 0; j < V; j++) {

                if (edges[minVertex][j] != 0 && visited[j] == false) {

                    int dis = dist[minVertex] + edges[minVertex][j];
                    if (dis < dist[j]) {

                        dist[j] = dis;

                    }

                }
            }



        }



        for (int i = 0; i < V; i++) {


            System.out.println(i + " " + dist[i]);
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

        dijAlgo(edges, V);



    }


}
