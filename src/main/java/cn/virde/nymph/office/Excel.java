package cn.virde.nymph.office;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *  	 简单的Excel 工具
 *
 * @author SunAo
 * @date 2018年4月13日 下午2:35:16
 * @date 2018年8月28日 09:02:07
 */
public class Excel {

	// 行数游标
    private int currRowIndex = 0 ;
    
    // xlsx 对象
    private XSSFWorkbook book;
    // 当前sheet
    private XSSFSheet sheet;
    private int sheetIndex;
    
    // xlsx 文件路径
    private String filePath;
    

    public Excel(String filePath,int sheetIndex) throws IOException {
        this.filePath = filePath;
        this.sheetIndex = sheetIndex;
        init();
    }
    public Excel(String filePath) throws IOException {
        this.filePath = filePath;
        this.sheetIndex = 1;
        init();
    }
    
    public void init() throws IOException {
    	createFileIfNotExist();
	    initSheet();
    }
    public void initBook() throws IOException {
		InputStream is = new FileInputStream(filePath);
	    book = new XSSFWorkbook(is);
    }
    public void initSheet() {
	    sheet = getSheet(sheetIndex);
    }
    private XSSFSheet getSheet(String sheetName) {
	    XSSFSheet sheet = book.getSheet(sheetName);
	    if(sheet == null) {	    	
	    	sheet = book.createSheet(sheetName);
	    }
	    return sheet ;
    }
    private XSSFSheet getSheet(int sheetIndex) {
	    String sheetName = "Sheet"+sheetIndex ;
	    return getSheet(sheetName);
    }
    private void createFileIfNotExist() throws IOException {
		try {
			initBook();
			return ;
		}catch (IOException e) {
			book = new XSSFWorkbook();
			save();
			initBook();
			return;
		}
    }
    
    public void appendRow(String...strings) {
        XSSFRow row = sheet.createRow(currRowIndex++);
        int cellIndex = 0 ;
        for(String str : strings) {
            row.createCell(cellIndex++).setCellValue(str);
        }
    }
    
    public void setHeader(String...strings) {}
    public void nextSheet() {
    	sheetIndex ++;
    	sheet = getSheet(sheetIndex);
    }
    public void save() throws IOException {
        FileOutputStream fos = new FileOutputStream(filePath);
        book.write(fos);
        System.out.println(new Date()+": 写入成功");
        fos.close();
    }

    
    public static void main(String[] args) throws IOException {
    	Excel e = new Excel("D://test33.xlsx",12);
    	e.sheet.createRow(0).createCell(0).setCellValue("asdfasd");
    	e.save();
    }
}
