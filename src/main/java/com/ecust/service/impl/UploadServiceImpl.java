package com.ecust.service.impl;

import com.ecust.service.UploadService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by cheng on 2018/4/10.
 */
@Service("uploadService")
public class UploadServiceImpl implements UploadService {

    public boolean praseExcel(String name, MultipartFile file) {
        boolean b = false;

        HSSFWorkbook wb = null;
        try {
            wb = new HSSFWorkbook(file.getInputStream());
            // logger.debug(wb.getNumberOfSheets());
            HSSFSheet sheet = wb.getSheetAt(0);
            for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
                HSSFRow row = sheet.getRow(i);
                Iterator cells = row.cellIterator();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    cell.setCellType(CellType.STRING);
                    System.out.println(cell.getStringCellValue());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }
}