package sample.Services;

import javafx.scene.control.ComboBox;
import sample.Wearings.Wearings;
import java.util.List;

public class ServiceAdapter {
    Excel e = new Excel();
    Dbf dbf = new Dbf();
    Accdb accdb = new Accdb();

    public void GetData(List<Wearings> result){
        //get data from Excel Inventory
        e.fillExcelResult(result);

        //get data from DBF Inventory
        dbf.fillDbfResult(result);

        //get data from ms Office Inventory
        accdb.fillDbfResult(result);
    }
    public void GetBrand(ComboBox<String> Brandfilter){
        //get brand from ms Office Inventory
        accdb.getbrand(Brandfilter);

        //todo:get brand from Excel Inventory

        //todo:get brand from DBF Inventory

    }
    public void GetSize(ComboBox<String> Sizefilter){
        //get size from ms Office Inventory
        accdb.getsize(Sizefilter);

        //todo:get size from Excel Inventory

        //todo:get size from DBF Inventory

    }
    public void GetColor(ComboBox<String> Colorfilter){
        //get color from ms Office Inventory
        accdb.getcolor(Colorfilter);

        //todo:get color from Excel Inventory

        //todo:get color from DBF Inventory

    }
    public void GetGender(ComboBox<String> Genderfilter){
        //get gender from ms Office Inventory
        accdb.getgender(Genderfilter);

        //todo:get gender from Excel Inventory

        //todo:get gender from DBF Inventory

    }
}
