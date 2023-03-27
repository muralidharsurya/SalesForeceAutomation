package genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;


public class ExcelFileUtility {
	  /**
     * This method will read data from excel sheet
     *
     * @param sheet
     * @param row
     * @return
     * @throws Exception
     * @paramcell
     */
    public String readDataFromExcel(String sheet, int row, int cel) throws Exception {
        FileInputStream fis = new FileInputStream(IConstantUtility.ExcelFilePath);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet(sheet);
        Row rw = sh.getRow(row);
        Cell ce = rw.getCell(cel);
        String value = ce.getStringCellValue();
        return value;

    }

    public int getRowCount(String sheet) throws Exception {
        FileInputStream fis = new FileInputStream(IConstantUtility.ExcelFilePath);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet(sheet);
        int rowCount = sh.getLastRowNum();
        return rowCount;
    }

    /**
     * This method will write the data into excel sheet
     *
     * @param sheet
     * @param row
     * @param value
     * @throws Exception
     * @paramcell
     */
    public void writeDataIntoExcel(String sheet, int row, int cel, String value) throws Exception {
        FileInputStream fis = new FileInputStream(IConstantUtility.ExcelFilePath);
        Workbook wb = WorkbookFactory.create(fis);
        Row rw = wb.getSheet(sheet).getRow(row);
        rw.createCell(cel).setCellValue(value);
        FileOutputStream fos = new FileOutputStream(IConstantUtility.ExcelFilePath);
        wb.write(fos);
        System.out.println("data added");
        wb.close();
    }


    public Object[][] readMultipleData(String Sheetname) throws Exception {
        FileInputStream fis = new FileInputStream(IConstantUtility.ExcelFilePath);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet(Sheetname);
        int lastRow = sh.getLastRowNum();
        int lastCel = sh.getRow(0).getLastCellNum();

        Object[][] data = new Object[lastRow][lastCel];

        for (int i = 0; i < lastRow; i++) {
            for (int j = 0; j < lastCel; j++) {
                data[i][j] = sh.getRow(i + 1).getCell(j).getStringCellValue();
            }
        } 
        return data;
    }

}
