package com.jdbc.jdbcdemo.fileupload;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String uploadFile(@RequestParam MultipartFile multipartFile) throws IOException {
        String fileName=multipartFile.getOriginalFilename();
        File f=new File("D:\\images\\"+fileName);
        multipartFile.transferTo(f);
        return "File uploaded!!!";
    }
}
