package com.devdezyn.mollysclub.cloud_docs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(tags = "Cloud Documents")
@RestController
@RequestMapping(path = "/api/v1/uploads")
@RequiredArgsConstructor
public class UploadController {

    private final UploadService uploadService;

    // Single file upload
    @PostMapping(path = "/single", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadSingleFile(@RequestParam("upload") MultipartFile uploadedFile) {

        try {
            log.debug("Single file uploading! ......");

            if (uploadedFile.isEmpty()) {
                Map<String, Object> errors = new HashMap<>();
                errors.put("errors", Arrays.asList("Please upload a valid file!"));

                return ResponseEntity.badRequest().body(generateResponseBody(false, "The file could not be uploaded!", errors));
            }

            // String url = uploadService.saveUploadBytesToCloudinary(uploadedFile);

            String publicURL = uploadService.saveSingleToAWS(uploadedFile);

            Map<String, Object> data = new HashMap<>();
                data.put("publicURL", publicURL);

            return ResponseEntity
                    .ok()
                    .headers(new HttpHeaders())
                    .body(generateResponseBody(true, "Successfully uploaded - " + uploadedFile.getOriginalFilename(), data));

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // 3.1.2 Multiple file upload
    @PostMapping("/multi")
    public ResponseEntity<?> uploadMultipleFiles(
        @RequestParam("uploads") MultipartFile[] uploadedFiles) {

      log.debug("Multiple file upload!");

        // Get file name
      String uploadedFileName = Arrays.stream(uploadedFiles).map(x -> x.getOriginalFilename())
          .filter(x -> StringUtils.hasLength(x)).collect(Collectors.joining(" , "));

      if (!StringUtils.hasLength(uploadedFileName)) {
        return ResponseEntity.badRequest().body("please select a file!");
      }

      try {

        uploadService.saveMultipleToCloudinary(Arrays.asList(uploadedFiles));

      } catch (Exception e) {
        return ResponseEntity.badRequest().build();
      }

      return new ResponseEntity<>("Successfully uploaded - " + uploadedFileName, HttpStatus.OK);

    }

    @PostMapping("/multipart-form")
    public ResponseEntity<?> uploadMultipartForm(
            @RequestParam("title") String title,
            @RequestParam("files") MultipartFile[] uploadFiles) {

        log.debug("Multiple file upload!");

        // Get file name
        String uploadedFileName = Arrays.stream(uploadFiles).map(x -> x.getOriginalFilename())
                .filter(x -> StringUtils.hasLength(x)).collect(Collectors.joining(" , "));

        if (!StringUtils.hasLength(uploadedFileName)) {
            return ResponseEntity.badRequest().body("please select a file!");
        }

        try {

            // uploadService.saveOnDisk(Arrays.asList(uploadFiles));

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok("Successfully uploaded - " + uploadedFileName);

    }

    // @PostMapping("/multi/model")
    // public ResponseEntity<?> multiUploadFileModel(FormRequest formRequest) {

    //     log.debug("Multiple file upload! With UploadModel");

    //     try {

    //         // uploadService.saveOnDisk(Arrays.asList(formRequest.getFiles()));

    //     } catch (Exception e) {
    //         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    //     }

    //     return ResponseEntity.ok("upload successful");

    // }

    private Map<String, Object> generateResponseBody(boolean status, String msg, Map<String, Object> data) {

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", status);
        responseBody.put("message", msg);

        if (status == false) {
            responseBody.put("data", null);
            responseBody.put("errors", data.get("errors"));
        } else {
            responseBody.put("data", data);
            responseBody.put("errors", null);
        }

        return responseBody;
    }

    /**
     * Download the file
     *
     * @param fileName fileName
     * @return ByteArrayResource
     */
    @GetMapping(path = "/download")
    public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam("fileName") final String fileName) {
        try {
            final byte[] data = uploadService.downloadFileFromAWS(fileName);
            final ByteArrayResource resource = new ByteArrayResource(data);
            return ResponseEntity
                    .ok()
                    .contentLength(data.length)
                    .header("Content-type", "application/octet-stream")
                    .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
                    .header("Cache-Control", "no-cache")
                    .body(resource);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().contentLength(0).body(null);
        }
    }
}
