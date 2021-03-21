package com.java.service;

import java.util.List;

public interface BaseService <T , K>{
	List<T> 			getAllDto();
	int 				add (T dto);
	T 					findById(int id);
	int					edit(T dto);
	int 				delete(int id);
}
