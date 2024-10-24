import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

//허프만 코딩이랑 아리스메틱 코딩 중 하나는 무조건냄
//그림그려서 설명하게냄

public class Main {

    static int N, M;
    static int[][] paper;

    static StringBuilder stringBuilder = new StringBuilder();

    static int max = 0;

    static void case1(int i, int j, int count, int sum, int prevI, int prevJ){
        if (i < 0 || j < 0 || i > N - 1 || j > M - 1)
            return;
        if (count == 4){
            sum = sum + paper[i][j];
            if (sum > max)
                max = sum;
            return;
        }
        sum = sum + paper[i][j];
        if (prevI != i-1 || prevJ != j)
            case1(i-1,j,count+1,sum,i,j);
        if (prevI != i+1 || prevJ != j)
            case1(i+1,j,count+1,sum,i,j);
        if (prevI != i || prevJ != j-1)
            case1(i,j-1,count+1,sum,i,j);
        if (prevI != i || prevJ != j+1)
            case1(i,j+1,count+1,sum,i,j);
    }

    static int get(int i, int j){
        if (i < 0 || j < 0 || i > N - 1 || j > M - 1)
            return -1;
        else
            return paper[i][j];
    }

    static void case2(int i, int j){
        int up = get(i,j-1);
        int down = get(i,j+1);
        int left = get(i-1,j);
        int right = get(i+1,j);

        if (up > 0 && down > 0 && left > 0){
            int sum = paper[i][j] + up + down + left;
            if (max < sum)
                max = sum;
        }
        if (up > 0 && down > 0 && right > 0){
            int sum = paper[i][j] + up + down + right;
            if (max < sum)
                max = sum;
        }
        if (right > 0 && down > 0 && left > 0){
            int sum = paper[i][j] + right + down + left;
            if (max < sum)
                max = sum;
        }
        if (up > 0 && right > 0 && left > 0){
            int sum = paper[i][j] + up + right + left;
            if (max < sum)
                max = sum;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        paper = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(s1[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                case1(i,j,1,0,-1,-1);
                case2(i,j);
            }
        }

        System.out.println(max);

    }
}