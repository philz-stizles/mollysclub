package com.devdezyn.mollysclub.shared.cloudinary;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.transformation.Layer;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

/**
 *
 *
 * @author Theophilus Ighalo
 */
@Service
@RequiredArgsConstructor
public class CloudinaryServiceImpl implements CloudinaryService {

  @Autowired
  private Cloudinary cloudinary;

    /**
     * 
     *
     * @param bytes
     * @param options
     * @return the publicId assigned to the uploaded file, or null in case of
     * error
     */
    public String uploadBytes(byte[] bytes, Map<String, String> options) {
      try {
        Map<?, ?> uploadResult = cloudinary.uploader().upload(bytes,
            ObjectUtils.asMap("folder", "mollysclub/docs/", "resource_type", "auto"));
        // Map<?, ?> uploadResult = cloudinary.uploader().uploadLarge(uploadedFile, ObjectUtils.emptyMap());

        return uploadResult.get("url").toString();

      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    
    /**
     * 
     *
     * @param authToken
     * @param email
     * @param file to be uploaded
     * @return the publicId assigned to the uploaded file, or null in case of
     * error
     */
    public String uploadFile(File file, Map<String, String>options) {
      try {
        Map<?, ?> uploadResult = cloudinary.uploader().upload(file, ObjectUtils.asMap("folder", "mollysclub/docs/", "resource_type", "auto"));
        // Map<?, ?> uploadResult = cloudinary.uploader().uploadLarge(uploadedFile, ObjectUtils.emptyMap());

        return uploadResult.get("url").toString();

      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    
    public String uploadVideo(MultipartFile file, Map<String, String>options) {
      try {
        File uploadedFile = convertMultiPartToFile(file);

        Map<?, ?> uploadResult = cloudinary.uploader().upload(uploadedFile,
            ObjectUtils.asMap(
                "resource_type", "video", 
                "folder", "mollysclub/video/"
                // "eager", Arrays.asList(
                //   new EagerTransformation().width(300).height(300).crop("pad").audioCodec("none"),
                //   new EagerTransformation().width(160).height(100).crop("crop").gravity("south").audioCodec("none")),
                // "eager_async", true,
                // "eager_notification_url", "https://mysite.example.com/notify_endpoint"
              )
            );
        // Map<?, ?> uploadResult = cloudinary.uploader().uploadLarge(uploadedFile, ObjectUtils.emptyMap());

        boolean isDeleted = uploadedFile.delete();

        if (isDeleted) {
          System.out.println("File successfully deleted");
        } else {
          System.out.println("File doesn't exist");
        }

        return uploadResult.get("url").toString();

      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    
    public String uploadBase64(String base64FileString, Map<String, String>options) {
        try {
          Map<?, ?> uploadResult = cloudinary.uploader()
              .upload(base64FileString, ObjectUtils.asMap(
                  "resource_type", "video",
                  "folder", "mollysclub/docs/"
                )
              );
          // Map<?, ?> uploadResult = cloudinary.uploader().uploadLarge(base64FileString, ObjectUtils.asMap("resource_type", "video"));
          
          return uploadResult.get("url").toString();
          
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void transformImage() {
      cloudinary.url()
          .transformation(new Transformation().width(150).height(150).gravity("face").crop("thumb").chain().radius(20)
              .chain().effect("sepia").chain().overlay(new Layer().publicId("cloudinary_icon_blue"))
              .gravity("south_east").x(5).y(5).width(50).opacity(60).effect("brightness:200").chain().angle(10))
          .secure(true).imageTag("front_face.png");
    }
    
     private File convertMultiPartToFile(MultipartFile file) throws IOException {
      File fileFromMultipart = new File(file.getOriginalFilename());

      FileOutputStream fos = new FileOutputStream(fileFromMultipart);
      fos.write(file.getBytes());
      fos.close();

      return fileFromMultipart;
    }

}
