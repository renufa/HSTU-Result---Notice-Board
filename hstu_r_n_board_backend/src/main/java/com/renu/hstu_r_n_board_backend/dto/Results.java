package com.renu.hstu_r_n_board_backend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name="results")
public class Results implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Transient
	@Column(name="img_url")
	@NotEmpty(message="Please upload a file")
	private MultipartFile img_url;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MultipartFile getImg_url() {
		return img_url;
	}
	public void setImg_url(MultipartFile img_url) {
		this.img_url = img_url;
	}
	
	
	
	
	
	
}