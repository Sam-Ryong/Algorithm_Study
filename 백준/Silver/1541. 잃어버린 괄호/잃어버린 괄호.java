import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static String input = sc.next();
    static ArrayList<Integer> numbers = new ArrayList<>();
    static ArrayList<Integer> sums = new ArrayList<>();
    static ArrayList<Character> operators = new ArrayList<>();

    public static void main(String[] args) {

        int counter = -1;
        for (int i = 0; i < input.length(); i++){
            if (!(Character.isDigit(input.charAt(i)))){
                numbers.add(Integer.parseInt(input.substring(counter+1,i)));
                counter = i;
                operators.add(input.charAt(i));
            }
            else if (i == input.length() - 1){
                numbers.add(Integer.parseInt(input.substring(counter+1)));
            }
        }

        int before = -1;
        for (int i = 0; i < operators.size(); i++){
            if (operators.get(i) == '-'){
                if (before < 0){
                    before = i;
                    int sum = numbers.get(0);
                    for (int j = 1; j < before+1; j++){
                        sum = sum + numbers.get(j);
                    }
                    sums.add(sum);
                }
                else{
                    int sum = 0;
                    for (int j = before+1; j < i+1; j++){
                        sum = sum + numbers.get(j);
                    }
                    sums.add(sum);
                    before = i;
                }
            }
        }

        int sum = 0;
        for (int j = before+1; j < operators.size()+1; j++){
            sum = sum + numbers.get(j);
        }
        sums.add(sum);
        

        int result = sums.get(0);
        for (int i = 1; i < sums.size() ; i++){
            result = result - sums.get(i);
        }

        System.out.println(result);

    }

}