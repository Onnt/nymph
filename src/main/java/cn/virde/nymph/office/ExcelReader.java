package cn.virde.nymph.office;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @Author Suna
 * 2019年4月11日 13:51:08
 */
public class ExcelReader {
    private String sheetName;
    // xlsx 对象
    private XSSFWorkbook book;
    // 当前sheet
    private XSSFSheet currSheet;
    // xlsx 文件路径
    private String filePath;

    public ExcelReader(String filePath,String sheetName) throws IOException {
        this.filePath = filePath ;
        InputStream is = new FileInputStream(filePath);
        book = new XSSFWorkbook(is);
        setSheet(sheetName);
    }

    @Deprecated
    public String readCell(int rowIndex,int cellIndex){
        return readCellStringValue(rowIndex, cellIndex);
    }
    public String readCellStringValue(int rowIndex,int cellIndex){
        try {
            return currSheet.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
        }catch (NullPointerException ex){
            return null;
        }
    }
    public String readCellRawValue(int rowIndex,int cellIndex){
        try {
            return currSheet.getRow(rowIndex).getCell(cellIndex).getRawValue();
        }catch (NullPointerException ex){
            return null;
        }
    }
    public boolean writeCell(int rowIndex,int cellIndex,String value){
        try{
            if (this.currSheet.getRow(rowIndex) == null) {
                this.currSheet.createRow(rowIndex);
            }

            if (this.currSheet.getRow(rowIndex).getCell(cellIndex) == null) {
                this.currSheet.getRow(rowIndex).createCell(cellIndex);
            }
            currSheet.getRow(rowIndex).getCell(cellIndex).setCellValue(value);
            save();
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public void setSheet(String sheetName){
        this.sheetName = sheetName;
        currSheet = book.getSheet(sheetName);
        if(currSheet==null){
            currSheet = book.createSheet();
        }
    }

    public XSSFSheet currSheet(){
        return currSheet;
    }

    public void close() throws IOException {
        if(book!=null){
            book.close();
        }
    }
    public void save() throws IOException {
        FileOutputStream fos = new FileOutputStream(filePath);
        book.write(fos);
        fos.close();
    }
    public static void main(String[] args) throws IOException {
        ExcelReader er = new ExcelReader("D:\\temp\\3.xlsx","Sheet1");
        System.out.println(er.readCell(0,0));
        er.close();
    }
}
