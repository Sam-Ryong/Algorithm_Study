import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static int N = sc.nextInt();
    static int M = sc.nextInt();

    static int[][] map = new int[N][M];

    static int[][] answer = new int[N][M];

    static int[] start = new int[2];
    static ArrayList<Integer[]> points = new ArrayList<Integer[]>();
    static ArrayList<Integer[]> temp = new ArrayList<Integer[]>();
    public static void move(int distance){

        if (points.size() == 0)
            return;

        for (int i = 0; i < points.size(); i++){

            if (map[points.get(i)[0]][points.get(i)[1]] > 0 && answer[points.get(i)[0]][points.get(i)[1]] < 0) {

                answer[points.get(i)[0]][points.get(i)[1]] = distance;

                if (points.get(i)[0] != 0)
                    temp.add(new Integer[]{points.get(i)[0] - 1, points.get(i)[1]});
                if (points.get(i)[0] != N - 1)
                    temp.add(new Integer[]{points.get(i)[0] + 1, points.get(i)[1]});
                if (points.get(i)[1] != 0)
                    temp.add(new Integer[]{points.get(i)[0], points.get(i)[1] - 1});
                if (points.get(i)[1] != M - 1)
                    temp.add(new Integer[]{points.get(i)[0], points.get(i)[1] + 1});
            }

            if (map[points.get(i)[0]][points.get(i)[1]] == 0)
                answer[points.get(i)[0]][points.get(i)[1]] = 0;

        }

        points.clear();
        points.addAll(temp);
        temp.clear();
        move(distance + 1);

    }

    public static void main(String[] args) {

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                int temp = sc.nextInt();
                if (temp == 2){
                    start[0] = i;
                    start[1] = j;
                }
                if (temp == 0){
                    answer[i][j] = 0;
                }
                else{
                    answer[i][j] = -1;
                }
                map[i][j] = temp;
            }
        }
        points.add(new Integer[]{start[0],start[1]});
        move(0);

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                output.append(answer[i][j]);
                if (j < M - 1){
                    output.append(" ");
                }
            }
            output.append("\n");
        }

        System.out.print(output);

    }
}