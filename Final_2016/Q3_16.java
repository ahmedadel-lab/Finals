class Polynomial {
    private double[] c;
    public Polynomial(double[] array){
        c = array;
    }

    @Override
    public String toString(){
        String s = "List of Coefficients of f(x) is: ";
        for(int i = c.length - 1; i > 0; i--){
            s += String.valueOf(c[i]) + ", ";
        }
        s += String.valueOf(c[0]) + "\n";
        return s;
    }

    public int getDegree() {
        int i = c.length - 1;
        while(c[i] == 0){
            i--;
        }
        return i;
    }

    public void print(){
        System.out.print("f(x) = ");
        int pCounter = 0;
        for(int i = c.length - 1; i > 0; i--){
            if(c[i] != 0){
                pCounter++;
                System.out.print(Math.abs(c[i]) + "x^(" + i + ") ");
            }
            if(pCounter > 0){
                if(c[i - 1] > 0) System.out.print("+ ");
                else if (c[i - 1] < 0) System.out.print("- ");
            }
        }
        if(c[0] != 0)System.out.print(Math.abs(c[0]));
        System.out.println();
    }

    public double Evaluate(int x){
        double res = 0;
        for(int i = 0; i < c.length; i++){
            res += c[i] * Math.pow(x, i);
        }
        return res;
    }
}

public class Q3_16{
    public static void main(String[] args){
        double[] cc = {-3, 0, 2, 3}; // f(x) = 2X^(2) + 3
        Polynomial function = new Polynomial(cc);
        //System.out.println(function.Evaluate(-2)); // Test Evaluate Method on x = -2
        //function.print(); // Test print method on signs and their placements
        System.out.println(function.toString());
    }
}