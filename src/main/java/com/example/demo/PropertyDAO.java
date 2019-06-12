package com.example.demo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Service
public class PropertyDAO
{
	@Autowired
	PropertyRepository propertyRepository;
	
	public static String uploadDirectory = "E:/uploads";

	public Property save(Property prop, Model model, HttpServletRequest request) {
		try {
			StringBuilder fileNames = new StringBuilder();
			String path1 = "";

			String base64Image = prop.getImage().toString().split(",")[1];
			byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);

			Path currentRelativePath = Paths.get(uploadDirectory, "myImage.png");

			ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
			BufferedImage image = ImageIO.read(bis);
			bis.close();

			// write the image to a file
			File outputfile = new File(currentRelativePath.toString());
			ImageIO.write(image, "png", outputfile);

			prop.setImage(currentRelativePath.toString());
			model.addAttribute("property", prop);

		}

		catch (Exception e) {
			e.printStackTrace();

		}
		return propertyRepository.save(prop);
	}
	
	/*
	 * public List<Property> findAll() { return propertyRepository.findAll(); }
	 */
	public List<Property> findAll() {
		// TODO Auto-generated method stub
		return propertyRepository.findAll();
		}
	
	
	
}
