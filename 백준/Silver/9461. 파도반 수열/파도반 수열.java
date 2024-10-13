import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int T = sc.nextInt();

    static long[] Pn = new long[101];

    public static void main(String[] args) {

        StringBuilder output = new StringBuilder();

        Pn[0] = 0;
        Pn[1] = 1;
        Pn[2] = 1;
        Pn[3] = 1;
        Pn[4] = 2;
        Pn[5] = 2;
        Pn[6] = 3;
        Pn[7] = 4;
        Pn[8] = 5;
        Pn[9] = 7;
        Pn[10] = 9;

        for (int i = 11; i < 101; i++){
            Pn[i] = Pn[i-1] + Pn[i-5];
        }

        for (int i = 0; i < T; i++){
            output.append(Pn[sc.nextInt()]);
            output.append("\n");
        }

        System.out.print(output);


    }




}