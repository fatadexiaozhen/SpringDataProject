package com.imooc.Controller;

import com.imooc.domain.LayuiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
//直接return对象，前台收到JSON
@ResponseBody
public class appsController {
    //发现在使用bootstrapfileinput的多文件上传插件和layui的多文件上传插件的原理都是每次传一个文件，多个文件会访问多次，所以java的MultipartFile也不必用数组接收。
    @RequestMapping("upload")
    public LayuiResponse upload4Check(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) throws Exception {
        LayuiResponse layuiResponse = new LayuiResponse();
        try {
            String fname = file.getOriginalFilename().toLowerCase();
            String suffix = "";
            if (fname.lastIndexOf(".") > 1) {
                suffix = fname.substring(fname.lastIndexOf(".") + 1);
            }
            if ("shx".equals(suffix) ||
                    "prj".equals(suffix) ||
                    "shp".equals(suffix) ||
                    "dbf".equals(suffix)) {
                //保存文件
                String fileName = System.currentTimeMillis() + "_" + fname;
                fileSave(fileName)

            } else {
                layuiResponse.setCount(-1);
                layuiResponse.setMsg("文件格式不支持");
                layuiResponse.setFilepath("");
                return layuiResponse;
            }
        } catch (Exception e) {
            layuiResponse.setCount(-1);
            layuiResponse.setMsg("上传失败");
            layuiResponse.setFilepath("");
            return layuiResponse;
        }
    }

    @RequestMapping(value="uploads")
    @ResponseBody
    public String uploads(
            @RequestParam("file")MultipartFile sortPicImg,
            @RequestParam("cate")String cate,
            HttpServletRequest request) {

                String objectName = cate + "/" + fileName;

                //获取流长度
                long contentLength = sortPicImg.getSize();

                SiteSettings settings = getSiteSettings(request);

                fileStorage.save( objectName, contentLength, sortPicImg.getInputStream(), settings );

                String fileUrl = "http://" + settings.getOssOuterDomain() + "/" + cate + "/" + fileName;


