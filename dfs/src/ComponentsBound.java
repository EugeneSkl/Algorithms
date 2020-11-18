import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ComponentsBound {
    private static int[][] A;
    private static int N;

    private static boolean[] visited;
    private static int[] comp;


    //Обход графа в глубину для вершины
    private static void dfs(int vertex, int comp_num) {
        System.out.print(vertex + " ");
        comp[vertex] = comp_num;
        visited[vertex] = true;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && A[vertex][i] == 1){
                dfs(i, comp_num);
            }
        }
    }

    private static void findComponents() {
        visited = new boolean[ N ]; //массив пройденных вершин
        comp = new int[N];
        int comp_num = 1;
        Arrays.fill(visited, false);
        System.out.println("Связные компоненты: ");
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                System.out.print("[ ");
                dfs(i, comp_num);
                comp_num++;
                System.out.println("]");

            }
        }
        int max = 0;
        for (int i = 0; i < comp.length; i++) {
            if (comp[i] > max) {
                max = comp[i];
            }
        }
        if(max == comp[0]){
            System.out.println("Можем познакомить всех");
        }
        else {
            count(comp);
        }

    }
    public static void count(int[] comp) {
        int min, max;
        max = min = comp[0];
        for (int i = 1; i < comp.length; i++) {
            if (comp[i] < min) {
                min = comp[i];
            }
            if (comp[i] > max) {
                max = comp[i];
            }
        }
        int[] count = new int[max - min + 1];
        for (int i = 0; i < comp.length; i++) {
            count[comp[i] - min]++;
        }

        max=count[0];
        for (int i = 1; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }
        System.out.println("Максимальное число знакомых человек = " + max);
    }


    public static void main(String[] args) {
        N = 4;
        A = new int[N][N];
        /*Scanner in = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                G[i][j] = in.nextInt();
            }
        }*/
        A[0][1]=1; A[0][2]=1;A[1][2]=1;//A[1][3]=1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] != A[j][i]) {
                    A[j][i] = A[i][j];
                }
            }
        }
        for (int i = 0, j = 0; i < N; i++, j++) {
            if(A[i][j] != 0){
                A[i][j] = 0;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        findComponents();
    }
}