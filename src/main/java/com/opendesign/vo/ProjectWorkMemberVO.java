/*
 * Copyright (c) 2016 OpenDesign All rights reserved.
 *
 * This software is the confidential and proprietary information of OpenDesign.
 * You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into
 * with OpenDesign.
 */
package com.opendesign.vo;

/**
 * 
 * <pre>
 * 프로젝트 작품 멤버 VO
 * </pre>
 * 
 * @author hanchanghao
 * @since 2016. 8. 23.
 */
public class ProjectWorkMemberVO {

	/** 참여회원seq */
	private String memberSeq;
	/** 작품seq */
	private String projectWorkSeq;
	/** 등록일시 */
	private String registerTime;

	// ==================================================
	/** 참여회원 이름 */
	private String memberName;
	/** 참여회원 이메일 */
	private String memberEmail;

	// ==================================================

	public String getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getProjectWorkSeq() {
		return projectWorkSeq;
	}

	public void setProjectWorkSeq(String projectWorkSeq) {
		this.projectWorkSeq = projectWorkSeq;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

}
