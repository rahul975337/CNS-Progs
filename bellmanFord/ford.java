package bellmanFord;

import java.util.Scanner;

public class ford {
    public static final int MAX_VALUE = 999;

    public static void BellmanFordEvaluation(int source, int A[][], int num_ver) {
        int D[] = new int[num_ver + 1];
        boolean negativeCycle = false;
        for (int node = 1; node <= num_ver; node++) {
            D[node] = MAX_VALUE;
        }
        D[source] = 0;
        for (int node = 1; node <= num_ver; node++) {
            for (int sn = 1; sn <= num_ver; sn++) {
                for (int dn = 1; dn <= num_ver; dn++) {
                    if (node == num_ver && (D[dn] > D[sn] + A[sn][dn])) {
                        System.out.println("The Graph contains negative egde cycle");
                        negativeCycle = true;
                        break;
                    }
                    if (A[sn][dn] != MAX_VALUE) {
                        if (D[dn] > D[sn] + A[sn][dn])
                            D[dn] = D[sn] + A[sn][dn];
                    }
                }
            }
        }
        if (!negativeCycle) {
            for (int vertex = 1; vertex <= num_ver; vertex++) {
                System.out.println(
                        "distance of source" + " " + source + " " + "to" + " " + vertex + "is" + " " + D[vertex]);
            }
        }
    }

    public static void main(String[] args) {
        int num_ver = 0;
        int source;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        num_ver = scanner.nextInt();
        int A[][] = new int[num_ver + 1][num_ver + 1];
        System.out.println("Enter the adjacency matrix");
        for (int sn = 1; sn <= num_ver; sn++) {
            for (int dn = 1; dn <= num_ver; dn++) {
                A[sn][dn] = scanner.nextInt();
                if (sn == dn) {
                    A[sn][dn] = 0;
                    continue;
                }
                if (A[sn][dn] == 0) {
                    A[sn][dn] = MAX_VALUE;
                }
            }
        }
        System.out.println("Enter the source vertex");
        source = scanner.nextInt();
        // pass the source matrix and vertices
        BellmanFordEvaluation(source, A, num_ver);
        scanner.close();
    }
}