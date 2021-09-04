package com.devdezyn.mollysclub.appointment;
// package io.devdezyn.devlearnrest.student;

// import static org.assertj.core.api.Assertions.assertThat;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

// import org.junit.Before;
// import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
// import org.mockito.MockitoAnnotations;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;
// import org.springframework.test.context.junit4.SpringRunner;


// @RunWith(SpringRunner.class)
// @DataJpaTest
// public class StudentControllerIT {
//   StudentService studentService;

//   @Autowired
//   StudentRepository studentRepository;
    
//   StudentController studentController;

//   MockMvc mockMvc;

//   @Before
//   public void setUp() throws Exception {
//     MockitoAnnotations.openMocks(this);

//     mockMvc = MockMvcBuilders.standaloneSetup(studentController)
//         // .setControllerAdvice(new ControllerExceptionHandler())
//         .build();
//   }

//   @Test
//   public void givenEmployees_whenGetEmployees_thenStatus200()
//     throws Exception {

//       createTestStudent("bob");

//       mockMvc.perform(get("/api/employees")
//         .contentType(MediaType.APPLICATION_JSON))
//         .andExpect(status().isOk())
//         .andExpect(content()
//               .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//         // .andExpect(jsonPath("$[0].name", is("bob")));
//   }

//   private void createTestStudent(String string) {
//     Student student = new Student();

//     studentRepository.save(student);
//   }
  
//   // @Test
// 	// public void contextLoads() throws Exception {
// 	// 	assertThat(studentController).isNotNull();
// 	// }
// }
