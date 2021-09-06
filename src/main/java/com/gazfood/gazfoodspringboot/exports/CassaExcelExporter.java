package com.gazfood.gazfoodspringboot.exports;

import com.gazfood.gazfoodspringboot.entity.Cassa;
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
import java.util.Date;
import java.util.List;

public class CassaExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Cassa> listUsers;

    public CassaExcelExporter(List<Cassa> listUsers) {
        this.listUsers = listUsers;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Users");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Название кассы", style);
        createCell(row, 1, "Prefix", style);
        createCell(row, 2, "Ammy Admin", style);
        createCell(row, 3, "Any Desk", style);
        createCell(row, 4, "Имя компьютера", style);
        createCell(row, 5, "Дней до окончания ФН", style);
        createCell(row, 6, "Дата окончания ФН", style);
        createCell(row, 7, "Адрес", style);
        createCell(row, 8, "Дата обновления РестАрт", style);
        createCell(row, 9, "КПП", style);
        createCell(row, 10, "РН ККТ", style);
        createCell(row, 11, "Номер ФН", style);
        createCell(row, 12, "Мобильный номер", style);
        createCell(row, 13, "ICC", style);
        createCell(row, 14, "Газовый", style);
        createCell(row, 15, "Лицензия", style);
        createCell(row, 16, "Для заметок", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
//        sheet.autoSizeColumn(columnCount);
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

        for (Cassa cassa : listUsers) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;


            createCell(row, columnCount++, cassa.getCassaName(), style);
            createCell(row, columnCount++, cassa.getPrefix(), style);
            createCell(row, columnCount++, cassa.getAmmyAdmin(), style);
            createCell(row, columnCount++, cassa.getAnnyDesk(), style);
            createCell(row, columnCount++, cassa.getComputerName(), style);
            if (cassa.getFnDeadlineData() != null) {
                createCell(row, columnCount++, java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), cassa.getFnDeadlineData()), style);
            } else {
                createCell(row, columnCount++, "нет данных", style);
            }

            if (cassa.getFnDeadlineData() != null) {
                createCell(row, columnCount++, cassa.getFnDeadlineData().toString(), style);
            } else {
                createCell(row, columnCount++, "нет данных", style);
            }

            createCell(row, columnCount++, cassa.getCassaAdres(), style);

            if (cassa.getDataUpdate() != null) {
                createCell(row, columnCount++, cassa.getDataUpdate(), style);
            } else {
                createCell(row, columnCount++, "нет данных", style);
            }

            createCell(row, columnCount++, cassa.getKpp(), style);
            createCell(row, columnCount++, cassa.getRnkkt(), style);
            createCell(row, columnCount++, cassa.getFnNumber(), style);
            createCell(row, columnCount++, cassa.getMobileNumber(), style);

            if (cassa.getIccNumber() != null) {
                createCell(row, columnCount++, cassa.getIccNumber(), style);
            } else {
                createCell(row, columnCount++, "нет данных", style);
            }
            createCell(row, columnCount++, cassa.getPhoneNumber(), style);
            if (cassa.getLicense() != null) {
                createCell(row, columnCount++, cassa.getLicense(), style);
            } else {
                createCell(row, columnCount++, "нет данных", style);
            }
            createCell(row, columnCount++, cassa.getTemp(), style);

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
