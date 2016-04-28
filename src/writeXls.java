import java.io.*;
import java.util.List;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class writeXls {
    public static void writXls(List<DataForm> xls) throws IOException {
        // 获取总列数
        int CountColumnNum = xls.size();
        // 创建Excel文档
        HSSFWorkbook hwb = new HSSFWorkbook(new POIFSFileSystem(
                new FileInputStream("test.xls")));
        DataForm dataForm = null;
        // sheet 对应一个工作页
        HSSFSheet sheet = hwb.getSheet("工作表1");
        HSSFFont fontRed = hwb.createFont();
        HSSFFont fontGreen = hwb.createFont();
        HSSFCellStyle styleGreen = hwb.createCellStyle();
        HSSFCellStyle styleRed = hwb.createCellStyle();
        String[] names = new String[CountColumnNum];
        names[0] = "实际缴费金额";
        names[1] = "比较结果";

        for (int i = 0; i < xls.size(); i++) {
            // 创建一行
            HSSFRow row = sheet.getRow(i + 1);
            // 得到要插入的每一条记录
            dataForm = xls.get(i);
            HSSFCell actualBill = row.createCell(5);
            actualBill.setCellValue(dataForm.getActualBill());
            HSSFCell result = row.createCell(6);
            if(dataForm.getResult().equals("pass"))
            {
                fontGreen.setColor(HSSFColor.GREEN.index);
                styleGreen.setFont(fontGreen);
                result.setCellStyle(styleGreen);
            }else {
                styleRed = hwb.createCellStyle();
                fontRed.setColor(HSSFColor.RED.index);
                styleRed.setFont(fontRed);
                result.setCellStyle(styleRed);
            }
            result.setCellValue(dataForm.getResult());
        }
        // 创建文件输出流，准备输出电子表格
        OutputStream out = new FileOutputStream("test.xls");
        hwb.write(out);
        out.close();
        System.out.println("写入成功!");
    }
}
