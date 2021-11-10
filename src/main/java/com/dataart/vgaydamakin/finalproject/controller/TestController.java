package com.dataart.vgaydamakin.finalproject.controller;

import com.dataart.vgaydamakin.finalproject.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private NewsService newsService;

    @GetMapping("")
    public ResponseEntity<?> addArticle(@RequestParam("file") MultipartFile file, String theme) {
        System.out.println("YA TYT NAKONEC !! !!!!!!!!");
        return ResponseEntity.ok(newsService.addArticle(file));
    }
}
