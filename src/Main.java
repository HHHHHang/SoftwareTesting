
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
      Desktop desktop = new Desktop();
    }

    //junit Test
    @Test
    public void Test() throws Exception{
        List<DataForm> list = new ArrayList<DataForm>();
        List<DataForm> newList = new ArrayList<DataForm>();
        list =  readXls.readXls();
        for(int i = 0; i < list.size(); i++){
            DataForm dataForm = list.get(i);
            //System.out.println(dataForm.getNum() + "   " + dataForm.getLastYearBill() + "   " + dataForm.getMinutes());
            MonthBill monthBill = new MonthBill(dataForm.getLastYearBill(), dataForm.getTimes(), dataForm.getMinutes());
//            System.out.println(monthBill.getTotal());
            DataForm dataForm1 = new DataForm(dataForm.getNum(), dataForm.getLastYearBill(),dataForm.getTimes(), dataForm.getMinutes(), dataForm.getExpectedBill(), monthBill.getTotal());
            System.out.println(dataForm1.getResult());
            newList.add(dataForm1);
        }
<<<<<<< HEAD
        writeXls.writXls(newList);
=======
>>>>>>> f580cbbc9d7158e8d5ac570804910fe6a25a5a07
    }


}
