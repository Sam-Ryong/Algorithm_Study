import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();

    static int[][] paper = new int[N][N];

    static int white = 0;
    static int blue = 0;

    static boolean checkWhite(int x, int y, int length){
        boolean result = true;
        for (int i = y; i < y+length; i++){
            for (int j = x; j < x+length; j++){
                if (paper[i][j] != 0){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
    static boolean checkBlue(int x, int y, int length){
        boolean result = true;
        for (int i = y; i < y+length; i++){
            for (int j = x; j < x+length; j++){
                if (paper[i][j] != 1){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
    static void cut(int x, int y, int length){
        if (checkBlue(x,y,length)){
            blue = blue + 1;
            return;
        }
        if (checkWhite(x,y,length)){
            white = white + 1;
            return;
        }

        cut(x,y,length/2);
        cut(x + length/2,y,length/2);
        cut(x,y+length/2,length/2);
        cut(x+length/2,y+length/2,length/2);

    }

    public static void main(String[] args) {

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                paper[i][j] = sc.nextInt();
            }
        }

        cut(0,0,N);

        System.out.println(white);
        System.out.println(blue);

    }
}