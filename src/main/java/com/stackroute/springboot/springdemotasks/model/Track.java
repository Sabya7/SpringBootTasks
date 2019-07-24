package com.stackroute.springboot.springdemotasks.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//make this class as hibernate entity

@Table(name = "Track")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Track {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "comment")
	private String comment;


}
