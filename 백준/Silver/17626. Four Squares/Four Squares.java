import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static int N = sc.nextInt();

    static int[] numbers = new int[N+1];

    static int answer = 4;
    static void find(int num,int depth){
        if (depth >= answer)
            return;
        if (numbers[num] == 1){
            answer = depth;
            return;
        }
        for (int i = 1; i <= (int) Math.floor(Math.sqrt(num)); i++){
            find(num - i * i, depth + 1);
        }

    }

    public static void main(String[] args) {

        for (int i = 1; i <= Math.sqrt(N); i++) {
            numbers[i*i] = 1;
        }
        find(N,1);
        System.out.println(answer);
    }

}