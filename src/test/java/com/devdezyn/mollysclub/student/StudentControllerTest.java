// package io.devdezyn.devlearnrest.student;

// import static org.assertj.core.api.Assertions.assertThat;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// public class StudentControllerTest {
//   @Mock
//   private StudentService studentService;

//   @InjectMocks
//   private StudentController studentController;

//   private MockMvc mockMvc;

//   @BeforeEach
//   public void setUp() {
//     MockitoAnnotations.openMocks(this);

//     mockMvc = MockMvcBuilders.standaloneSetup(studentController)
//         // .setControllerAdvice(new ControllerExceptionHandler())
//         .build();
//   }
  
//   // @Test
// 	// public void contextLoads() throws Exception {
// 	// 	assertThat(studentController).isNotNull();
// 	// }
// }
