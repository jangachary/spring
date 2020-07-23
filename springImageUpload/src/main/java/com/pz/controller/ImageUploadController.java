package com.pz.controller;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class ImageUploadController {

	private static final Logger logger = Logger.getLogger(ImageUploadController.class);

	@RequestMapping(value = { "/upload" })
	public String uploadGet(Model model) {

		return "upload";
	}

	@RequestMapping(value = { "/upload" }, method = RequestMethod.POST)
	public String upload(Model model, @RequestParam CommonsMultipartFile file, HttpSession httpSession) {
		logger.info("file upload");
		String folder = "resources/images/";
		String path = httpSession.getServletContext().getRealPath("/") + "/" + folder;
		logger.info("file path " + path);
		String filename = file.getOriginalFilename();

		byte fileArr[] = file.getBytes();

		try {
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
					new FileOutputStream(path + "/" + filename));

			bufferedOutputStream.write(fileArr);

			bufferedOutputStream.flush();
			bufferedOutputStream.close();
			model.addAttribute("file", filename);
			logger.info("image upladed");
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());

		} catch (IOException e) {

			logger.error(e.getMessage());
		}

		return "upload";
	}

}
