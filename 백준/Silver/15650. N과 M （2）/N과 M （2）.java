import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

//허프만 코딩이랑 아리스메틱 코딩 중 하나는 무조건냄
//그림그려서 설명하게냄

public class Main {

    static int N, M;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void permutation(int num, int length, String str) throws IOException {
        if (num > N)
            return;
        if (length == 0){
            str = str + String.valueOf(num);
            bw.write(str+"\n");
            return;
        }
        str = str + String.valueOf(num) + " ";
        for (int i = num + 1; i < N+1; i++) {
            permutation(i,length-1,str);
        }
    }

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        for (int i = 1; i < N+1; i++) {
            permutation(i,M-1,"");
        }

        bw.flush();


    }
}