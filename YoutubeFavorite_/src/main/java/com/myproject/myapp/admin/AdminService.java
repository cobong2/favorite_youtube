package com.myproject.myapp.admin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.myproject.myapp.admin.dao.AdminMapper;
import com.myproject.myapp.model.GallaryVO;
import com.myproject.myapp.model.UserVO;
import com.myproject.myapp.model.YoutubeVO;

@Service
public class AdminService {

	@Autowired
	private AdminMapper mapper;

	@Autowired
	private BCryptPasswordEncoder bpe;

	public void join(UserVO vo) {
		// TODO: 비밀번호 암호화
		String encodePassword = bpe.encode(vo.getU_pw());
		vo.setU_pw(encodePassword);

		mapper.join(vo);
	}

	public void insertURL(YoutubeVO vo) {
		mapper.insertURL(vo);
	}

	public void insertGallary(GallaryVO vo) {
		try {
			String contextPath = this.getClass().getClassLoader().getResource("").getPath();
			String fullPath = URLDecoder.decode(contextPath, "UTF-8");

			Date date = new Date();
			SimpleDateFormat today = new SimpleDateFormat("yyyy/MM/dd", Locale.KOREA);

			UUID uuid = UUID.randomUUID();
			String ext = vo.getImg().getOriginalFilename()
					.substring(vo.getImg().getOriginalFilename().lastIndexOf(".") + 1);
			String fileName = uuid.toString() + "." + ext;
			System.out.println(fileName);

			String pathArr[] = fullPath.split("WEB-INF/classes/");

			String targetPath = pathArr[0] + "resources/img/" + today.format(date);
			System.out.println("contextPath: " + targetPath);

			File path = new File(targetPath);
			if (!path.exists()) {
				path.mkdirs();
			}

			File img = new File(targetPath, fileName); // ,(/를 자동으로)를 붙이면 경로를 계속 붙인다.
			FileCopyUtils.copy(vo.getImg().getBytes(), img);

			String thumbImgPath = pathArr[0] + "resources/img/thumb/" + today.format(date);

			path = new File(thumbImgPath);
			if (!path.exists()) {
				path.mkdirs();
			}
			BufferedImage sourceImg = ImageIO.read(img);
			BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
			File thumbImg = new File(thumbImgPath, fileName);
			ImageIO.write(destImg, ext.toLowerCase(), thumbImg);
		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
