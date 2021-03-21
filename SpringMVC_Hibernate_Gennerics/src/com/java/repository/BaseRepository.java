package com.java.repository;

import java.util.List;

public interface BaseRepository <T, K>{
	List<T> getAll();
	void 	add(T entity);
	T 		findById(K id);
	void 	edit(T entity);
	void 	detele(K id);
}
