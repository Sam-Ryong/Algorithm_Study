import java.io.*;
import java.util.*;

//허프만 코딩이랑 아리스메틱 코딩 중 하나는 무조건냄
//그림그려서 설명하게냄

public class Main {

    static int N;

    static int[][] matrix;

    static boolean detect(){
        boolean modified = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1){
                    for (int k = 0; k < N; k++) {
                        if (matrix[i][k] == 0 && matrix[j][k] == 1) {
                            matrix[i][k] = matrix[i][k] + matrix[j][k];
                            modified = true;
                        }
                    }
                }
            }

        }

        return modified;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(s[j]);
            }
        }
        boolean cont = true;
        while (cont){
            cont = detect();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();

        }

        bw.flush();

    }
}