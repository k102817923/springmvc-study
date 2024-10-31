package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
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
        String path = request.getSession().getServletContext().getRealPath("/upload");
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

    @RequestMapping("/upload/v2")
    public String upload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        // 上传路径保存设置
        String path = request.getSession().getServletContext().getRealPath("/upload");
        // 如果路径不存在，创建一个
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdirs();
        }

        System.out.println("上传文件保存地址：" + realPath);

        // 通过 CommonsMultipartFile 的方法直接写文件
        file.transferTo(new File(realPath + "/" + file.getOriginalFilename()));
        return "redirect:/index.jsp";
    }

    @RequestMapping("/download")
    public String download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 要下载的图片地址
        String path = request.getSession().getServletContext().getRealPath("/upload");
        String fileName = "基础语法.jpg";
        File file = new File(path, fileName);

        // 确保文件存在
        if (!file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }

        // 设置 response 响应头
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));

        // 建议使用 try-with-resources 来自动关闭流，或者至少在 finally 块中关闭它们，以避免潜在的资源泄漏
        try (InputStream input = Files.newInputStream(file.toPath());
             OutputStream out = response.getOutputStream()) {

            byte[] buff = new byte[1024];
            int index;
            while ((index = input.read(buff)) != -1) {
                out.write(buff, 0, index);
            }
        }

        return null;
    }

}
