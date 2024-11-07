import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {


    static int[][] sudoku;
    static int[][] answer = new int[9][9];


    static ArrayList<Integer[]> zeros = new ArrayList<>();

    static boolean found = false;

    static int count = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



    public static void dfs(int num, int val,int[][] prev, boolean[][][] section, boolean[][] heng, boolean[][] yul){
        if (found){
            return;
        }
        count++;
        int r = zeros.get(num)[0];
        int c = zeros.get(num)[1];

        if (section[r/3][c/3][val-1] || heng[r][val-1] || yul[c][val-1]) {
            return;
        }

       /* int[][] now = new int[9][9];
        boolean[][][] newSection = new boolean[3][3][9];
        boolean[][] newHeng = new boolean[9][9];
        boolean[][] newYul = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            now[i] = prev[i].clone();
            newHeng[i] = heng[i].clone();
            newYul[i] = yul[i].clone();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newSection[i][j] = section[i][j].clone();
            }
        }*/
        int[][] now = prev;
        boolean[][][] newSection = section;
        boolean[][] newHeng = heng;
        boolean[][] newYul = yul;

        now[r][c] = val;
        newSection[r/3][c/3][val-1] = true;
        newHeng[r][val-1] = true;
        newYul[c][val-1] = true;

        if (num == zeros.size() - 1){
            if (!found) {
                found = true;
            }
            for (int i = 0; i < 9; i++) {
                answer[i] = now[i].clone();
            }
        }

        for (int i = 1; i < 10; i++) {
            if(!found)
                dfs(num + 1, i, now, newSection, newHeng, newYul);
            else
                break;
        }
        now[r][c] = 0;
        newSection[r/3][c/3][val-1] = false;
        newHeng[r][val-1] = false;
        newYul[c][val-1] = false;

    }


    public static void main(String[] args) throws IOException {
        String[] s;
        boolean[][][] section = new boolean[3][3][9];
        boolean[][] heng = new boolean[9][9];
        boolean[][] yul = new boolean[9][9];

        sudoku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(s[j]);
                if (sudoku[i][j] > 0) {
                    section[i / 3][j / 3][sudoku[i][j] - 1] = true;
                    heng[i][sudoku[i][j] - 1] = true;
                    yul[j][sudoku[i][j] - 1] = true;
                }
                else {
                    zeros.add(new Integer[]{i,j});
                }
            }
        }

        for (int k = 1; k < 10; k++) {
            dfs(0,k,sudoku,section,heng,yul);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(String.valueOf(answer[i][j]));
            }
            bw.write("\n");
        }
        bw.flush();
        
    }
}