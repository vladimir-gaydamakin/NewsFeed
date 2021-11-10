package com.dataart.vgaydamakin.finalproject.utility;

import com.dataart.vgaydamakin.finalproject.entity.News;
import com.dataart.vgaydamakin.finalproject.exceptions.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Component
public class ZipFileHandler {

    public File convertToZip(MultipartFile input) throws IOException {
        if (input != null && !input.isEmpty()) {
            File temp = new File(input.getOriginalFilename());
            input.transferTo(temp);
            if (!isZipFile(temp)) {
                throw new NotAZipFileException("FILE IS NOT A ZIP !!!!!!");
            }
            return temp;
        }
        throw new MyFileNotFoundException("FILE NOT EXISTS OR EMPTY");
    }

    public boolean zipIsValid(ZipFile input) {
        int count = 0;
        boolean isArticle = false;
        Iterator<? extends ZipEntry> entries = input.stream().iterator();
        while (entries.hasNext() && count < 2) {
            ZipEntry entry = entries.next();
            if (entry.getName().endsWith("article.txt")) {
                isArticle = true;
            }
            count++;
        }
        return isArticle && count == 1;
    }

    public News getArticleFromZip(ZipFile input) {
        Iterator<? extends ZipEntry> entries = input.stream().iterator();
        while (entries.hasNext()) {
            ZipEntry entry = entries.next();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(input.getInputStream(entry)))) {
                String header = br.readLine();
                StringBuilder content = new StringBuilder();
                String temp;
                while ((temp = br.readLine()) != null) {
                    content.append(temp);
                }
                if (header.isEmpty() || content.equals("")) {
                    throw new ArticleFormatException("Article must contain header and content !!!!");
                }
                return new News(header, content.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean isZipFile(File file) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        return raf.readInt() == 0x504B0304;
    }

    public void deleteFile(String path) {
        File file = new File(path);
        if (file != null && Files.exists(Path.of(file.getPath()))) {
            try {
                Files.delete(Path.of(file.getPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
