package com.gazfood.gazfoodspringboot.exports;

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
import java.util.Date;
import java.util.List;

public class PhoneNumberInCabinetExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<PhoneNumberInCabinet> listPhoneNumberInCabinet;


    public PhoneNumberInCabinetExcelExporter(List<PhoneNumberInCabinet> listUsers) {
        this.listPhoneNumberInCabinet = listUsers;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Phones");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "№ п/п", style);
        createCell(row, 1, "Номер телефона городской", style);
        createCell(row, 2, "Номер телефона газовый", style);
        createCell(row, 3, "Номер кабинета", style);
        createCell(row, 4, "Номер розетки", style);
        createCell(row, 5, "Место установки/отдел", style);

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

        for (PhoneNumberInCabinet phoneNumberInCabinet : listPhoneNumberInCabinet) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;


            createCell(row,columnCount++,rowCount-1,style);

            if (phoneNumberInCabinet.getPhoneNumberCity() != null) {
                createCell(row, columnCount++, phoneNumberInCabinet.getPhoneNumberCity(), style);
            } else {
                createCell(row, columnCount++, "нет данных", style);
            }

            if (phoneNumberInCabinet.getPhoneNumber() != null) {
                createCell(row, columnCount++, phoneNumberInCabinet.getPhoneNumber(), style);
            } else {
                createCell(row, columnCount++, "нет данных", style);
            }

            if (phoneNumberInCabinet.getCabinet() != 0) {
                createCell(row, columnCount++, phoneNumberInCabinet.getCabinet(), style);
            } else {
                createCell(row, columnCount++, "нет данных", style);
            }

            if (phoneNumberInCabinet.getSocket() != null) {
                createCell(row, columnCount++, phoneNumberInCabinet.getSocket(), style);

            } else {
                createCell(row, columnCount++, "нет данных", style);
            }
            if (phoneNumberInCabinet.getDepartment() != null) {
                createCell(row, columnCount++, phoneNumberInCabinet.getDepartment(), style);

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
