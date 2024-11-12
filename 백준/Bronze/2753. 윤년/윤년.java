import java.io.*;

public class Main {

    static int N;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


  
    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        int result = 0;
        
        if (N % 4 == 0){
            if((N % 100 != 0) || (N % 400 == 0))
                result = 1;
        }
        bw.write(result+"\n");
        bw.flush();

    }

}