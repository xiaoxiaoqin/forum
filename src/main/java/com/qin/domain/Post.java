package com.qin.domain;
// Generated 2017-10-22 14:53:45 by Hibernate Tools 5.1.4.Final

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * TPost generated by hbm2java
 * 
 * Inheritance注解指定了PO映射继承关系，共三中 Interitance.TABLE_PER_CLASS:每个类一张表
 * Interitance.JOINED：连接的子类 Interitance.SINGLE_TABLE:每个类层次结构一张表
 * DiscriminatorColumn定义了用来辨别符列
 * 
 */
@Entity(name="Post")
@Table(name = "t_post")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "post_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("1")
public class Post extends BaseDomain {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "post_id", unique = true, nullable = false)
	private Integer postId;
	@Column(name = "board_id", nullable = false)
	private int boardId;
	@Column(name = "post_type", nullable = false,insertable=false,updatable=false)
	private byte postType;

	@Autowired
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Autowired
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "topic_id")
	private Topic topic;
	@Column(name = "post_title", nullable = false, length = 50)
	private String postTitle;
	@Column(name = "post_text", nullable = false, length = 65535)
	private String postText;
	@Temporal(TemporalType.DATE)
	@Column(name = "create_time", nullable = false, length = 10)
	private Date createTime;

	public Post() {
	}

	public Post(int boardId, User user, Topic topic, byte postType, String postTitle, String postText,
			Date createTime) {
		this.boardId = boardId;
		this.topic = topic;
		this.user = user;
		this.postType = postType;
		this.postTitle = postTitle;
		this.postText = postText;
		this.createTime = createTime;
	}

	public Integer getPostId() {
		return this.postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public int getBoardId() {
		return this.boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public byte getPostType() {
		return this.postType;
	}

	public void setPostType(byte postType) {
		this.postType = postType;
	}

	public String getPostTitle() {
		return this.postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostText() {
		return this.postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
