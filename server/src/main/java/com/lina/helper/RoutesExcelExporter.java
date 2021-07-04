// package com.lina.helper;
 
// import java.io.IOException;
// import java.util.List;
 
// import javax.servlet.ServletOutputStream;
// import javax.servlet.http.HttpServletResponse;

// import com.lina.models.RoutesLabel;

// import org.apache.poi.ss.usermodel.Cell;
// import org.apache.poi.ss.usermodel.CellStyle;
// import org.apache.poi.ss.usermodel.Row;
// import org.apache.poi.xssf.usermodel.XSSFFont;
// import org.apache.poi.xssf.usermodel.XSSFSheet;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
// public class RoutesExcelExporter {
//     private XSSFWorkbook workbook;
//     private XSSFSheet sheet;
//     private List<RoutesLabel> listRoute;
     
//     public RoutesExcelExporter(List<RoutesLabel> listRoute) {
//         this.listRoute= listRoute;
//         workbook = new XSSFWorkbook();
//     }
 
 
//     private void writeHeaderLine() {
//         sheet = workbook.createSheet("Routes");
         
//         Row row = sheet.createRow(0);
         
//         CellStyle style = workbook.createCellStyle();
//         XSSFFont font = workbook.createFont();
//         font.setBold(true);
//         font.setFontHeight(16);
//         style.setFont(font);
         
//         createCell(row, 0, "N° RN", style);      
//         createCell(row, 1, "Ville de Départ", style);       
//         createCell(row, 2, "Ville d'arrivée", style);    
//         createCell(row, 3, "Distance", style);
//         createCell(row, 4, "Etat Global", style);
         
//     }
     
//     private void createCell(Row row, int columnCount, Object value, CellStyle style) {
//         sheet.autoSizeColumn(columnCount);
//         Cell cell = row.createCell(columnCount);
//         if (value instanceof Integer) {
//             cell.setCellValue((Integer) value);
//         } else if (value instanceof Boolean) {
//             cell.setCellValue((Boolean) value);
//         }else {
//             cell.setCellValue((String) value);
//         }
//         cell.setCellStyle(style);
//     }
     
//     private void writeDataLines() {
//         int rowCount = 1;
 
//         CellStyle style = workbook.createCellStyle();
//         XSSFFont font = workbook.createFont();
//         font.setFontHeight(14);
//         style.setFont(font);
                 
//         for (RoutesLabel route : listRoute) {
//             Row row = sheet.createRow(rowCount++);
//             int columnCount = 0;
             
//             createCell(row, columnCount++, "RN "+route.getNoRn(), style);
//             createCell(row, columnCount++, route.getVilleDebut(), style);
//             createCell(row, columnCount++, route.getVilleFin(), style);
//             createCell(row, columnCount++, route.getDistance()+" km", style);
//             createCell(row, columnCount++, route.getGlob()+" %", style);
             
//         }
//     }
     
//     public void export(HttpServletResponse response) throws IOException {
//         writeHeaderLine();
//         writeDataLines();
         
//         ServletOutputStream outputStream = response.getOutputStream();
//         workbook.write(outputStream);
//         workbook.close();
         
//         outputStream.close();
         
//     }
// }