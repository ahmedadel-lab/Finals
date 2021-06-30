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

    public Apartment(String itemName, int price){
        super(itemName, price);
    }

    @Override
    public Boolean isGoodDeal(){
        if(getPrice() < area*averageSquareMeter) return true;
        return false;
    }
}

class Car extends ItemForSale{
    private int travelledKM;
    private int newOfficialPrice;

    public int getTravelledKM(){
        return travelledKM;
    }

    public Car(String itemName, int price){
        super(itemName, price);
    }

    @Override
    public Boolean isGoodDeal() {
        if (getPrice() < newOfficialPrice - travelledKM * 250) return true;
        return false;
    }
}

class Website{
    private ItemForSale[] collecion;

    public Website(ItemForSale[] collecion){
        this.collecion = collecion;
    }

    public void listAll(){
        for(ItemForSale i : collecion) System.out.println(i);
    }

    public void discountItems(int percent, int[] indices){
        for(int index: indices) collecion[index].offerDiscount(percent);
    }

    public int countGoodAptDeals(int priceLimit, double minArea, boolean goodDealFlag){
        int res = 0;
        for(ItemForSale i : collecion){
            if(!(i instanceof Apartment)) continue;
            Apartment app = (Apartment) i;
            if((app.getPrice() <= priceLimit && app.getArea() >= minArea) && (!goodDealFlag || app.isGoodDeal())) res++;
        }
        return res;
    }

    public Car[] searchForCar(int priceLimit, int maxKM, boolean goodDealFlag){
        ArrayList<Car> results = new ArrayList();
        for(ItemForSale i : collecion){
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
        for(ItemForSale i : first.collecion){
            if(i.isGoodDeal()) firstGood++;
        }
        for(ItemForSale i : second.collecion){
            if(i.isGoodDeal()) secondGood++;
        }
        return (firstGood > secondGood) ? 1 : (firstGood < secondGood) ? -1 : 0;
    }
}
