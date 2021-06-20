class Polynomial {
    private double[] c;
    public Polynomial(double[] array){
        c = array;
    }

    @Override
    public String toString(){
        String s = null;
        for(int i = c.length - 1; i >= 0; i--){
            s += String.valueOf(c[i]) + ", ";
        }
        s += "\n";
        return s;
    }

    public double getDegree(){
        double hDegree = 0;
        for(int i = c.length - 1; i >= 0; i--){
            if(c[i] != 0) hDegree = c[i];
        }
        return hDegree;
    }

    public void print(){

    }
}

public class Q3_16{
    public static void main(String[] args){
        ///
    }
}