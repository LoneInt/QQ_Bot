package com.example.qqbot.Util;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;

public class ImgURLConvertBase64Util {
    public static String ImgConvertBase64(String imageUrl) {
        // 图片的 URL
        StringBuilder output = new StringBuilder();
        try {
            URL url = new URL(imageUrl);
            InputStream inputStream = url.openStream();

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = outputStream.toByteArray();
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);

            System.out.println("Base64 Encoded Image: " + base64Image);
            output.append(base64Image);
            inputStream.close();
            outputStream.close();
            return base64Image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }
}
