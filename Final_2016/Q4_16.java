abstract class A{
    public void f1(){
        System.out.println("A.f1  called");
    }
    public final void f2(){
        System.out.println("A.f2 called");
    }
    public abstract void f3();
}

abstract class B extends A{
    public void f3(){
        System.out.println("B.f3 called");
    }
}

class C extends B{
    public void f1(){
        System.out.println("C.f1 called");
    }
}

class D extends C{
    public void f1(){
        super.f1();
        System.out.println("D.f1 called");
    }
    public void f3(){
        super.f3();
        System.out.println("F.f3 called\n");
    }
}



public class Q4_16 {
    public static void main(String[] args){
        A[] ps = new A[2];
        ps[0] = new C();
        ps[1] = new D();
        for(int i = 0; i < ps.length; i++){
            ps[i].f1();
            ps[i].f2();
            ps[i].f3();
        }
    }
}

/* Prints the following:
    C.f1 called
    A.f2 called
    B.f3 called
    C.f1 called
    D.f1 called
    A.f2 called
    B.f3 called
    F.f3 called
 */