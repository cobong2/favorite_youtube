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
import com.myproject.myapp.commons.ImgUtils;
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
		String g_path = ImgUtils.saveImgAndMakeThumb(this.getClass(), vo);
		System.out.println("g_path : " + g_path);
		vo.setG_path(g_path);
		mapper.insertGallary(vo);
	}
}
