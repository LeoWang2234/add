package com.ecust.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by cheng on 2018/4/10.
 */
public interface UploadService {
     boolean praseExcel(String name,MultipartFile file);
}
