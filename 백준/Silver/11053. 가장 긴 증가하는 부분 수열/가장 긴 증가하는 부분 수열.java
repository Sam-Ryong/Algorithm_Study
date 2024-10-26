    import org.w3c.dom.Node;

    import java.io.*;
    import java.util.*;
    import java.util.stream.IntStream;

    //허프만 코딩이랑 아리스메틱 코딩 중 하나는 무조건냄
    //그림그려서 설명하게냄

    public class Main {

        static int N, max;

        static int[] numbers;

        static int[] DP;

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        public static void main(String[] args) throws IOException {

            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);

            numbers = new int[N];
            DP = new int[N];

            max = 0;

            s = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(s[i]);
            }
            DP[0] = 1;
            int result = 1;
            for (int i = 1; i < N; i++){
                int max = 1;
                for (int j = 0; j < i; j++) {
                    if (numbers[i] > numbers[j]){
                        if (DP[j] + 1 > max)
                            max = DP[j] + 1;
                    }

                }
                if (max > result)
                    result = max;
                DP[i] = max;
            }
            bw.write(String.valueOf(result));
            bw.flush();
        }
    }