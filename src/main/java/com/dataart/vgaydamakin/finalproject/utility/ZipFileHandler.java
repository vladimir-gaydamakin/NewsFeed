package com.dataart.vgaydamakin.finalproject.utility;

import com.dataart.vgaydamakin.finalproject.entity.News;
import com.dataart.vgaydamakin.finalproject.exceptions.ArticleFormatException;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Component
public class ZipFileHandler {

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

    public News getArticleFromZip(ZipFile input) throws IOException {
        Iterator<? extends ZipEntry> entries = input.stream().iterator();
        while (entries.hasNext()) {
            ZipEntry entry = entries.next();
            BufferedReader br = new BufferedReader(new InputStreamReader(input.getInputStream(entry)));
            String header = br.readLine();
            StringBuilder content = new StringBuilder();
            String temp;
            while ((temp = br.readLine()) != null) {
                content.append(temp);
            }
            if (header.isEmpty() || content.equals("")) {
                throw new ArticleFormatException("Article must contain header and content !!!!");
            }
            input.close();
            return new News(header, content.toString());
        }
        return null;
    }

    public boolean isZipFile(File file) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        return raf.readInt() == 0x504B0304;
    }
}
