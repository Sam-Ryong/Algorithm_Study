import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.ArrayList;

public class Main {

    static int N, M;

    static int[] A,B;
    static StringBuilder st = new StringBuilder();
    static int count = 0;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void findCommonMax(int startA, int startB){
        int Ai = -1;
        int Bi = -1;
        int max = 0;
        for (int i = startA; i < N; i++) {
            for (int j = startB; j < M; j++) {
                if ((A[i] == B[j]) && (A[i] > max)){
                    max = A[i];
                    Ai = i;
                    Bi = j;
                }
            }
        }

        if (Ai == -1 || Bi == -1) {
            return;
        }
        count++;
        st.append(max + " ");
        findCommonMax(Ai+1,Bi+1);
    }

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        A = new int[N];
        s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(s[i]);
        }


        s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        B = new int[M];
        s = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(s[i]);
        }

        findCommonMax(0,0);

        System.out.println(count);
        System.out.println(st);



    }
}