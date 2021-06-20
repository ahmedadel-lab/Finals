import java.util.*;

public class Q2_16 {
    private int x;
    public static int function(int x){
        int function = 2 * (x * x) - 5 * x + 30;
        return function;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the range (two integer values):");
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int minX = x1;
        for(int i = x1; i <= x2; i++){
            if(function(i) < min){
                min = function(i);
                minX = i;
            }
        }
        System.out.println("Within the range you selected, f(x) is minimal when x = " + minX + " and f(x) = " + min);
    }
}
