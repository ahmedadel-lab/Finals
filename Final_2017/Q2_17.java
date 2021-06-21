import java.util.Scanner;

public class Q2_17 {
    public static int Sum(int r1, int r2){
        int sum = 0;
        for(int i = (int)Math.ceil(r1/3); i <= (int)Math.floor(r2/3); i++){
            sum += i * 3;
            if(i * 3 % 5 == 0) sum -= i * 3;
        }
        for(int i = (int)Math.ceil(r1/5); i <= (int)Math.floor(r2/5); i++){
            sum += i * 5;
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the Range of numbers (two integer values):");
        int x1 = 0, x2 = 0;
        while(true){
            try{
                x1 = sc.nextInt();
                x2 = sc.nextInt();
                break;
            }
            catch(Exception e){
                sc.next();
                System.out.println("Please Enter Valid Values.");
            }
        }
        System.out.println("The Sum of values within the range you entered is: " + Sum(x1, x2));
    }
}
