package graphs;

import java.util.Arrays;
import java.util.Scanner;


// Time complexity

// take input---E
// sort all edges---ElogE
// pick n-1 safe edges and add in mst(cycle detection) ---> E*V (skewed structure worst case) union find algo

// ElogE +EV where E is O(V^2)
//  here EV can be improved by using union find with rank & path compression (ElogV) ( to avoid skewness)

class Edge implements Comparable<Edge> {

    int v1;
    int v2;
    int weight;

    Edge(int v1, int v2, int weight) {

        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {

        return this.weight - o.weight;
    }
}



public class kruskals {

    public static int findParent(int v, int parent[]) {


        if (parent[v] == v) {
            return v;
        }

        return findParent(parent[v], parent);


    }


    public static Edge[] kruskalsAlgo(Edge[] edges, int V) {

        Arrays.sort(edges);

        Edge mst[] = new Edge[V - 1];
        int parent[] = new int[V];

        for (int j = 0; j < V; j++) {
            parent[j] = j;
        }

        int count = 0;
        int i = 0;
        while (count != V - 1) {

            Edge curEdge = edges[i++];

            int pv1 = findParent(curEdge.v1, parent);
            int pv2 = findParent(curEdge.v2, parent);
            if (pv1 != pv2) {

                // include current edge
                mst[count] = curEdge;
                count++;
                parent[pv1] = pv2;
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();

        Edge edges[] = new Edge[E];
        for (int i = 0; i < E; i++) {

            int v1 = s.nextInt();
            int v2 = s.nextInt();
            int weight = s.nextInt();
            Edge edge = new Edge(v1, v2, weight);
            edges[i] = edge;

        }

        Edge mst[] = kruskalsAlgo(edges, V);

        for (int i = 0; i < mst.length; i++) {

            if (mst[i].v1 < mst[i].v2) {
                System.out.println(mst[i].v1 + " " + mst[i].v2 + " " + mst[i].weight);
            } else {
                System.out.println(mst[i].v2 + " " + mst[i].v1 + " " + mst[i].weight);
            }
        }

    }

}
