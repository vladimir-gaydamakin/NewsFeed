package com.dataart.vgaydamakin.finalproject;

import com.dataart.vgaydamakin.finalproject.utility.ZipFileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ZipHandlerTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ZipFileHandler zipFileHandler;

//@Test
//public void () throws Exception {
//	
//}

}
