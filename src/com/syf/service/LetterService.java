package com.syf.service;

import java.util.List;

import com.syf.dao.LetterDao;
import com.syf.entity.Letter;

public class LetterService {
	public int save(Letter letter) {
		return new LetterDao().save(letter);
	}

	public List<Letter> findByMessageId(int messageId) {
		return new LetterDao().findByMessageId(messageId);
	}

}
