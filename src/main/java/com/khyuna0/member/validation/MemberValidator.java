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
		Integer age = memberDto.getAge();
		
		// 공란인지 확인
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.empty", "아이디는 필수 입력사항입니다."); // 에러, 필드명, 오류 코드, 메세지
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "pw.empty", "비밀번호는 필수 입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "cpw.empty", "비밀번호 확인은 필수 입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "이름은 필수 입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty", "이메일은 필수 입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "age.empty", "나이는 필수 입력사항입니다.");
		// 아이디의 길이가 5자 이상인지 확인
		
		if (id != null && id.length() < 5) { // 조건이 참이면 에러 -> 아이디 길이가 5자 미만이면 에러
			errors.rejectValue("id", "id.short", "아이디는 5자 이상이어야 합니다.");
		}
		
		// 비밀번호의 길이가 5자 이상인지 확인
		if (password != null && password.length() < 5) { // 비밀번호 길이가 5자 미만이면 에러
			errors.rejectValue("password", "pw.short", "비밀번호는 5자 이상이어야 합니다.");
		}
		
		// 비밀번호 확인
		if (password != null && !password.equals(confirmPassword) ) { // 비밀번호 란 공백, 비밀번호와 비밀번호 확인이 일치하지 않는 경우
			errors.rejectValue("confirmPassword", "pw.mismatch", "비밀번호 확인이 일치하지 않습니다.");
		}
		
		// 나이 확인, 18세 이상만 가입 가능
		if ( age == null || age < 18 ) {
			errors.rejectValue("age", "age.short", "18세 이상만 가입 가능합니다.");
		}
		
		
		
	}

}
