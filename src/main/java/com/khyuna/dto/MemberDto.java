package com.khyuna.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MemberDto {

	private String id; // 회원 아이디
	private String password; // 회원 비밀번호 
	private String comfirmPassword; // 확인용 비밀번호
	private String name; // 회원 이름
	private String email; // 회원 이메일
	private int age; // 회원 나이

	
}
