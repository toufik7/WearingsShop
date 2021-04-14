package sample.Services;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sample.Wearings.Wearings;
import java.util.List;
import static sample.methodes.user;

public class Excel {

    public void fillExcelResult(List<Wearings> result){
        try{
            int i=1;
            double price = 0; String product = ""; String brand =""; String size = "";String color =""; String gender = "";
            XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\" + user +"\\Desktop\\shop\\inventory.xlsx");
            XSSFSheet sheet = workbook.getSheet("inventory");
            while (i <= sheet.getLastRowNum()){

                product = sheet.getRow(i).getCell(0).getStringCellValue();
                brand = sheet.getRow(i).getCell(1).getStringCellValue();
                gender = sheet.getRow(i).getCell(2).getStringCellValue();
                size = sheet.getRow(i).getCell(3).getStringCellValue();
                color = sheet.getRow(i).getCell(4).getStringCellValue();
                price = sheet.getRow(i).getCell(5).getNumericCellValue();

                Wearings w = new Wearings(product,brand,price,size,color,gender);
                result.add(w);
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
