package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;

@Controller
public class FileController {

    // @RequestParam("file") 将 name = file 控件得到的文件封装成 CommonsMultipartFile 对象
    // 批量上传 CommonsMultipartFile 该为数组即可
    @RequestMapping("/upload")
    public String upload(@RequestParam("file")CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        // 获取文件名
        String uploadFileName = file.getOriginalFilename();

        // 如果文件名为空，直接回到首页
        if (uploadFileName == null || uploadFileName.isEmpty()) {
            return "redirect:/index.jsp";
        }

        System.out.println("上传文件名：" + uploadFileName);

        // 上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        // 如果路径不存在，创建一个
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdirs();
        }

        System.out.println("上传文件保存地址：" + realPath);

        // 使用 try-with-resources 自动关闭输入和输出流
        try (InputStream is = file.getInputStream();
             OutputStream os = Files.newOutputStream(new File(realPath, uploadFileName).toPath())) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        }

        return "redirect:/index.jsp";
    }

}
