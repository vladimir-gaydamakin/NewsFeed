package com.dataart.vgaydamakin.finalproject;

import com.dataart.vgaydamakin.finalproject.controller.ExceptionHandlerController;
import com.dataart.vgaydamakin.finalproject.controller.FileUploadController;
import com.dataart.vgaydamakin.finalproject.controller.NewsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTests {

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

	@Test
	public void testUploadController(String filename) throws Exception {
		//String origin = getClass().getClassLoader().getResource(filename).getPath();
		//MultipartFile testfile = new MockMultipartFile(origin, filename, "zip" ,new FileInputStream(origin));
		this.mockMvc.perform(post(""))
				.andDo(print())
				.andExpect(status().isOk());
	}
}
