package com.gazfood.gazfoodspringboot.exports;

import com.gazfood.gazfoodspringboot.entity.Inventory;
import com.gazfood.gazfoodspringboot.entity.PhoneNumberInCabinet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class InventoryExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Inventory> listInventory;

    public InventoryExporter(List<Inventory> listInventory) {
        this.listInventory = listInventory;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Inventarizacia");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Наименование", style);
        createCell(row, 1, "Инвентарный номер", style);
        createCell(row, 2, "Место размещения", style);
        createCell(row, 3, "Количество", style);
        createCell(row, 4, "Цена", style);
        createCell(row, 5, "Дата получения", style);
        createCell(row, 6, "Ответственное лицо", style);
        createCell(row, 7, "Адрес", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
//        sheet.autoSizeColumn(columnCount); // Ужас как тормозило выгрузку!!!
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

        for (Inventory inventory : listInventory) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;


            if (inventory.getInventoryName() != null) {
                createCell(row, columnCount++, inventory.getInventoryName(), style);
            } else {
                createCell(row, columnCount++, "нет данных", style);
            }

            if (inventory.getInventoryNumber() != null) {
                createCell(row, columnCount++, inventory.getInventoryNumber(), style);
            } else {
                createCell(row, columnCount++, "нет данных", style);
            }

            if (inventory.getPlace() != null) {
                createCell(row, columnCount++, inventory.getPlace(), style);
            } else {
                createCell(row, columnCount++, "нет данных", style);
            }

            if (inventory.getCount() != 0) {
                createCell(row, columnCount++, inventory.getCount(), style);

            } else {
                createCell(row, columnCount++, 0, style);
            }
            if (inventory.getPrice() != 0) {
                createCell(row, columnCount++, inventory.getPrice(), style);

            } else {
                createCell(row, columnCount++, 0.00, style);
            }
            if (inventory.getInventoryDate() != null) {
                createCell(row, columnCount++, inventory.getInventoryDate().toString(), style);
            }
            if (inventory.getResponsible() != null) {
                createCell(row, columnCount++, inventory.getResponsible(), style);
            } else {
                createCell(row, columnCount++, "нет данных", style);
            }
            if (inventory.getAddress() != null) {
                createCell(row, columnCount++, inventory.getAddress(), style);
            } else {
                createCell(row, columnCount++, "нет данных", style);
            }

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
