package sample.Services;

import sample.Wearings.Shoes;
import sample.Wearings.Wearings;
import java.util.List;
import static sample.methodes.user;
import org.xBaseJ.DBF;
import org.xBaseJ.fields.CharField;
import org.xBaseJ.fields.NumField;


public class Dbf {

    public void fillDbfResult(List<Wearings> result){
        try {
            int i=0;
            DBF shoesDB;
            shoesDB = new DBF("C:\\Users\\" + user +"\\Desktop\\shop\\inventory.dbf");

            //Define fields
            CharField product = (CharField) shoesDB.getField("Product");
            CharField brand = (CharField) shoesDB.getField("Brand");
            CharField gender = (CharField) shoesDB.getField("Gender");
            NumField size = (NumField) shoesDB.getField("Size");
            CharField color = (CharField) shoesDB.getField("Color");
            NumField price = (NumField) shoesDB.getField("Price");

            while(i < shoesDB.getRecordCount()) {
                shoesDB.read();
                Shoes s = new Shoes(product.get(),brand.get().trim(),Double.valueOf(price.get().trim()),size.get().trim(),color.get().trim(),gender.get().trim());
                result.add(s);
                    i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
