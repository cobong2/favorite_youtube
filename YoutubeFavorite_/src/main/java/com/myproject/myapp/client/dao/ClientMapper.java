package com.myproject.myapp.client.dao;

import java.util.List;

import com.myproject.myapp.model.GallaryVO;
import com.myproject.myapp.model.YoutubeVO;

public interface ClientMapper {
	public List<YoutubeVO> getList();
	public List<GallaryVO> getGallaryList();
	public GallaryVO gallaryDetail(int g_no);
}
