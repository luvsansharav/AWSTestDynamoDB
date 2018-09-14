package com.aws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Loya on 9/12/18
 */

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        try (InputStream inputStream = Application.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties appProperties = new Properties();
            appProperties.load(inputStream);

            System.setProperty("aws.accessKeyId", appProperties.getProperty("accessKeyId"));
            System.setProperty("aws.secretKey", appProperties.getProperty("secretKey"));
            System.setProperty("aws.region", appProperties.getProperty("region"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        SpringApplication.run(Application.class, args);
    }
}
