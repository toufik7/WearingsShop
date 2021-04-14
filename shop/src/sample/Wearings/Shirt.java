package sample.Wearings;

public class Shirt extends Wearings{
    public Shirt(String product,String mark, double price, String size, String color, String gender) {
        super(product,mark, price, size, color, gender);
    }

    @Override
    public Wearings clone() {
        return super.clone();
    }
}
