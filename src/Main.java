
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
       // DataForm dataForm = new DataForm();
        List<DataForm> list = new ArrayList<DataForm>();
        List<DataForm> newList = new ArrayList<DataForm>();
        list =  readXls.readXls();
        for(int i = 0; i < list.size(); i++){
         DataForm   dataForm = list.get(i);
            //System.out.println(dataForm.getNum() + "   " + dataForm.getLastYearBill() + "   " + dataForm.getMinutes());
            MonthBill monthBill = new MonthBill(dataForm.getLastYearBill(), dataForm.getTimes(), dataForm.getMinutes());
            //System.out.println(monthBill.getTotal());
            DataForm dataForm1 = new DataForm(dataForm.getNum(), dataForm.getLastYearBill(),dataForm.getTimes(), dataForm.getMinutes(), dataForm.getExpectedBill(), monthBill.getTotal());
            System.out.println(dataForm1.getResult());
        }

    }


}
