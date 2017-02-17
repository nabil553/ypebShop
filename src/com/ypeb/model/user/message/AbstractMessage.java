package com.ypeb.model.user.message;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractMessage entity provides the base persistence definition of the
 * Message entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractMessage implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String content;
	private Timestamp time;
	private String reply;
	private Timestamp replyTime;
	private Boolean isReply;

	// Constructors

	/** default constructor */
	public AbstractMessage() {
	}

	/** minimal constructor */
	public AbstractMessage(Integer userId, String content, Timestamp time,
			Boolean isReply) {
		this.userId = userId;
		this.content = content;
		this.time = time;
		this.isReply = isReply;
	}

	/** full constructor */
	public AbstractMessage(Integer userId, String content, Timestamp time,
			String reply, Timestamp replyTime, Boolean isReply) {
		this.userId = userId;
		this.content = content;
		this.time = time;
		this.reply = reply;
		this.replyTime = replyTime;
		this.isReply = isReply;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "userID", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "reply", length = 65535)
	public String getReply() {
		return this.reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	@Column(name = "replyTime", length = 19)
	public Timestamp getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}

	@Column(name = "isReply", nullable = false)
	public Boolean getIsReply() {
		return this.isReply;
	}

	public void setIsReply(Boolean isReply) {
		this.isReply = isReply;
	}

}