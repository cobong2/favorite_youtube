package com.myproject.myapp.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myproject.myapp.admin.dao.AdminMapper;
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
		// TODO: 비밀번호 암호화

		mapper.insertURL(vo);
	}
}
