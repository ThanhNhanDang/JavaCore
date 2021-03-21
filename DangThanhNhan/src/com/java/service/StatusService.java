package com.java.service;

import java.util.List;

import com.java.dto.StatusDto;


public interface StatusService {
	List<StatusDto> getList();
	boolean 		add(StatusDto dto);
	boolean 		delete(int id);
	boolean 		edit(StatusDto dto);
	StatusDto 		findById(int id);
}
