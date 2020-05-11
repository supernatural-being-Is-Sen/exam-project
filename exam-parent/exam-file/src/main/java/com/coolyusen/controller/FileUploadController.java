package com.coolyusen.controller;

import com.coolyusen.exam.common.Dto;
import com.coolyusen.exam.common.DtoUtil;
import com.coolyusen.exam.utils.Constants;
import com.coolyusen.file.FastDfsFile;
import com.coolyusen.util.FastDfsUtil;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 吴雨森
 * @data 2020/1/20
 */
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    private FastDfsUtil fastDfsUtil;

    /**
     * 文件上传
     * @return
     */
    @PostMapping
    public Dto upload(@RequestParam("file") MultipartFile file) throws IOException, MyException {
        FastDfsFile fastDfsFile = new FastDfsFile(
                file.getOriginalFilename(),
                file.getBytes(),
                StringUtils.getFilenameExtension(file.getOriginalFilename())
        );
        //调用FastDfs工具类
        String[] uploads = this.fastDfsUtil.upload(fastDfsFile);
        return DtoUtil.returnSuccess(Constants.CommonCode.SUCCESS,
                "http://118.25.144.199:8888/" + uploads[0] + "/" + uploads[1]);
    }
}
