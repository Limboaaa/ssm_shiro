package com.qf.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * Created by DELL on 2019/8/7.
 */
@Controller
@RequestMapping("fileUpAndDown")
public class FileUpLoadController {

    @RequestMapping("fileUploadController")
    @ResponseBody
    public String fileUploadController(@RequestParam("file") CommonsMultipartFile file) throws Exception {
        //1.创建一个新文件
        File destFile = new File("D:\\" + new Date().getTime() + file.getOriginalFilename());

        //2.将file中的内容通过transferTo方法保存到新文件中
        file.transferTo(destFile);
//        if(true){
//
//            throw new Exception("人为异常");
//        }
//        FileInputStream is;
        return "upload success";
    }


    @RequestMapping("testDownLoad")
    public ResponseEntity<byte[]> testDownLoad(@RequestParam(required = false,value = "fileName")String fileName) throws IOException {
        File srcFile = new File("d://"+fileName);
        if(!srcFile.exists()){
            throw new FileNotFoundException("无法找到文件"+srcFile.getAbsolutePath());
        }
        FileInputStream fis = new FileInputStream(srcFile);
        byte[] destByteArray = new byte[fis.available()];
        //?
        fis.read(destByteArray);
        //定义一个响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename="+fileName);
        //设置响应状态
        int status = 200;
        HttpStatus statusCode = HttpStatus.OK;

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(destByteArray, headers, statusCode);

        return responseEntity;
    }
}