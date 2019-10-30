package com.xzm.dao;

import java.util.List;

import com.xzm.model.Comment;

public interface ICommentDao {
	int save(Comment comment);

	int delete(int commentId);

	Comment find(int commentId);

	int update(Comment comment);

	List<Comment> list();

	List<Comment> list(int newsId);

	void deleteByNewsId(int newsId);

	int countRow();

	List<Comment> list(int startRecord, int pageSize);
}
