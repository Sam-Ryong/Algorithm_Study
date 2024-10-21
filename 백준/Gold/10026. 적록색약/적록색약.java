import java.io.*;
import java.util.*;

//허프만 코딩이랑 아리스메틱 코딩 중 하나는 무조건냄
//그림그려서 설명하게냄

public class Main {

    static int N;

    static char[][] normal;
    static char[][] abnormal;

    static void detect(int i, int j, char color){
        if (i > N - 1|| j > N - 1|| i < 0 || j < 0)
            return;
        if (normal[i][j] != color)
            return;
        normal[i][j] = 'X';
        detect(i-1,j,color);
        detect(i+1,j,color);
        detect(i,j-1,color);
        detect(i,j+1,color);
    }

    static void detect2(int i, int j, char color){
        if (i > N - 1|| j > N - 1|| i < 0 || j < 0)
            return;
        if (abnormal[i][j] != color)
            return;
        abnormal[i][j] = 'X';
        detect2(i-1,j,color);
        detect2(i+1,j,color);
        detect2(i,j-1,color);
        detect2(i,j+1,color);
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        normal = new char[N][N];
        abnormal = new char[N][N];

        for (int i = 0; i < N; i++) {
            normal[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                abnormal[i][j] = (normal[i][j] == 'R') || (normal[i][j] == 'G') ? 'R' : 'B';
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (normal[i][j] != 'X'){
                    count++;
                    detect(i,j,normal[i][j]);
                }
            }
        }
        bw.write(String.valueOf(count) + " ");
        count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (abnormal[i][j] != 'X'){
                    count++;
                    detect2(i,j,abnormal[i][j]);
                }
            }
        }
        bw.write(String.valueOf(count));

        bw.flush();

    }
}