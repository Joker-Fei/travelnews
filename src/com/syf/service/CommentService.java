package com.syf.service;

import java.util.List;

import com.syf.dao.CommentDao;
import com.syf.entity.Comment;

public class CommentService {
	public int save(Comment comment) {
		return new CommentDao().save(comment);
	}

	public List<Comment> findByNewsId(int newsId) {
		return new CommentDao().findByNewsId(newsId);
	}

	public int updateState(String id) {
		return new CommentDao().updateState(id);
	}

	public int delete(String id) {
		return new CommentDao().delete(id);
	}
}
