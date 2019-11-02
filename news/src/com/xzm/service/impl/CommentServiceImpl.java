package com.xzm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xzm.dao.ICommentDao;
import com.xzm.dao.INewsDao;
import com.xzm.dao.impl.CommentDaoImpl;
import com.xzm.dao.impl.NewsDaoImpl;
import com.xzm.model.Comment;
import com.xzm.model.Page;
import com.xzm.service.ICommentService;

public class CommentServiceImpl implements ICommentService {

	private static ICommentDao commentDao = new CommentDaoImpl();
	private static INewsDao newsDao = new NewsDaoImpl();

	public boolean add(Comment comment) {
		if (1 == newsDao.changeCommentCount(comment.getCommentNewsId(), "plus")) {
			if (commentDao.save(comment) >= 1) {
				return true;
			}
		}
		return false;
	}

	public Comment[] list(int newsId) {
		List<Comment> lists = commentDao.list(newsId);
		Comment[] commentLists = new Comment[lists.size()];
		lists.toArray(commentLists);
		return commentLists;
	}

	public Map<String, Object> list(int pageSize, int current) {
		Page pageBean = new Page();
		int allRecords = commentDao.countRow();
		int totalPages = pageBean.calculateTotalPage(pageSize, allRecords);
		int currentPage = pageBean.judgeCurrentPageIsLegal(current, totalPages);
		if (currentPage == 0) {
			return null;
		}
		int startRecord = pageBean.calculateCurrentPageStartRecord(pageSize,
				currentPage);
		pageBean.init(allRecords, currentPage, pageSize, totalPages);
		List<Comment> comments = commentDao.list(startRecord, pageSize);
		Comment[] commentList = new Comment[comments.size()];
		comments.toArray(commentList);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commentList", commentList);
		map.put("pageBean", pageBean);
		return map;
	}

	public boolean delete(int commentId, int newsId) {
		if (1 == newsDao.changeCommentCount(newsId, "minus")) {
			if (1 == commentDao.delete(commentId)) {
				return true;
			}
		}
		return false;
	}

}
