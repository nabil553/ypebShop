package com.ypeb.model.user.message;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "message", catalog = "ypeb")
public class Message extends AbstractMessage implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(Integer userId, String content, Timestamp time,
			Boolean isReply) {
		super(userId, content, time, isReply);
	}

	/** full constructor */
	public Message(Integer userId, String content, Timestamp time,
			String reply, Timestamp replyTime, Boolean isReply) {
		super(userId, content, time, reply, replyTime, isReply);
	}

}
