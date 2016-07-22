package com.example.daegam;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class UploadController {
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload() {

		return "upload"; // upload.jspǥ��
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody String upload1(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

		// ������ ��� ���� �ʴٸ�
		if (!file.isEmpty()) {
			try {
				String filename = file.getOriginalFilename();
				String root = request.getSession().getServletContext().getRealPath("/");

				// root���丮/upload���丮 �ؿ� ����
				File dir = new File(root + File.separator + "upload");

				// ���丮�� ������ ���丮 ������.
				if (!dir.exists()) {
					dir.mkdirs();
				}

				byte[] bytedata = file.getBytes();

				File serverFile = new File(dir.getAbsolutePath() + File.separator + filename);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytedata);
				stream.close();

				System.out.println(filename);
				System.out.println(root);
				return "upload ok";
			} catch (Exception e) {
				return "upload fail";
			}
		} else {
			return "upload fail";
		}
	}

	// https://mvnrepository.com/artifact/servlets.com/cos/05Nov2002

	@RequestMapping(value = "/upload1", method = RequestMethod.POST)
	public @ResponseBody String upload2(HttpServletRequest request) {
		int maxSize = 1024 * 1024 * 10; // 10M
		String root = request.getSession().getServletContext().getRealPath("/");

		// root���丮/upload���丮 �ؿ� ����
		File dir = new File(root + File.separator + "upload1");

		// ���丮�� ������ ���丮 ������.
		if (!dir.exists()) {
			dir.mkdirs();
		}

		try {
			// ������ġ, �ִ�뷫����
			com.oreilly.servlet.MultipartRequest multi = new com.oreilly.servlet.MultipartRequest(request, dir.getAbsolutePath(), maxSize, "UTF-8", new DefaultFileRenamePolicy());

			String uploadFile = multi.getFilesystemName("input type=file�� name��");
			System.out.println(uploadFile);
			
			return "upload1 ok";
		} catch (Exception e) {
			return "upload1 fail";
		}
	}
}