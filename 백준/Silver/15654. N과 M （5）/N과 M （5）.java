import org.w3c.dom.Node;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

//허프만 코딩이랑 아리스메틱 코딩 중 하나는 무조건냄
//그림그려서 설명하게냄

public class Main {

    static int N, M;

    static int[] numbers;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void permutation(int num, int length, String str, int visit) throws IOException {
        if (num > N)
            return;
        if ((visit & (int) Math.pow(2,num))==(int) Math.pow(2,num))
            return;
        if (length == 0){
            str = str + String.valueOf(numbers[num]);
            bw.write(str+"\n");
            return;
        }

        visit = visit | (int) Math.pow(2,num);
        str = str + String.valueOf(numbers[num]) + " ";
        for (int i = 1; i < N+1; i++) {
            permutation(i,length-1,str, visit);
        }
    }

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        numbers = new int[N + 1];

        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i+1] = Integer.parseInt(s[i]);
        }

        Arrays.sort(numbers);

        for (int i = 1; i < N+1; i++) {
            permutation(i,M-1,"",0);
        }

        bw.flush();


    }
}