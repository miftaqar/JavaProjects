package com.primetgi.hb.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetailCopy {

	// annotate the class and map it to db table

	// define the fields

	// define the constructor

	// annotate the fields with db columns

	// generate the constructor

	// define the toString method

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "youtube_channel")
	private String youtube_channel;

	@Column(name = "hobby")
	private String hobby;

	// add new field for Instructor
	// add annotation to field

	@OneToOne(mappedBy = "instructorDetailCopy", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REFRESH })
	private InstructorCopy instructorCopy;

	public InstructorDetailCopy() {
	}

	public InstructorDetailCopy(String youtube_channel, String hobby) {
		this.youtube_channel = youtube_channel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutube_channel() {
		return youtube_channel;
	}

	public void setYoutube_channel(String youtube_channel) {
		this.youtube_channel = youtube_channel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public InstructorCopy getInstructorCopy() {
		return instructorCopy;
	}

	public void setInstructorCopy(InstructorCopy instructorCopy) {
		this.instructorCopy = instructorCopy;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtube_channel=" + youtube_channel + ", hobby=" + hobby + "]";
	}

}
