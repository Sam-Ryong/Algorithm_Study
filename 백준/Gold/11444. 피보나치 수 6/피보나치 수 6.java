import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    /*
    F(n) = F(n-1) + F(n-2)
    = F(n-2) + F(n-2) + F(n-3)
    = 2F(n-2) + F(n-3) = F(3)*F(n-2) + F(2)*F(n-3)
    = 2(F(n-3) + F(n-4)) + F(n-3)
    = 3F(n-3) + 2F(n-4) = F(4)*F(n-3) + F(3)*F(n-4)
    = 3(F(n-4) + F(n-5)) + 2F(n-4)
    = 5F(n-4) + 3F(n-5) = F(5)*F(n-4) + F(4)*F(n-5)
    = F(6)*F(n-5) + F(5)*F(n-6)

    F(n) = F(m+1)*F(n-m) + F(m)*F(n-m-1)
    F(n-1) = F(m+1)*F(n-1-m) + F(m)*F(n-m-2)


    홀수일때
    F(2n+1) = F(n+1)*F(n+1) + F(n)F(n)
    짝수일때
    F(2n) = F(n)F(n+1) + F(n-1)F(n)
     */

    static long n;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static long[] divide(long n){
        long[] Fib = new long[4];
        Fib[0] = 0;
        Fib[1] = 1;
        Fib[2] = 1;
        Fib[3] = 2;
        if (n > 0 && n <= 3)
            return new long[] {Fib[(int)n-1],Fib[(int)n], Fib[(int)n-1]+Fib[(int)n]};
        long a = 2;
        while (true) {
            a = a * 2;
            if (a > n)
                break;
            long even = ((Fib[2] % 1000000007) * ((Fib[1] + Fib[3]) % 1000000007)) % 1000000007;
            long odd = (((Fib[3] * Fib[3]) % 1000000007) + ((Fib[2] * Fib[2]) % 1000000007)) % 1000000007;
            Fib[2] = even;
            Fib[3] = odd;
            Fib[1] = (Fib[3] - Fib[2] + 1000000007) % 1000000007;
            Fib[0] = (Fib[2] - Fib[1] + 1000000007) % 1000000007;
        }
        a = a / 2;
        if (a == n)
            return new long[] {Fib[1],Fib[2], Fib[3]};
        long[] next = divide(n - a);
        long[] result = new long[]{
                (((Fib[2] * next[1]) % 1000000007) + ((Fib[1] * next[0]) % 1000000007)) % 1000000007,
                (((Fib[2] * next[2]) % 1000000007) + ((Fib[1] * next[1]) % 1000000007)) % 1000000007,
                0};
        result[2] = (result[1] + result[0]) % 1000000007;
        return result;
    }

    public static void main(String[] args) throws IOException {

        String s = br.readLine();
        n = Long.parseLong(s);

        System.out.println(divide(n)[1]);

    }
}