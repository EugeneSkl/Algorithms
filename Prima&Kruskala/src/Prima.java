import java.util.*;

public class Prima {

    public static long MinSpanTree(List<Edge>[] edges, int[] pred) {
        int n = edges.length;
        for (int i=0; i<pred.length; i++){
            pred[i]=-1;
        }
        boolean[] visited = new boolean[n];

        int[] prios = new int[n];
        for (int i=0; i<pred.length; i++){
            prios[i]=Integer.MAX_VALUE;
        }
        prios[0] = 1;

        Queue<QItem> q = new PriorityQueue<QItem>();
        q.add(new QItem(0, 0));
        long res = 0;
        while (!q.isEmpty()) {
            QItem cur = q.poll();
            int u = cur.u;
            if (visited[u]) {
                continue;
            }

            visited[u] = true;
            res += cur.prios;
            for (Edge e : edges[u]) {
                int v = e.num;
                if (!visited[v] && prios[v]>e.cost)
                {
                    prios[v] = e.cost;
                    pred[v] = u;
                    q.add(new QItem(prios[v], v));
                }
            }
        }
        return res;
    }

    static class Edge {
        int num, cost;

        public Edge(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    static class QItem implements Comparable<QItem> {
        int prios;
        int u;

        public QItem(int prios, int u) {
            this.prios = prios;
            this.u = u;
        }

        public int compareTo(QItem q) {
            return prios < q.prios ? -1 : prios > q.prios ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 0, 2, 3 },
                         { 3, 0, 2 },
                         { 2, 3, 0 } };

        int n = matrix.length;
        List<Edge>[] edges = new List[n];

        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<Edge>();
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    edges[i].add(new Edge(j, matrix[i][j]));
                }
            }
        }
        long result = MinSpanTree(edges, new int[n]);
        System.out.println("Минимальное остовное дерево массой: " + result);
    }
}