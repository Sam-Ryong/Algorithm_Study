import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int temp;
    public static void solution(int now, int max){
        if (now > max){
            return;
        }
        else if (now == max){
            temp = temp + 1;
            return;
        }
        else{
            solution(now + 1, max);
            solution(now + 2, max);
            solution(now + 3, max);
        }

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int[] numbers = new int[T];
        for (int i = 0; i < T; i++){
            int n = input.nextInt();
            numbers[i] = n;
        }

        for (int i = 0; i < T; i++){
            temp = 0;
            solution(0,numbers[i]);
            System.out.println(temp);
        }
    }
}