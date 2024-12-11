
package com.klef.jfsd.sdp;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/user/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);

        registry.addMapping("/admin/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);

        registry.addMapping("/food/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
        
        registry.addMapping("/diet/**")
        .allowedOrigins("http://localhost:3000")
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowedHeaders("*")
        .allowCredentials(true);
        
        registry.addMapping("/exercise/**")
        .allowedOrigins("http://localhost:3000")
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowedHeaders("*")
        .allowCredentials(true);

        registry.addMapping("/article/**")
        .allowedOrigins("http://localhost:3000")
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowedHeaders("*")
        .allowCredentials(true);
        
        registry.addMapping("/userexercise/**")
        .allowedOrigins("http://localhost:3000")
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowedHeaders("*")
        .allowCredentials(true);
        
        
        
        registry.addMapping("/user/**")
        .allowedOrigins("https://sweet-chebakia-2e68c1.netlify.app/")
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowedHeaders("*")
        .allowCredentials(true);

registry.addMapping("/admin/**")
        .allowedOrigins("https://sweet-chebakia-2e68c1.netlify.app/")
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowedHeaders("*")
        .allowCredentials(true);

registry.addMapping("/food/**")
        .allowedOrigins("https://sweet-chebakia-2e68c1.netlify.app/")
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowedHeaders("*")
        .allowCredentials(true);

registry.addMapping("/diet/**")
.allowedOrigins("https://sweet-chebakia-2e68c1.netlify.app/")
.allowedMethods("GET", "POST", "PUT", "DELETE")
.allowedHeaders("*")
.allowCredentials(true);

registry.addMapping("/exercise/**")
.allowedOrigins("https://sweet-chebakia-2e68c1.netlify.app/")
.allowedMethods("GET", "POST", "PUT", "DELETE")
.allowedHeaders("*")
.allowCredentials(true);

registry.addMapping("/article/**")
.allowedOrigins("https://sweet-chebakia-2e68c1.netlify.app/")
.allowedMethods("GET", "POST", "PUT", "DELETE")
.allowedHeaders("*")
.allowCredentials(true);

registry.addMapping("/userexercise/**")
.allowedOrigins("https://sweet-chebakia-2e68c1.netlify.app/")
.allowedMethods("GET", "POST", "PUT", "DELETE")
.allowedHeaders("*")
.allowCredentials(true);
    }
}
