class Color{
    private String color;
    public Color(){
        color = null;
    }
    public Color(String color){
        this.color = color;
    }
    public String getColor() {
        return color;
    }
}

class Bag{
    private float width;
    private float height;
    private float depth;
    private Color color;
    private boolean wheels;

    // Constructor that takes all data sets all data members
    public Bag(float width, float height, float depth, Color color, boolean wheels){
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.color = color;
        this.wheels = wheels;
    }

    //Accessors for all data members
    public float getWidth(){
        return width;
    }
    public float getHeight(){
        return height;
    }
    public float getDepth(){
        return depth;
    }
    public Color getColor(){
        return color;
    }
    public boolean getWheels(){
        return wheels;
    }

    @Override
    public String toString() {
        String s = "This Bag is with the following properties: \nWidth = " + String.valueOf(this.width) + "\nHeight = " + String.valueOf(this.height) +
                "\nDepth = " + String.valueOf(this.depth) + "\nColor is " + String.valueOf(this.color) + "\nWith Wheels? " + String.valueOf(this.wheels);
        return s;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Bag)) return false;
        else if(width != ((Bag)o).width || height != ((Bag)o).height || depth != ((Bag)o).depth) return false;
        else if(!color.equals(((Bag)o).color)) return false;
        else if(wheels != ((Bag)o).wheels) return false;
        else return true;
    }

    public float getVolume(){
        return this.width * this.height * this.depth;
    }

    public boolean isLarger(Bag b){
        float v1 = this.width * this.height * this.depth;
        float v2 = b.height * b.width * b.depth;
        return (v1 > v2);
    }

    public boolean canEnclose(Bag b){
        if(b.width < this.width && b.height < this.height && b.depth < this.depth) return true;
        else if(b.width < this.height && b.height < this.width && b.depth < this.depth) return true;
        else if(b.width < this.depth && b.height < this.height && b.depth < this.width) return true;
        else if(b.width < this.width && b.height < this.depth && b.depth < this.height) return true;
        else return false;
    }

    public static int findSmallestBag(Bag[] b, Color colored, boolean wheeled){
        double smallest = Integer.MAX_VALUE;
        int index = 0;
        if(colored == null){
            for(int i = 0; i < b.length; i++){
                if(b[i].wheels == wheeled && b[i].getVolume() < smallest){
                    smallest = b[i].getVolume();
                    index = i;
                }
            }
        }
        else{
            for(int i = 0; i < b.length; i++){
                if(b[i].wheels == wheeled && b[i].color == colored && b[i].getVolume() < smallest){
                    smallest = b[i].getVolume();
                    index = i;
                }
            }
        }
        return index;
    }

}


public class Q3_17 {

}
