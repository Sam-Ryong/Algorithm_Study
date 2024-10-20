import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static int[][] map;

    static ArrayList<Integer> danji = new ArrayList<>();

    public static void detect(int i, int j){

        ArrayList<Integer[]> next = new ArrayList<>();
        ArrayList<Integer[]> temp = new ArrayList<>();
        next.add(new Integer[]{i-1,j});
        next.add(new Integer[]{i+1,j});
        next.add(new Integer[]{i,j-1});
        next.add(new Integer[]{i,j+1});
        map[i][j] = 0;
        int count = 1;
        while(next.size() > 0){
            for (Integer[] apartment : next) {
                i = apartment[0];
                j = apartment[1];
                if (!(i > N - 1 || j > N - 1 || i < 0 || j < 0)){
                    if (map[i][j] == 1){
                        map[i][j] = 0;
                        count++;
                        temp.add(new Integer[]{i-1,j});
                        temp.add(new Integer[]{i+1,j});
                        temp.add(new Integer[]{i,j-1});
                        temp.add(new Integer[]{i,j+1});
                    }
                }
            }
            next.clear();
            next.addAll(temp);
            temp.clear();
        }

        danji.add(count);

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);

        map = new int[N][N];

        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++){
            s = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1)
                    detect(i,j);
            }
        }

        System.out.println(danji.size());
        Collections.sort(danji);
        for (Integer i : danji) {
            System.out.println(i);
        }


    }
}