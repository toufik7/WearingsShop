package sample.Services;

import sample.Wearings.Wearings;
import java.util.List;

public class ServiceAdapter {
    Excel e = new Excel();
    Dbf dbf = new Dbf();

    public void GetData(List<Wearings> result){
        //get data from Excel Inventory
        e.fillExcelResult(result);

        //get data from DBF Inventory
        dbf.fillDbfResult(result);
    }
}
