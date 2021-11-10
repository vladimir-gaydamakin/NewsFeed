package com.dataart.vgaydamakin.finalproject.service;

import com.dataart.vgaydamakin.finalproject.entity.News;
import com.dataart.vgaydamakin.finalproject.exceptions.InvalidZipContentException;
import com.dataart.vgaydamakin.finalproject.repository.MainRepository;
import com.dataart.vgaydamakin.finalproject.utility.ZipFileHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    public News addArticle(MultipartFile input) {
        ZipFile inputZip = null;
        try {
            inputZip = new ZipFile(zipFileHandler.convertToZip(input));
            if (!zipFileHandler.zipIsValid(inputZip)) {
                throw new InvalidZipContentException("ZIP must contain only article.txt file!!!");
            }
            return mainRepository.save(zipFileHandler.getArticleFromZip(inputZip));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            zipFileHandler.deleteFile(input.getOriginalFilename());
        }
        return null;
    }


}
