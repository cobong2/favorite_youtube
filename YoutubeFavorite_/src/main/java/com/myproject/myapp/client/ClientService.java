package com.myproject.myapp.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.myapp.client.dao.ClientMapper;
import com.myproject.myapp.model.GallaryVO;
import com.myproject.myapp.model.YoutubeVO;

@Service
public class ClientService {
	@Autowired
	private ClientMapper mapper;

	public List<YoutubeVO> getList() {
		return mapper.getList();
	}
	
	public List<GallaryVO> gallaryList() {
		return mapper.getGallaryList();
	}
	
	public GallaryVO gallaryDetail(int g_no) {
		return mapper.gallaryDetail(g_no);
	}
}
