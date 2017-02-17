package com.ypeb.model.shopping.announcement;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Announcement entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "announcement", catalog = "ypeb")
public class Announcement extends AbstractAnnouncement implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Announcement() {
	}

	/** full constructor */
	public Announcement(String title, String content, Timestamp time) {
		super(title, content, time);
	}

}
