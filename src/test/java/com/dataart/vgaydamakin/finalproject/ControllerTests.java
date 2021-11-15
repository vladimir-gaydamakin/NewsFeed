package com.dataart.vgaydamakin.finalproject;

import com.dataart.vgaydamakin.finalproject.controller.ExceptionHandlerController;
import com.dataart.vgaydamakin.finalproject.controller.FileUploadController;
import com.dataart.vgaydamakin.finalproject.controller.NewsController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ControllerTests {

    private final String PATH_TO_TESTFILES = File.separator + "src" + File.separator
            + "test" + File.separator + "resources" + File.separator;
    @Autowired
    private NewsController newsController;

    @Autowired
    private FileUploadController fileUploadController;

    @Autowired
    private ExceptionHandlerController exceptionHandlerController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        assertThat(newsController).isNotNull();
        assertThat(fileUploadController).isNotNull();
        assertThat(exceptionHandlerController).isNotNull();

    }

    @Test
    public void testNewsController() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

//@Test
//public void testUploadController() throws Exception {
//	File dir = new File("");
//	File zip = new File(dir.getAbsolutePath() + PATH_TO_TESTFILES + "validZip.zip");
//	InputStream fileStream = new FileInputStream(zip);
//	var file = new MockMultipartFile("validZip.zip",fileStream);
//	this.mockMvc.perform(multipart("/upload").file(file))
//			.andDo(print())
//			.andExpect(status().isOk());
//}

}