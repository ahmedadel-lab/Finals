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

    public double[] getCoefficients() {
        return c;
    }

    public Polynomial add(Polynomial po){
        double[] higherDegree;
        double[] lowerDegree;
        if(po.getDegree() > getDegree()){
            higherDegree = po.getCoefficients();
            lowerDegree = c;
        }
        else{
            higherDegree = c;
            lowerDegree = po.getCoefficients();
        }

        double[] coff = new double[higherDegree.length];
        for(int i = 0; i < lowerDegree.length; i++){
            coff[i] = higherDegree[i] + lowerDegree[i];
        }
        for (int i = lowerDegree.length; i < higherDegree.length; i++) {
            coff[i] = higherDegree[i];
        }
        return new Polynomial(coff);
    }

    public Polynomial differentiate(){
        double[] coff = new double[c.length-1];
        for (int i = 1; i < c.length; i++) {
            coff[i-1] = c[i] * i;
        }
        return new Polynomial(coff);
    }
}

public class Q3_16{
    public static void main(String[] args) {
        Polynomial po1 = new Polynomial(new double[]{5, 3, 6, 8, 9});
        po1.print();
        Polynomial po2 = new Polynomial(new double[]{9, 8, 7, 6, 4});
        po2.print();
        Polynomial dpo1 = po1.differentiate();
        dpo1.print();
        Polynomial po3 = po2.add(dpo1);
        po3.print();
    }
}