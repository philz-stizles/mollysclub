// package com.devdezyn.mollysclub.document_upload;

// import java.nio.file.Paths;
// import java.util.stream.Stream;

// import com.devdezyn.mollysclub.AbstractTest;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// import org.hamcrest.Matchers;
// import org.junit.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.mock.web.MockMultipartFile;

// @AutoConfigureMockMvc
// @SpringBootTest
// public class UploadControllerTest extends AbstractTest {

// 	@MockBean
// 	private UploadService uploadService;

// 	@Test
// 	public void shouldListAllFiles() throws Exception {
// 		given(uploadService.loadAll())
// 				.willReturn(Stream.of(Paths.get("first.txt"), Paths.get("second.txt")));

// 		mockMvc.perform(get("/")).andExpect(status().isOk())
// 				.andExpect(model().attribute("files",
// 						Matchers.contains("http://localhost/files/first.txt",
// 								"http://localhost/files/second.txt")));
// 	}

// 	@Test
// 	public void shouldSaveUploadedFile() throws Exception {
// 		MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt",
// 				"text/plain", "Spring Framework".getBytes());
// 		mockMvc.perform(multipart("/").file(multipartFile))
// 				.andExpect(status().isFound())
// 				.andExpect(header().string("Location", "/"));

// 		then(uploadService).should().store(multipartFile);
// 	}

// 	@SuppressWarnings("unchecked")
// 	@Test
// 	public void should404WhenMissingFile() throws Exception {
// 		given(uploadService.loadAsResource("test.txt"))
// 				.willThrow(StorageFileNotFoundException.class);

// 		mockMvc.perform(get("/files/test.txt")).andExpect(status().isNotFound());
// 	}

// }