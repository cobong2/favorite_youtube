package com.myproject.myapp.admin.dao;

import com.myproject.myapp.model.UserVO;
import com.myproject.myapp.model.YoutubeVO;

public interface AdminMapper {
	public void join(UserVO p);
	public void insertURL(YoutubeVO p);
}
