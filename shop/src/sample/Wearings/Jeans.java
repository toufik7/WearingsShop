package sample.Wearings;

public class Jeans extends Wearings{
    @Override
    public Wearings clone(){
        Jeans clone = (Jeans) super.clone();
        return clone;
    }

}
