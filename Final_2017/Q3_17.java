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

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(! (o instanceof Color))
            return false;
        return ((Color) o).color.equalsIgnoreCase(this.getColor());
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
        if(b.width < width && b.height < height && b.depth < depth) return true;
        if(b.width < width && b.height < depth && b.depth < height) return true;
        if(b.width < height && b.height < width && b.depth < depth) return true;
        if(b.width < height && b.height < depth && b.depth < height) return true;
        if(b.width < depth && b.height < height && b.depth < width) return true;
        if(b.width < depth && b.height < width && b.depth < height) return true;
        return false;
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
                if(b[i].wheels == wheeled && b[i].color.equals(colored)  && b[i].getVolume() < smallest){
                    smallest = b[i].getVolume();
                    index = i;
                }
            }
        }
        return index;
    }

}


public class Q3_17 {
    public static void main(String[] args) {
        Bag[] bags = new Bag[]{
                new Bag(45, 65, 1000, new Color("Red"), true),
                new Bag(66, 84, 21, new Color("Green"), true),
                new Bag(45, 15, 69, new Color("Blue"), true),
                new Bag(69, 69, 80, new Color("Pink"), false),
                new Bag(45, 22, 46, new Color("Red"), true),
                new Bag(45, 59, 46, new Color("Green"), true)
        };

        System.out.println(bags[0].canEnclose(bags[1]));
        System.out.println(bags[0].equals(bags[1]));
        System.out.println(bags[0].getVolume());
        System.out.println(bags[0].isLarger(bags[1]));
        System.out.println(Bag.findSmallestBag(bags, new Color("red"), true));
    }
}

