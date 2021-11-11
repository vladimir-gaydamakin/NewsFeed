package com.dataart.vgaydamakin.finalproject.controller;

import com.dataart.vgaydamakin.finalproject.exceptions.MyFileNotFoundException;
import com.dataart.vgaydamakin.finalproject.repository.MainRepository;
import com.dataart.vgaydamakin.finalproject.service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
@RequestMapping("/upload")
@AllArgsConstructor
public class FileUploadController {
    private NewsService newsService;
    private MainRepository mainRepository;


    @PostMapping
    public ResponseEntity testUpload(@RequestParam("file") MultipartFile input) throws IOException {
        if (input != null && !input.isEmpty()) {
            File temp = new File(File.separator + "temp.zip");
            input.transferTo(temp);
            newsService.addArticle(temp);
            return ResponseEntity.ok("GOOD");
        }
        throw new MyFileNotFoundException("FILE NOT EXISTS OR EMPTY");
    }

}
