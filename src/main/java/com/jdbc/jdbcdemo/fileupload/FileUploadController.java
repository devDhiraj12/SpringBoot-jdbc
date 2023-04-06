package com.jdbc.jdbcdemo.fileupload;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLConnection;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String uploadFile(@RequestParam MultipartFile multipartFile) throws IOException {
        String fileName=multipartFile.getOriginalFilename();
        File f=new File("D:\\images\\"+fileName);
        multipartFile.transferTo(f);
        return "File uploaded!!!";
    }
    private  static  final String EXTERNAL_FILE_PATH = "D:\\images\\";

    @RequestMapping("/file/{fileName}")
    public void downloadPdfResources(HttpServletRequest request, HttpServletResponse response, @PathVariable("fileName") String fileName)
        throws IOException {
        File file = new File(EXTERNAL_FILE_PATH + fileName);
        if (file.exists()){

            //get the mimeType
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null){
                //unknown mimetype so set to mimetype to application/octet-stream
                mimeType = "application/octet-stream";
            }
            response.setContentType(mimeType);
            response.setHeader("Content-Disposition", String.format("inline; filename=\""+ file.getName()+"\""));
            response.setContentLength((int) file.length());

            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        }
    }
}
