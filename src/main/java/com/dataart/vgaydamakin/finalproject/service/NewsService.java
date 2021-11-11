package com.dataart.vgaydamakin.finalproject.service;

import com.dataart.vgaydamakin.finalproject.entity.News;
import com.dataart.vgaydamakin.finalproject.exceptions.InvalidZipContentException;
import com.dataart.vgaydamakin.finalproject.exceptions.NotAZipFileException;
import com.dataart.vgaydamakin.finalproject.repository.MainRepository;
import com.dataart.vgaydamakin.finalproject.utility.ZipFileHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipFile;


@Service
@RequiredArgsConstructor
public class NewsService {
    private final MainRepository mainRepository;
    private final ZipFileHandler zipFileHandler;

    public List<News> getNews() {
        return mainRepository.findAll();
    }

    public News addArticle(File input) {
        ZipFile inputZip = null;
        try {
            if (!zipFileHandler.isZipFile(input)) {
                throw new NotAZipFileException("FILE IS NOT A ZIP !!!!!!");
            }
            ZipFile zip = new ZipFile(input);
            if (!zipFileHandler.zipIsValid(zip)) {
                throw new InvalidZipContentException("ZIP must contain only article.txt file!!!");
            }
            mainRepository.save(zipFileHandler.getArticleFromZip(zip));
        } catch (IOException e) {
            e.printStackTrace();
        } //finally {
          //  zipFileHandler.deleteFile(input.getOriginalFilename());
      //  }
        return null;
    }


}
