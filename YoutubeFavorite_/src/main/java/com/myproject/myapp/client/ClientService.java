package com.myproject.myapp.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.myapp.client.dao.ClientMapper;
import com.myproject.myapp.model.YoutubeVO;

@Service
public class ClientService {
	@Autowired
	private ClientMapper mapper;

	public List<YoutubeVO> getList() {
		return mapper.getList();
	}
}
