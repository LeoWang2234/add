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
        //��һ���ж��ļ��Ƿ�Ϊ�գ����ж����С�Ƿ�Ϊ0���������Ƿ�Ϊnull��
        long size = file.getSize();
        if (name == null || ("").equals(name) && size == 0) {
            return returntoUser(request, "�ϴ����ļ�Ϊ�գ�");
        }

//        �ϴ��ļ����أ���������ϴ��ļ���С   10M=10*1024*1024(B)=10485760 bytes
        if (size > 10485760){
            return returntoUser(request, "�ϴ����ļ����ܳ��� 10M ��");
        }

        if (!WDWUtil.isExcel2003(name) && !WDWUtil.isExcel2007(name)){
            return returntoUser(request, "�ļ���ʽ����ȷ��");
        }
        //�������롣�������ļ������ļ���
        boolean b = uploadService.praseExcel(name, file);
        if (b) {
            return returntoUser(request, name + "����ʧ�ܣ�");
        } else {
            return returntoUser(request, name + "����ɹ���");
        }
    }
    private String returntoUser(HttpServletRequest request,String message){
        String Msg = message;
        request.getSession().setAttribute("msg", Msg);
        return "../../upload";
    }

}
