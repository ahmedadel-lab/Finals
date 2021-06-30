import java.util.ArrayList;

public class Q3_2019 {
}

abstract class ItemForSale{
    private String itemName;
    private int price;

    public ItemForSale(String itemName, int price){
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ItemForSale{" +
                "itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof ItemForSale)) return false;
        ItemForSale i = (ItemForSale) o;
        if(i.price == this.price && i.itemName.equals(this.itemName)) return true;
        return false;
    }

    public void offerDiscount(int percent){
        price -= price * percent/100.0;
    }

    public abstract Boolean isGoodDeal();
}

class Apartment extends ItemForSale{
    private double area;
    private int averageSquareMeter;

    public double getArea() {
        return area;
    }
    public int getAverageSquareMeter() { return averageSquareMeter; }

    public Apartment(String itemName, int price, double area, int averageSquareMeter){
        super(itemName, price);
        this.area = area;
        this.averageSquareMeter = averageSquareMeter;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Apartment)) return false;
        if(!super.equals(o)) return false;
        Apartment i = (Apartment)o;
        if(this.area != i.area || this.averageSquareMeter != i.averageSquareMeter) return false;
        return true;
    }

    @Override
    public Boolean isGoodDeal(){
        return (getPrice() < area * averageSquareMeter);
    }
}

class Car extends ItemForSale{
    private int travelledKM;
    private int newOfficialPrice;

    public int getTravelledKM(){
        return travelledKM;
    }
    public int getNewOfficialPrice() { return newOfficialPrice; }

    public Car(String itemName, int price, int travelledKM, int newOfficialPrice){
        super(itemName, price);
        this.travelledKM = travelledKM;
        this.newOfficialPrice = newOfficialPrice;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Car)) return false;
        if(!super.equals(o)) return false;
        Car i = (Car)o;
        if(this.travelledKM != i.travelledKM || this.newOfficialPrice != i.newOfficialPrice) return false;
        return true;
    }

    @Override
    public Boolean isGoodDeal() {
        return (getPrice() < newOfficialPrice - (travelledKM / 1000) * 250);
    }
}

class Website{
    private ItemForSale[] collection;

    public Website(ItemForSale[] collection){
        this.collection = collection;
    }

    public void listAll(){
        for(ItemForSale i : collection) System.out.println(i);
    }

    public void discountItems(int percent, int[] indices){
        for(int index: indices) collection[index].offerDiscount(percent);
    }

    public int countGoodAptDeals(int priceLimit, double minArea, boolean goodDealFlag){
        int res = 0;
        for(ItemForSale i : collection){
            if(!(i instanceof Apartment)) continue;
            Apartment app = (Apartment) i;
            if((app.getPrice() <= priceLimit && app.getArea() >= minArea) && (!goodDealFlag || app.isGoodDeal())) res++;
        }
        return res;
    }

    public Car[] searchForCar(int priceLimit, int maxKM, boolean goodDealFlag){
        ArrayList<Car> results = new ArrayList();
        for(ItemForSale i : collection){
            if(!(i instanceof Car)) continue;
            Car car = (Car) i;
            if(car.getPrice() <= priceLimit && car.getTravelledKM() <= maxKM && (!goodDealFlag || car.isGoodDeal()))
                results.add(car);
        }
        return (Car[]) results.toArray();
    }

    public static int compareWebsites(Website first, Website second){
        int firstGood = 0;
        int secondGood = 0;
        for(ItemForSale i : first.collection){
            if(i.isGoodDeal()) firstGood++;
        }
        for(ItemForSale i : second.collection){
            if(i.isGoodDeal()) secondGood++;
        }
        return (firstGood > secondGood) ? 1 : (firstGood < secondGood) ? -1 : 0;
    }
}
