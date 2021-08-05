package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.ReceptRepository;
import com.gazfood.gazfoodspringboot.entity.Recept;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ReceptServiceImpl implements ReceptService {
    @Autowired
    private ReceptRepository receptRepository;

    @Override
    public List<Recept> getAllRecept() {
        List<Recept> allRecepts = receptRepository.findAll();
        return allRecepts;
    }

    @Override
    public long getCountRecept() {
        return receptRepository.count();
    }

    @Override
    public void saveRecept(Recept recept) {
        receptRepository.save(recept);
    }

    @Override
    public Recept getRecept(int id) {
        Recept recept = null;
        Optional<Recept> optional = receptRepository.findById(id);
        if(optional.isPresent()){
            recept = optional.get();
        }
        return recept;
    }

    @Override
    public void deleteRecept(int id) {
        receptRepository.deleteById(id);
    }

    @Override
    public void checkAct() throws IOException {
        System.out.println("Начата обработка актов");
        //Данные для хранения номера столбца и номера строки ячейки со значением "Код"
        String codeValue = "Код";
        int codeColumnIndex = 0;
        int codeRowIndex = 0;

        //Данные для хранения номера столбца и номера строки ячейки со значением "наименование"
        String nameValue = "наименование";
        int nameColumnIndex = 0;
        int nameRowIndex = 0;

        //Данные для хранения номера столбца и номера строки ячейки со значением "по учётным ценам производителя"
        String priceNameValue = "по учётным ценам производителя";
        int priceNameColumnIndex = 0;
        int priceNameRowIndex = 0;

        //Данные для хранения номера столбца и номера строки ячейки со значением "цена руб. коп."
        String priceRubValue = "цена руб. коп.";
        int priceRubColumnIndex = 0;
        int priceRubRowIndex = 0;

        //Данные для хранения номера столбца и номера строки ячейки со значением "Номер по порядку"
        String numbersName = "Номер по порядку";
        int numbersNameColumnIndex = 0;
        int numbersNameRowIndex = 0;

        // Начало и конец строчек для поиска
        int startRow = 0;
        int startRowValue = 0;
        int endRow = 0;
        String endRowName = "Итого собственная продукция:";

        File file = new File("C:/demo/Акт о реализации.xls");

        // Читаем xls файл
        FileInputStream inputStream = new FileInputStream(file);

        // Получаем workbook
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

        // Получаем первую закладку
        HSSFSheet sheet = workbook.getSheetAt(0);

        // Проходим по всем строкам
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            // Проходим по всем ячейкам в строке
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                CellType cellType = cell.getCellType();

                switch (cellType) {
                    case _NONE:
                        System.out.print("");
                        System.out.print("\t");
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        System.out.print("\t");
                        break;
                    case BLANK:
                        System.out.print("");
                        System.out.print("\t");
                        break;
                    case FORMULA:
                        // Если есть формула
//                        System.out.print(cell.getCellFormula());
                        System.out.print("\t");

                        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                        // Печать значения из формулы
                        System.out.print(evaluator.evaluate(cell).getNumberValue());
                        break;

                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        System.out.print("\t");
                        // Множественные проверки
                        // если первым идет столбик "наименование", а за ним столбик "Код", то сохраняем их координаты.
                        if (cell.getStringCellValue().equals(nameValue)) {
                            nameColumnIndex = cell.getColumnIndex();
                            nameRowIndex = cell.getRowIndex();

                        }
                        if (cell.getStringCellValue().equals(codeValue) & cell.getRowIndex() == nameRowIndex) {
                            codeColumnIndex = cell.getColumnIndex();
                            codeRowIndex = cell.getRowIndex();

                        }

                        if (cell.getStringCellValue().equals(priceNameValue) & cell.getRowIndex() == codeRowIndex) {
                            priceNameColumnIndex = cell.getColumnIndex();
                            priceNameRowIndex = cell.getRowIndex();
                        }

                        if (cell.getStringCellValue().equals(priceRubValue) & cell.getColumnIndex() == priceNameColumnIndex) {
                            priceRubColumnIndex = cell.getColumnIndex();
                            priceRubRowIndex = cell.getRowIndex();
                        }

                        // ищем "Номер по порядку"
                        if (cell.getStringCellValue().equals(numbersName)) {
                            numbersNameColumnIndex = cell.getColumnIndex();
                            numbersNameRowIndex = cell.getRowIndex();
                        }

                        // ищем "Итого собственная продукция:" и конец
                        if (cell.getStringCellValue().equals(endRowName)) {
                            endRow = cell.getRowIndex()+1;
                        }


//
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        System.out.print("\t");

                        // ищем старт
                        if(cell.getColumnIndex()==numbersNameColumnIndex & startRow==0) {
                            startRow = cell.getRowIndex()+1;
                        }

                        break;
                    case ERROR:
                        System.out.print("!");
                        System.out.print("\t");
                        break;
                }

            }
            System.out.println("");
        }

        System.out.println(" *** **** ***");
        System.out.println(nameValue + " column: " + nameColumnIndex + " row: " + nameRowIndex);
        System.out.println(codeValue + " column: " + codeColumnIndex + " row: " + codeRowIndex);
        System.out.println(priceNameValue + " column: " + priceNameColumnIndex + " row: " + priceNameRowIndex);
        System.out.println(priceRubValue + " column: " + priceRubColumnIndex + " row: " + priceRubRowIndex);
        System.out.println(numbersName + " column: " + numbersNameColumnIndex + " row: " + numbersNameRowIndex);
        System.out.println("startRow: " + startRow);
        System.out.println("endRow: " + endRow);
        System.out.println("///////////////////////");
        Cell cell = null;
        for (int i=startRow; i<endRow-1;i++){
//            System.out.println(sheet.getRow(i).getCell(priceNameColumnIndex));
            cell = sheet.getRow(i).getCell(priceNameColumnIndex);
            cell.setCellValue(123);
        }

        inputStream.close();

        // Записываем файл
        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);
        out.close();
        System.out.println("Закончена обработка актов");
    }


}
