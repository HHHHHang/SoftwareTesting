import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class readXls{
    public static List<DataForm> readXls() throws IOException{
        String fileName = "test.xls";
        InputStream is = new FileInputStream(fileName);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        List<DataForm> list = new ArrayList<DataForm>();

        // 循环工作表Sheet
        for(int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++){
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if(hssfSheet == null){
                continue;
            }
            // 循环行Row
            for(int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++){
                DataForm dataForm = new DataForm();
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if(hssfRow == null){
                    continue;
                }

                // 0编号 1跨年未缴费金额 2通话时间 3不按时缴费次数 4期望缴费金额 5实际缴费金额 6比较结果
                HSSFCell num = hssfRow.getCell(0);
                if(num == null){
                    continue;
                }
                dataForm.setNum((int)num.getNumericCellValue());
                HSSFCell lastYearBill = hssfRow.getCell(1);
                if(lastYearBill == null){
                    continue;
                }
                dataForm.setLastYearBill(Double.parseDouble(getValue(lastYearBill)));
                HSSFCell minutes = hssfRow.getCell(2);
                if(minutes == null){
                    continue;
                }
                dataForm.setMinutes((int)minutes.getNumericCellValue());
                HSSFCell times = hssfRow.getCell(3);
                if(times == null){
                    continue;
                }
                dataForm.setTimes((int)times.getNumericCellValue());
                HSSFCell expectedBill = hssfRow.getCell(4);
                if(expectedBill == null){
                    continue;
                }
                dataForm.setExpectedBill(Double.parseDouble(getValue(expectedBill)));
                list.add(dataForm);
                //}
            }
        }
        return list;
    }

    @SuppressWarnings("static-access")
    private static String getValue(HSSFCell hssfCell){
        if(hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN){
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        }else if(hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC){
            // 返回数值类型的值
            return String.valueOf(hssfCell.getNumericCellValue());
        }else{
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}

