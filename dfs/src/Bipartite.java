// Java program to find out whether  
// a given graph is Bipartite or not 
import java.util.*;
import java.lang.*;
import java.io.*;

public class Bipartite {
    private static int[][] A;
    private static int N;

    boolean isBipartite(int A[][],int start) {

        int color[] = new int[N];
        for (int i=0; i<N; ++i) {
            color[i] = -1;
        }
        color[start] = 1;
        LinkedList<Integer>q = new LinkedList<Integer>(); //очередь вершин
        q.add(start);
        while (q.size() != 0) {
            int i = q.poll();
            for (int j=0; j<N; ++j) {
                if ((color[j]==-1) && (A[i][j]==1)){
                    color[j] = 1-color[i];
                    q.add(j);
                }
                else if ((color[j]==color[i]) && (A[i][j]==1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main (String[] args) {
        N = 5;
        A = new int[N][N];
        A[0][2]=1; A[0][3]=1;A[0][4]=1;
        A[1][2]=1;A[1][3]=1;A[1][4]=1;

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
        Bipartite b = new Bipartite();
        if (b.isBipartite(A, 0))
            System.out.println("Да, граф двудольный");
        else
            System.out.println("Нет, граф не двудольный");
    }
} 