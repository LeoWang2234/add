package com.ecust.controller;

import com.ecust.service.UploadService;
import com.ecust.utils.WDWUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cheng on 2018/4/10.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = "/uploadExcel", method = RequestMethod.POST)
    public String batchimport(@RequestParam(value = "filename") MultipartFile file,
                              HttpServletRequest request, HttpServletResponse response) throws IOException {
//        log.info("AddController ..batchimport() start");
        String name = file.getOriginalFilename();
        //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
        long size = file.getSize();
        if (name == null || ("").equals(name) && size == 0) {
            return returntoUser(request, "上传的文件为空！");
        }

//        上传文件拦截，设置最大上传文件大小   10M=10*1024*1024(B)=10485760 bytes
        if (size > 10485760){
            return returntoUser(request, "上传的文件不能超过 10M ！");
        }

        if (!WDWUtil.isExcel2003(name) && !WDWUtil.isExcel2007(name)){
            return returntoUser(request, "文件格式不正确！");
        }
        //批量导入。参数：文件名，文件。
        boolean b = uploadService.praseExcel(name, file);
        if (b) {
            return returntoUser(request, name + "导入失败！");
        } else {
            return returntoUser(request, name + "导入成功！");
        }
    }
    private String returntoUser(HttpServletRequest request,String message){
        String Msg = message;
        request.getSession().setAttribute("msg", Msg);
        return "../../upload";
    }

}
