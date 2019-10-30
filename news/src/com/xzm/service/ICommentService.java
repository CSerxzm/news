package com.xzm.service;

import java.util.Map;

import com.xzm.model.Comment;


public interface ICommentService {
	boolean add(Comment comment);
	Comment[] list(int newsId);
	Map<String, Object> list(int pageSize, int currentPage);
	boolean delete(int commentId, int newsId);
}
