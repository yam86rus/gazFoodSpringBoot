package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.ReceptRepository;
import com.gazfood.gazfoodspringboot.entity.Recept;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.awt.SystemColor.text;

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
        if (optional.isPresent()) {
            recept = optional.get();
        }
        return recept;
    }

    @Override
    public void deleteRecept(int id) {
        receptRepository.deleteById(id);
    }

    @Override
    public void checkAct() {
        // Определяем каталог в котором лежат акты
        String myPath = "C:/demo/";
        File filePath = new File(myPath);

        // Получаем список всех файлов в этом каталоге
        List<File> list1 = Arrays.stream(filePath.listFiles()).collect(Collectors.toList());

        // List для хранения только xls файлов
        List<File> list2 = new ArrayList<>();

        // Проверяем расширение файлов и заполняем
        for (int i = 0; i < list1.size(); i++) {
            String fileName = list1.get(i).getName();
            if (fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).equals("xls")) {
                list2.add(list1.get(i));
            } else {
                System.out.println("не xls");
            }
        }

        // Сюда будем записывать данные для отчета о выполненных операциях
        List<String> reportList = new ArrayList<>();

        // Для каждого файла осуществляем обработку Акта
        for (File fileName : list2) {



            System.out.println("Начата обработка актов для файла " + fileName.getName());
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


            File file = new File(fileName.getPath());

            // Читаем xls файл
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            // Получаем workbook
            HSSFWorkbook workbook = null;
            try {
                workbook = new HSSFWorkbook(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

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
//                            System.out.print("");
//                            System.out.print("\t");
                            break;
                        case BOOLEAN:
//                            System.out.print(cell.getBooleanCellValue());
//                            System.out.print("\t");
                            break;
                        case BLANK:
//                            System.out.print("");
//                            System.out.print("\t");
                            break;
                        case FORMULA:
                            // Если есть формула
//                        System.out.print(cell.getCellFormula());
//                            System.out.print("\t");

//                            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                            // Печать значения из формулы
//                            System.out.print(evaluator.evaluate(cell).getNumberValue());
                            break;

                        case STRING:
//                            System.out.print(cell.getStringCellValue());
//                            System.out.print("\t");
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
                                endRow = cell.getRowIndex() + 1;
                            }


//
                            break;
                        case NUMERIC:
//                            System.out.print(cell.getNumericCellValue());
//                            System.out.print("\t");

                            // ищем старт
                            if (cell.getColumnIndex() == numbersNameColumnIndex & startRow == 0) {
                                startRow = cell.getRowIndex() + 1;
                            }

                            break;
                        case ERROR:
//                            System.out.print("!");
//                            System.out.print("\t");
                            break;
                    }

                }
//                System.out.println("");
            }

            Cell cell = null;
            for (int i = startRow; i < endRow - 1; i++) {
//            System.out.println(sheet.getRow(i).getCell(priceNameColumnIndex));
                cell = sheet.getRow(i).getCell(priceNameColumnIndex);
                cell.setCellValue(123);
            }

            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Записываем файл
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                reportList.add(fileName.getName() + " ошибка " + e);
            }

            try {
                workbook.write(out);
                reportList.add(fileName.getName() + " успешно обработан");
            } catch (IOException e) {
                reportList.add(fileName.getName() + " ошибка " + e);
            }

            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Закончена обработка актов " + fileName.getName());
        }

        System.out.println(reportList);

        File fileReporTxt = new File(myPath + "Отчет.txt");

        // Создание файла
        try {
            fileReporTxt.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Создание объекта FileWriter
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileReporTxt);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Запись содержимого в файл
        for (String str: reportList){
            try {
                writer.write(str +"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        try {
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
