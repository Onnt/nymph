package cn.virde.nymph.office;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class TestSelfCode {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(new File("test.xls")));
		HSSFSheet sheet = wb.getSheetAt(1);

        //第三部，在sheet表中添加表头第0行，老版本的poi对sheet的行列有限制
		HSSFRow row = sheet.createRow(0);
        //第四步，创建单元格，设置表头
        HSSFCell cell = row.createCell(13);
        cell.setCellValue("用户名");
        cell = row.createCell(14);
        cell.setCellValue("密码");
        cell = row.createCell(15);
        cell.setCellValue("密码2");
        
        wb.write(new FileOutputStream(new File("test.xls")));
		 
	}
}
