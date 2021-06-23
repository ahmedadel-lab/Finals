
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args)

    {


        Scanner input = new Scanner(System.in);
        System.out.println("Enter two numbers\n");

        int a = input.nextInt();
        int b = input.nextInt();
        Integer max = Integer.MAX_VALUE;
        int num;
        int ind;
        for (int i = a; i <= b; i++) {
              num = 2*(i)*(i)-5*(i)+30;
              if (num < max){
                  max = num;
                  ind = i;
              }
        }
        System.out.println("f("+  ")="+max );
    }
}
