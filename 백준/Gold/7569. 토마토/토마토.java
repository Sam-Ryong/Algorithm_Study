import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static int N = sc.nextInt();
    static int M = sc.nextInt();
    static int H = sc.nextInt();

    static int[][][] box = new int[H][M][N];

    static ArrayList<Integer[]> next = new ArrayList<Integer[]>();
    static ArrayList<Integer[]> temp = new ArrayList<Integer[]>();

    static int wellDone = 0;
    static int rear = 0;

    public static void spread(){
        for (int i = 0; i < next.size(); i++){
            int z = next.get(i)[0];
            int y = next.get(i)[1];
            int x = next.get(i)[2];
            if (x > 0 && box[z][y][x-1] == 0){
                wellDone++;
                rear--;
                box[z][y][x-1] = 1;
                temp.add(new Integer[]{z,y,x-1});
            }
            if (x < N-1 && box[z][y][x+1] == 0){
                wellDone++;
                rear--;
                box[z][y][x+1] = 1;
                temp.add(new Integer[]{z,y,x+1});
            }
            if (y > 0 && box[z][y-1][x] == 0){
                wellDone++;
                rear--;
                box[z][y-1][x] = 1;
                temp.add(new Integer[]{z,y-1,x});
            }
            if (y < M-1 && box[z][y+1][x] == 0){
                wellDone++;
                rear--;
                box[z][y+1][x] = 1;
                temp.add(new Integer[]{z,y+1,x});
            }
            if (z > 0 && box[z-1][y][x] == 0){
                wellDone++;
                rear--;
                box[z-1][y][x] = 1;
                temp.add(new Integer[]{z-1,y,x});
            }
            if (z < H-1 && box[z+1][y][x] == 0){
                wellDone++;
                rear--;
                box[z+1][y][x] = 1;
                temp.add(new Integer[]{z+1,y,x});
            }

        }
        next.clear();
        next.addAll(temp);
        temp.clear();
    }

    public static void main(String[] args) {



        for (int k = 0; k < H; k++){
            for (int j = 0; j < M; j++) {
                for (int i = 0; i < N; i++) {
                    box[k][j][i] = sc.nextInt();
                    if (box[k][j][i] == 1){
                        next.add(new Integer[]{k,j,i});
                        wellDone++;
                    }
                    if (box[k][j][i] == 0)
                        rear++;
                }
            }
        }

        int time = 0;
        while(next.size() > 0 && rear > 0){
            spread();
            time++;
        }

        if (rear > 0){
            time = -1;
        }

        System.out.println(time);

    }

}