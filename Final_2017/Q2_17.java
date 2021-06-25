import java.util.Scanner;

public class Q2_17 {
    public static int print_mults(int first, int second){
        int res = 0;
        for(int i = first; i <= second; i++){
            if(i%3 == 0 || i%5 == 0)
                res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("First integer: ");
        int first = in.nextInt();
        System.out.print("Second integer: ");
        int second = in.nextInt();

        System.out.println(print_mults(first, second));
    }
}
