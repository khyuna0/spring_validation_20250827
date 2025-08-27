package com.khyuna0.member.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.khyuna.dto.MemberDto;

public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	
		MemberDto memberDto = (MemberDto)target;
		String id = memberDto.getId();
		String password = memberDto.getPassword();
		String confirmPassword = memberDto.getConfirmPassword();
		String name = memberDto.getName();
		String email = memberDto.getEmail();
		int age = memberDto.getAge();
		
		// 아이디가 공란인지 확인
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.empty", "id는 필수 입력사항입니다."); // 에러, 필드명, 오류 코드, 메세지
		// 아이디의 길이가 5자 이상인지 확인
		if (id != null && id.length() < 5) { // 조건이 참이면 에러 -> 아이디 길이가 5자 미만이면 에러
			errors.rejectValue("id", "id.short", "id는 5자 이상이어야 합니다.");
		}
		
		// 비밀번호 확인
		if (password != null && !password.equals(confirmPassword) ) { // 비밀번호 란 공백, 비밀번호와 비밀번호 확인이 일치하지 않는 경우
			errors.rejectValue("confirmPassword", "pw.mismatch", "비밀번호 확인이 일치하지 않습니다.");
		}
	}

}
