package Q3;

public class Polynomial {
    private double[] coff;

    public Polynomial(double[] coff){
        this.coff = coff;
    }

    @Override
    public String toString(){
        String s = "Coff are :";
        for (int i=0 ; i < coff.length ; i++)
        {
            s = s +  Double.toString(coff[i]) + "     ";
        }
        return s;
    }
    public int getDegree(){
        return coff.length-1;
    }

    public void print(){
        String s = Double.toString(coff[1]) + "x+" + Double.toString(coff[0]);
        for(int i=2 ; i < coff.length ; i++){
            s = Double.toString(coff[i]) + "x^" + i + "+"+ s;
        }

        System.out.println(s);
    }


    public double evaluate(double x){
        double d = 0;
        for(int i=0 ; i < coff.length ; i++){
            d+=coff[i]*Math.pow(x,i);
        }
      return d;
    }

    public Polynomial add(Polynomial po) {
        double[] arr = new double[Math.max(this.coff.length,po.coff.length)];
        Polynomial new1 = new Polynomial(arr);
        for (int i = 0; i < Math.min(this.coff.length, po.coff.length); i++) {
            new1.coff[i] = this.coff[i] + po.coff[i];
        }
        for (int i = Math.min(this.coff.length, po.coff.length); i < Math.max(this.coff.length, po.coff.length); i++) {

                if (this.coff.length > po.coff.length) {
                    for (int j = po.coff.length; j < this.coff.length; j++) {
                        new1.coff[j] = this.coff[j];
                    }
                }
                else if (this.coff.length < po.coff.length) {
                    for (int j = this.coff.length; j < po.coff.length; j++) {
                        new1.coff[j] = po.coff[j];
                    }

                }
            }
        return new1;
        }



    public Polynomial differentiate(){
        double[] arr = new double[this.coff.length];
        Polynomial new1 = new Polynomial(arr);
        new1.coff[0] = 0;
        for (int i=1 ; i < this.coff.length ; i++){
            new1.coff[i] = i *this.coff[i];
        }
        return new1;
    }


    public static void main(String[] args){


        double[] coff = {30,-5,2};
        double[] coff2 = {30,0,2,6};
        Polynomial p = new Polynomial(coff);

        p.print();
        System.out.println();
        System.out.println(p.evaluate(0));
        Polynomial p1 = new Polynomial(coff2);
        Polynomial p2 = p.add(p1);
        p2.print();
        p.differentiate().print();
    }
}
