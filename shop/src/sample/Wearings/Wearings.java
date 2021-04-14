package sample.Wearings;

public class Wearings implements Cloneable{
    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMark() {
        return mark;
    }

    public double getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String getGender() {
        return gender;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    private String product;
    private String mark;
    private double price;
    private String size;
    private String color;
    private String gender;

        public Wearings() {
        }

        public Wearings(String product,String mark, double price, String size, String color, String gender) {
            this.product = product;
            this.mark = mark;
            this.price = price;
            this.size = size;
            this.color = color;
            this.gender = gender;
        }

        public Wearings clone() {
            Wearings clone = new Wearings();
            clone.product = product;
            clone.mark = mark;
            clone.price = price;
            clone.size = size;
            clone.color = color;
            clone.gender = gender;
            return clone;
        }

}
