/*
 * @Author: Tungbo
 * @Date: 2024-04-08 14:34:56
 * @LastEditTime: 2024-12-05 15:59:30
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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.poi.hssf.usermodel.HSSFPictureData;
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
import org.apache.poi.xssf.usermodel.XSSFPictureData;

import wyx.TestUtil;
import wyx.bean.ImeiChange;
import wyx.bean.ImeiChangeBean;

public class ExcelUtil {


    //excel表格数据获取
    public static void handleExcel() {
        // Specify the path to your Excel file
        String excelFilePath1 = "wyx/assets/386626880_199004.xlsx";
        String excelFilePath2 = "wyx/assets/386632962_39A50E.xlsx";
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
                        if (tempList.size() > 1
                                && tempList.get(0).getImei().equals(tempList.get(tempList.size() - 1).getImei())) {
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

        System.out.println("initFalse:" + initFalse + ", false2Ture:" + false2Ture + ", false2false:" + false2false
                + ", total:" + list.size());
        System.out.println("修改的机型:" + gson.toJson(dicChange));
        System.out.println("未修改的机型:" + gson.toJson(dicKeep));
        System.out.println("修改的识别:" + gson.toJson(dicChangeType));
        System.out.println("未修改的识别:" + gson.toJson(dicKeepType));
        long fileName = System.currentTimeMillis();
        compareAndOutputToExcel(list, "wyx/assets/" + fileName + ".xls");
    }

    //比较excel单元格数据差异并标红
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
                cell.setCellValue(StringUtil.isBlank(fristImei) ? "empty"
                        : fristImei.trim().equals(lastImei) ? "notTrim"
                                : fristImei.substring(6).equals(lastImei) ? "imei1:"
                                        : (fristImei.length() != lastImei.length()) ? "length" : "UnKonw");
            }

            FileOutputStream fileOut = new FileOutputStream(outputFile);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //imei校验
    public static void vaildImei() {
        String str = "wyx/assets/ocrData.xls";
        try (FileInputStream fis = new FileInputStream(new File(str));

            Workbook workbook = WorkbookFactory.create(fis)) {
            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(1);
            // Iterate over rows
            for (Row row : sheet) {
                // Iterate over cells
                Cell imeiCell = row.getCell(1); // 假设IMEI在第一列
                if (imeiCell != null) {
                    String imei = imeiCell.getStringCellValue();
                    boolean isValid = TestUtil.vaildImei(imei);
                    // 输出结果到最后一列
                    Cell resultCell = row.createCell(row.getLastCellNum());
                    resultCell.setCellValue(isValid);
                }
            }

            // 写入新的Excel文件
            try (FileOutputStream fos = new FileOutputStream("wyx/assets/" + System.currentTimeMillis() + ".xls")) {
                workbook.write(fos);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取工作表中的所有图片
    public static void handlePicture(){
        String str = "wyx/assets/ocrData.xls";
        try (FileInputStream fis = new FileInputStream(new File(str));

            Workbook workbook = WorkbookFactory.create(fis)) {
            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(1);
            // 获取工作表中的所有图片
            List<HSSFPictureData> pictures = (List<HSSFPictureData>) workbook.getAllPictures();
            int pictureIndex = 0;

            for (HSSFPictureData pictureData : pictures) {
                // 获取图片的字节数据
                byte[] imageBytes = pictureData.getData();

                // 获取图片格式
                String extension = pictureData.suggestFileExtension();
                String imagePath = "wyx/assets/images/image_" + 1 + "_" + pictureIndex + "." + extension;

                // 保存图片文件
                try (FileOutputStream fos = new FileOutputStream(imagePath)) {
                    fos.write(imageBytes);
                    System.out.println("Image saved at: " + imagePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                pictureIndex++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void calculateImeiSn(){
        String str = "wyx/assets/476683010_B5DCBF_imei来源.xlsx";
        try (FileInputStream fis = new FileInputStream(new File(str));

            Workbook workbook = WorkbookFactory.create(fis)) {
            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                // Iterate over cells
                Cell imeiCell = row.getCell(1); // 假设IMEI在第一列
                String onlineimei = imeiCell.getStringCellValue();
                boolean isValid = TestUtil.vaildImei(onlineimei);
                // 输出结果到最后一列
                Cell resultCell = row.createCell(row.getLastCellNum());
                resultCell.setCellValue(isValid);
            }

            // 写入新的Excel文件
            try (FileOutputStream fos = new FileOutputStream("wyx/assets/" + System.currentTimeMillis() + ".xlsx")) {
                workbook.write(fos);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void compareWebApi(){
        String str = "wyx/assets/转转WebViewAPI.xlsx";
        Set<String> set = new HashSet<>();
        try (FileInputStream fis = new FileInputStream(new File(str));
            
            Workbook workbook = WorkbookFactory.create(fis)) {
            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell api = row.getCell(0);
                set.add(api.getStringCellValue());
            }

            sheet = workbook.getSheetAt(2);
            for (Row row : sheet) {
                Cell api = row.getCell(0);
                // 输出结果到最后一列
                Cell resultCell = row.createCell(row.getLastCellNum());
                resultCell.setCellValue(set.contains(api.getStringCellValue()));
            }

            // 写入新的Excel文件
            try (FileOutputStream fos = new FileOutputStream("wyx/assets/" + System.currentTimeMillis() + ".xlsx")) {
                workbook.write(fos);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
