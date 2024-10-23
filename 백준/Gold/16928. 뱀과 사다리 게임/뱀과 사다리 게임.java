import java.io.*;
import java.util.*;

//허프만 코딩이랑 아리스메틱 코딩 중 하나는 무조건냄
//그림그려서 설명하게냄

public class Main {

    static int N;

    static int M;

    static int[] board = new int[101];

    static int dice(){

        ArrayList<Integer> next = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        next.add(1);
        int result = -1;
        boolean isEnd = false;
        while (true){
            result = result + 1;
            for (Integer i : next) {
                if (i == 100)
                {
                    isEnd = true;
                    break;
                }
                if (board[i] == 0){
                    board[i] = -1;
                    if (i <= 99)
                        temp.add(i+1);
                    if (i <= 98)
                        temp.add(i+2);
                    if (i <= 97)
                        temp.add(i+3);
                    if (i <= 96)
                        temp.add(i+4);
                    if (i <= 95)
                        temp.add(i+5);
                    if (i <= 94)
                        temp.add(i+6);
                }
                if (board[i] > 0){

                    if (board[i] <= 99)
                        temp.add(board[i]+1);
                    if (board[i] <= 98)
                        temp.add(board[i]+2);
                    if (board[i] <= 97)
                        temp.add(board[i]+3);
                    if (board[i] <= 96)
                        temp.add(board[i]+4);
                    if (board[i] <= 95)
                        temp.add(board[i]+5);
                    if (board[i] <= 94)
                        temp.add(board[i]+6);

                    board[board[i]] = -1;
                    board[i] = -1;

                }


            }
            next.clear();
            next.addAll(temp);
            temp.clear();

            if (isEnd)
                break;

        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        for (int i = 0; i < N; i++) {
            String[] s1 = br.readLine().split(" ");
            board[Integer.parseInt(s1[0])] = Integer.parseInt(s1[1]);
        }

        for (int i = 0; i < M; i++) {
            String[] s2 = br.readLine().split(" ");
            board[Integer.parseInt(s2[0])] = Integer.parseInt(s2[1]);
        }

        bw.write(String.valueOf(dice()));

        bw.flush();

    }
}