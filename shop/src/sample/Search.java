package sample;

import sample.Services.ServiceAdapter;
import sample.Wearings.Wearings;
import java.util.ArrayList;
import java.util.List;

public class Search {
    public void setResult(List<Wearings> result) {
        this.result = result;
    }

    private  List<Wearings> result;
    private  List<Wearings> resultCopy;

    public Search() {
         result = new ArrayList<>();
         resultCopy = new ArrayList<>();
    }

    public void anySearch() {
        //1- the search logic is assumed storing the results in the array list result
        ServiceAdapter serviceAdapter = new ServiceAdapter();
        //get data from difrent tables
        serviceAdapter.GetData(result);


        //2- make a copy of result in resultCopy
        resultCopy.clear();
        for (Wearings w : result) {
            resultCopy.add(w.clone());
        }
    }

    public void removeAllFilters() {
        result.clear();
        for (Wearings wearing : resultCopy) {
            result.add(wearing.clone());
        }
    }

    /**
     * the rest of the methods do not use the prototype pattern directly
     */
    public void addFilter(String type, String value) {
        int i=0;
        //todo: remove the wearings items from result list according to the filter
        switch(type) {
            case "mark":

                while(i<result.size()) {
                    if (!result.get(i).getMark().equals(value)){
                        result.remove(result.get(i));
                    }else i++;
                }
                break;
            case "size":
                while(i<result.size()) {
                    if (!result.get(i).getSize().equals(value)){
                        result.remove(result.get(i));
                    }else i++;
                }
                break;
            case "color":
                while(i<result.size()) {
                    if (!result.get(i).getColor().equals(value)){
                        result.remove(result.get(i));
                    }else i++;
                }
                break;
            case "gender":
                while(i<result.size()) {
                    if (!result.get(i).getGender().equals(value)){
                        result.remove(result.get(i));
                    }else i++;
                }
                break;
            default:
                AlertBox.display("error","none exsisting filter!");
        }

    }

    public void addPriceFilter(double min, double max) {
        //todo: remove the wearings items from result list according to the price filter
        int i=0;
        if (min!=0 && max!=-1){
            while(i<result.size()) {
                if (!(result.get(i).getPrice()>=min && result.get(i).getPrice()<=max)){
                    result.remove(result.get(i));
                }else i++;
            }
        }else AlertBox.display("error","Please enter both man and min Price");


    }

    public void removeFilter(String type) {
        //todo: recover the wearing items that have been deleted from result according to the filter type
                for (Wearings wearing: resultCopy) {
                    if (!(result.contains(wearing))){
                        result.add(wearing.clone());
                    }

                }
    }

    public List<Wearings> getResult() {
        return result;
    }

    @Override
    public String toString() {
        String s="";
        for (Wearings w:result) {
            s = s+w.getMark()+" "+w.getGender()+" "+w.getColor()+" "+w.getSize()+" "+w.getPrice()+"\n";
        }
        return s;
    }
}

