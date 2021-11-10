package com.dataart.vgaydamakin.finalproject.controller;

import com.dataart.vgaydamakin.finalproject.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

  @GetMapping("/")
  public ResponseEntity<?> getNews() {
      return ResponseEntity.ok(newsService.getNews());
  }

//  @GetMapping("/")
//  public List<News> getNews() {
//     // newsService.addNews(new News(666, "NEWHEADER", "FINALLLYY"));
//      return newsService.getNews();
//  }
}
