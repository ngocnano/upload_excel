package demo.view;

import demo.model.ImportInformation;
import demo.model.DBService;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ValueChangeEvent;

import org.apache.myfaces.trinidad.model.UploadedFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MyBean {
    public MyBean() {
    }
    
    List<ImportInformation> importInformations;
    List<String> errorlogs;

    public void uploadFile(ValueChangeEvent valueChangeEvent) {
        if(this.importInformations != null){
            importInformations.clear();
        }
        // Add event code here...
        UploadedFile fileVal = null;
        if (valueChangeEvent.getNewValue() != null) {
            //Get File Object from VC Event
            fileVal = (UploadedFile) valueChangeEvent.getNewValue();
        }
        try{
            InputStream inputStream = fileVal.getInputStream();
             readNProcessExcel(inputStream);
        } catch (IOException e){
             e.printStackTrace();
         }
        //saveImportInformation();
    }

    private void readNProcessExcel(InputStream inputStream) {
        //Use XSSFWorkbook for XLS file
        XSSFWorkbook WorkBook = null;
        try {
            WorkBook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        XSSFSheet sheet = WorkBook.getSheetAt(0);
        XSSFFormulaEvaluator formulaEvaluator = WorkBook.getCreationHelper().createFormulaEvaluator();
        List<String> temp = new ArrayList();
        for(int sheetIndex = 1; sheetIndex <= sheet.getLastRowNum(); sheetIndex++){
            Row tempRow = sheet.getRow(sheetIndex);
            temp.clear();
            for (Cell cell : tempRow) {
                switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        long a = (long) cell.getNumericCellValue();
                        temp.add(Long.toString(a));
                        break;
                    case Cell.CELL_TYPE_STRING:
                        temp.add(cell.toString());
                        break;
                    case Cell.CELL_TYPE_BLANK:
                        temp.add(null);
                        break;
                }
            }
            addValue(temp);
        }
    }

    private void addValue(List<String> temp) {
        
        if(this.importInformations == null){
            importInformations = new ArrayList();
        } 
        ImportInformation importInformation = new ImportInformation(temp);
        importInformations.add(importInformation);
    }

    public void setListInfo(List<ImportInformation> listInfo) {
        this.importInformations = listInfo;
    }

    public List<ImportInformation> getListInfo() {   
        return importInformations;
    }

    private void saveImportInformation() {

    }


    public String onClick() {
        // Add event code here...
        System.out.printf("Click save");
        errorlogs = new ArrayList();
        DBService.setLogErrors(this.errorlogs);
        DBService.setImports(this.getListInfo());
        if(DBService.testConnec()){
           DBService.create();
        }
        return "view";
    }

    public void setErrorlogs(List<String> errorlogs) {
        this.errorlogs = errorlogs;
    }

    public List<String> getErrorlogs() {
        return errorlogs;
    }
}
