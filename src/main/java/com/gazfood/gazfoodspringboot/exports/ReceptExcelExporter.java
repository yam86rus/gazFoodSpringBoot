package com.gazfood.gazfoodspringboot.exports;

import com.gazfood.gazfoodspringboot.entity.PhoneNumberInCabinet;
import com.gazfood.gazfoodspringboot.entity.Recept;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ReceptExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Recept> listRecepts;


    public ReceptExcelExporter(List<Recept> listRecepts) {
        this.listRecepts = listRecepts;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Рецептуры");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Код наименования номенклатуры в 1С", style);
        createCell(row, 1, "Нормативный документ", style);
        createCell(row, 2, "Наименование", style);
        createCell(row, 3, "Выход блюда", style);
        createCell(row, 4, "Цена по себестоимости", style);
        createCell(row, 5, "Цена продажная", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value.toString() != null) {
            if (value instanceof Integer) {
                cell.setCellValue((Integer) value);
            } else if (value instanceof Boolean) {
                cell.setCellValue((Boolean) value);
            } else if (value instanceof Date) {
                cell.setCellValue((Date) value);
            } else if (value instanceof Long) {
                cell.setCellValue((Long) value);
            } else if (value instanceof Double) {
                cell.setCellValue((Double) value);
            } else {
                cell.setCellValue((String) value);
            }
            cell.setCellStyle(style);
        }

    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Recept recept : listRecepts) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;


            createCell(row, columnCount++, rowCount - 1, style);

            if (recept.getReceptName() != null) {
                createCell(row, columnCount++, recept.getReceptName(), style);
            } else {
                createCell(row, columnCount++, "нет данных", style);
            }

            if (recept.getDocument() != null) {
                createCell(row, columnCount++, recept.getDocument(), style);
            } else {
                createCell(row, columnCount++, "нет данных", style);
            }

            if (recept.getReceptName() != null) {
                createCell(row, columnCount++, recept.getReceptName(), style);
            } else {
                createCell(row, columnCount++, "нет данных", style);
            }

            if (recept.getExit() != null) {
                createCell(row, columnCount++, recept.getExit(), style);

            } else {
                createCell(row, columnCount++, "нет данных", style);
            }

            createCell(row, columnCount++, recept.getPriceSebestoimost(), style);

            createCell(row, columnCount++, recept.getPriceProdaja(), style);


        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }
}
