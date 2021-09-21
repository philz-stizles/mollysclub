package com.devdezyn.mollysclub.shared.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
  
  @Value("${app.cloudinary.cloud-name}")
  private String cloudName;

   @Value("${app.cloudinary.api-key}")
   private String apiKey;
  
    @Value("${app.cloudinary.api-secret}")
    private String apiSecret;
  
  @Bean
  public Cloudinary cloudinary() {
    // Initialize Cloudinary.
    Cloudinary cloudinary = new Cloudinary(
        ObjectUtils.asMap("cloud_name", cloudName, "api_key", apiKey, "api_secret", apiSecret, "secure", true));

    return cloudinary;
  }
  
  // Initialize in App file at app start
  // SingletonManager manager = new SingletonManager();
  // manager.setCloudinary(someCloudinaryInstance);
  // manager.init();
}
