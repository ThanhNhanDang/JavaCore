package com.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.dto.StatusDto;
import com.java.entity.Status;
import com.java.repository.StatusRepository;
import com.java.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService{

	private StatusRepository repository;
	
	public StatusServiceImpl(StatusRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}
	@Override
	public List<StatusDto> getList() {
		try {
			List<Status> entities = repository.getList();
			List<StatusDto> dtos = new ArrayList<StatusDto>();
			for(Status entity : entities) {
				StatusDto dto = new StatusDto(entity.getId(), entity.getName());
				dtos.add(dto);
			}
			
			return dtos;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(StatusDto dto) {
		try {
			Status entity = new Status(dto.getName());
			repository.add(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
			repository.delete(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean edit(StatusDto dto) {
		try {
			Status entity =  new Status(dto.getId(), dto.getName());
			repository.edit(entity);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public StatusDto findById(int id) {
		try {
			Status entity = repository.findById(id);
			StatusDto dto =  new StatusDto(entity.getId(), entity.getName());
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
