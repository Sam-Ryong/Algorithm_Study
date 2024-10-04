import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int temp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, M;
        N = scanner.nextInt();
        M = scanner.nextInt();
        int[] numbers = new int[N];
        int[] sums = new int[N+1];
        int[][] courses = new int[M][2];

        sums[0] = 0;
        for (int i = 0; i < N; i++){
            numbers[i] = scanner.nextInt();
            sums[i+1] = sums[i] + numbers[i];
        }

        for (int i = 0; i < M; i++){
            int[] course = new int[2];
            course[0] = scanner.nextInt();
            course[1] = scanner.nextInt();
            courses[i] = course;
        }

        for (int[] course : courses) {
            int start = course[0];
            int end = course[1];

            System.out.println(sums[end]-sums[start-1]);

        }
    }
}