public class Q2_2019 {

}
class IntRange {
    private int A;
    private int B;

    public IntRange(int A, int B){
        try {
            if(A > B) throw new InvalidRangeException("A is greater than B");
        }
        catch(InvalidRangeException e){
            e.printStackTrace();
            A = 0;
            B = 0;
        }
        this.A = A;
        this.B = B;
    }
}

class InvalidRangeException extends Exception {
    public InvalidRangeException(String msg){
        super(msg);
    }
}
/*
point B in the question:
InvalidRangeException should be defined as unchecked exception as it's not who made IntRange class work to handle this exception.
 */