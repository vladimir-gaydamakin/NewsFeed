package com.dataart.vgaydamakin.finalproject.controller;

import com.dataart.vgaydamakin.finalproject.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/upload")
@RequiredArgsConstructor
public class FileUploadController {

    private final NewsService newsService;

    @PostMapping("")
    public ResponseEntity<?> addArticle(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(newsService.addArticle(file));
    }
}