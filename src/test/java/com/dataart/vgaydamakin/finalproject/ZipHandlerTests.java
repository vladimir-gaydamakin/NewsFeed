package com.dataart.vgaydamakin.finalproject;

import com.dataart.vgaydamakin.finalproject.utility.ZipFileHandler;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class ZipHandlerTests {

    @Autowired
    private ZipFileHandler zipFileHandler;

    @Test
    public void contextLoads() throws Exception {
        assertThat(zipFileHandler).isNotNull();
    }

}
