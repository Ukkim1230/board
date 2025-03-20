package com.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardDTO {
	private int biNum;
	private String biTitle;
	private String biContent;
	private int uiNum;
	private String CREDAT;
	private String creTim;
	private String lmodat;
	private String lmotim;
	private String uiName;

}
