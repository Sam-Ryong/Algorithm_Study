import java.io.*;
import java.util.ArrayList;

public class Main {

    static int N, M;


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static String explode(String bomb, StringBuffer string){
        int len = bomb.length();
        StringBuffer result  = new StringBuffer();


            for (int i = 0; i < string.length(); i++) {
                result.append(string.substring(i,i+1));
                if (result.length() >= len && result.substring(result.length() - len, result.length()).equals(bomb)) {
                    result.delete(result.length() - len, result.length());
                }
            }


        return result.length() == 0 ? "FRULA" : result.toString();

    }

    public static void main(String[] args) throws IOException {
        StringBuffer s = new StringBuffer(br.readLine());
        String boom = br.readLine();

        bw.write(explode(boom,s));
        bw.flush();

    }
}