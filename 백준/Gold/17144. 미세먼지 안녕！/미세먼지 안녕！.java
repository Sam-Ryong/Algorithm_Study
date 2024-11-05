import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {

    static int R,C,T;
    static int[][] A;
    static int sum = 0;


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void spread(){
        int[][] grad = new int[R+1][C+1];
        for (int i = 1; i < R+1; i++) {
            for (int j = 1; j < C+1; j++) {
                int micro = A[i][j];
                if (micro >= 5){
                    if (i > 1 && A[i-1][j] != -1) {
                        grad[i-1][j] += micro / 5;
                        grad[i][j] -= micro / 5;
                    }
                    if (j > 1 && A[i][j-1] != -1) {
                        grad[i][j-1] += micro / 5;
                        grad[i][j] -= micro / 5;
                    }
                    if (i < R && A[i+1][j] != -1) {
                        grad[i+1][j] += micro / 5;
                        grad[i][j] -= micro / 5;
                    }
                    if (j < C && A[i][j+1] != -1) {
                        grad[i][j+1] += micro / 5;
                        grad[i][j] -= micro / 5;
                    }

                }
            }
        }
        for (int i = 1; i < R+1; i++) {
            for (int j = 1; j < C+1; j++) {
                A[i][j] += grad[i][j];
            }
        }
    }

    public static void circular1(int i){
        //sum = sum - A[1][i-1];
        for (int j = i-2; j > 0; j--) {
            A[j+1][1] = A[j][1];
        }

        for (int j = 2; j < C+1; j++) {
            A[1][j-1] = A[1][j];
        }

        for (int j = 2; j <= i; j++) {
            A[j-1][C] = A[j][C];
        }

        for (int j = C-1; j > 1; j--) {
            A[i][j+1] = A[i][j];
        }
        A[i][2] = 0;
    }
    public static void circular2(int i){
        //sum = sum - A[1][i+1];
        for (int j = i+2; j < R+1; j++) {
            A[j-1][1] = A[j][1];
        }

        for (int j = 2; j < C+1; j++) {
            A[R][j-1] = A[R][j];
        }

        for (int j = R-1; j >= i; j--) {
            A[j+1][C] = A[j][C];
        }
        for (int j = C-1; j > 1; j--) {
            A[i][j+1] = A[i][j];
        }
        A[i][2] = 0;
    }

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        T = Integer.parseInt(s[2]);
        A = new int[R+1][C+1];
        int[] circulate = new int[2];
        for (int i = 1; i < R+1; i++) {
            s = br.readLine().split(" ");
            for (int j = 1; j < C+1; j++) {
                A[i][j] = Integer.parseInt(s[j-1]);
                if (A[i][j] == -1) {
                    if (circulate[0] == 0)
                        circulate[0] = i;
                    else
                        circulate[1] = i;
                }
/*                else
                    sum += A[i][j];*/
            }
        }
        int time = 0;
        while (time < T){
            spread();
/*            for (int i = 1; i < R+1; i++) {
                for (int j = 1; j < C+1; j++) {
                    System.out.print(A[i][j] +" ");
                }
                System.out.println();

            }
            System.out.println();*/
            circular1(circulate[0]);
            circular2(circulate[1]);
/*            for (int i = 1; i < R+1; i++) {
                for (int j = 1; j < C+1; j++) {
                    System.out.print(A[i][j] +" ");
                }
                System.out.println();

            }*/
            time++;

        }
        for (int i = 1; i < R+1; i++) {
            for (int j = 1; j < C+1; j++) {
                if (A[i][j] > 0)
                    sum = sum + A[i][j];
            }

        }
        System.out.println(sum);

    }
}