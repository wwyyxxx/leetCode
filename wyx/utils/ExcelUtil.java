/*
 * @Author: Tungbo
 * @Date: 2024-04-08 14:34:56
 * @LastEditTime: 2024-04-09 14:36:24
 * @LastEditors: Tungbo
 * @Description: leecode: 
 */
package wyx.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.StringUtil;

import wyx.bean.ImeiChange;
import wyx.bean.ImeiChangeBean;

public class ExcelUtil {

    public static void handleExcel() {
        // Specify the path to your Excel file
        String excelFilePath1 = "wyx/assets/386626880_199004.xls";
        String excelFilePath2 = "wyx/assets/386632962_39A50E.xls";
        List<ImeiChangeBean> list = new ArrayList<>();
        int initFalse = 0;
        int false2Ture = 0;
        int false2false = 0;
        Gson gson = new Gson();
        Map<String, Integer> dicKeep = new HashMap<>();
        Map<String, Integer> dicChange = new HashMap<>();

        Map<String, Integer> dicKeepType = new HashMap<>();
        Map<String, Integer> dicChangeType = new HashMap<>();

        try (FileInputStream fis = new FileInputStream(new File(excelFilePath2));
                Workbook workbook = WorkbookFactory.create(fis)) {

            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);
            int i = 0;
            // Iterate over rows
            for (Row row : sheet) {
                if (i++ == 0) {
                    continue;
                }
                // Iterate over cells
                List<ImeiChange> tempList = gson.fromJson(row.getCell(2).toString(), new TypeToken<List<ImeiChange>>() {
                }.getType());

                ImeiChangeBean temp = new ImeiChangeBean(row.getCell(0).toString(), row.getCell(1).toString(),
                        tempList,
                        row.getCell(3).toString(), row.getCell(4).toString(),
                        row.getCell(5).toString());

                if (tempList.get(0).getValidate() == false) {
                    initFalse++;
                    String type = tempList.get(0).getType();
                    if (tempList.get(tempList.size() - 1).getValidate() == true) {
                        false2Ture++;
                        // System.err.println("flag: "+Arrays.toString(tempList.toArray()));
                        dicChange.put(temp.getBrand(), dicChange.getOrDefault(temp.getBrand(), 0) + 1);
                        dicChangeType.put(type, dicChangeType.getOrDefault(type, 0) + 1);
                        list.add(temp);
                    } else {
                        if (tempList.size()>1 && tempList.get(0).getImei().equals(tempList.get(tempList.size() - 1).getImei())) {
                            false2false++;
                        }
                        dicKeep.put(temp.getBrand(), dicKeep.getOrDefault(temp.getBrand(), 0) + 1);
                        dicKeepType.put(type, dicKeepType.getOrDefault(type, 0) + 1);
                    }
                }
                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("initFalse:" + initFalse + ", false2Ture:" + false2Ture + ", false2false:" + false2false + ", total:" + list.size());
        System.out.println("修改的机型:" + gson.toJson(dicChange));
        System.out.println("未修改的机型:" + gson.toJson(dicKeep));
        System.out.println("修改的识别:" + gson.toJson(dicChangeType));
        System.out.println("未修改的识别:" + gson.toJson(dicKeepType));
        long fileName = System.currentTimeMillis();
        // compareAndOutputToExcel(list, "wyx/assets/"+ fileName +".xls");
    }

    public static void compareAndOutputToExcel(List<ImeiChangeBean> list, String outputFile) {
        try {
            Workbook workbook = WorkbookFactory.create(false);
            Sheet sheet = workbook.createSheet("Diff");
            CreationHelper helper = workbook.getCreationHelper();
            Drawing<?> drawing = sheet.createDrawingPatriarch();

            Font redFont = workbook.createFont();
            redFont.setColor(IndexedColors.RED.getIndex());

            int rowNum = 0;
            Row row = sheet.createRow(rowNum++);
            Cell cell = row.createCell(0);
            cell.setCellValue("First");
            cell = row.createCell(1);
            cell.setCellValue("Last");
            cell = row.createCell(2);
            cell.setCellValue("Differences");
            cell = row.createCell(3);
            cell.setCellValue("Type");
            cell = row.createCell(4);
            cell.setCellValue("QcCode");
            cell = row.createCell(5);
            cell.setCellValue("Reason");

            for (int i = 0; i < list.size(); i++) {
                List<ImeiChange> changeList = list.get(i).getChangeList();
                if (changeList.size() < 2) {
                    continue;
                }

                String fristImei = changeList.get(0).getImei();
                String lastImei = changeList.get(changeList.size() - 1).getImei();
                HSSFRichTextString richText = new HSSFRichTextString(fristImei);
                for (int j = 0; j < fristImei.length() && j < lastImei.length(); j++) {
                    if (fristImei.charAt(j) != lastImei.charAt(j)) {
                        richText.applyFont(j, j + 1, redFont);
                    }
                }
                row = sheet.createRow(rowNum++);
                cell = row.createCell(0);
                cell.setCellValue(fristImei);
                cell = row.createCell(1);
                cell.setCellValue(lastImei);
                cell = row.createCell(2);
                cell.setCellValue(richText);
                cell = row.createCell(3);
                cell.setCellValue(changeList.get(0).getType());
                cell = row.createCell(4);
                cell.setCellValue(list.get(i).getQcCode());
                cell = row.createCell(5);
                cell.setCellValue(StringUtil.isBlank(fristImei) ? "empty" : 
                    fristImei.trim().equals(lastImei) ? "notTrim" : 
                    fristImei.substring(6).equals(lastImei) ? "imei1:" : 
                    (fristImei.length() != lastImei.length()) ? "length" : "UnKonw");
            }

            FileOutputStream fileOut = new FileOutputStream(outputFile);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
