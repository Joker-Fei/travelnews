package com.syf.service;

import java.util.List;

import com.syf.dao.MessageDetailDao;
import com.syf.entity.MessageDetail;

public class MessageDetailService {
	public int save(MessageDetail messageDetail) {
		return new MessageDetailDao().save(messageDetail);
	}

	public List<MessageDetail> findAll() {
		return new MessageDetailDao().findAll();
	}

	// public MessageDetail findById(String id) {
	// return new MessageDetailDao().findById(id);
	// }

	public int delete(String id) {
		return new MessageDetailDao().delete(id);
	}

	public List<MessageDetail> findAllByUserId(String id) {
		return new MessageDetailDao().findAllByUserId(id);
	}

	public MessageDetail findById(String id) {
		return new MessageDetailDao().findById(id);
	}

}
