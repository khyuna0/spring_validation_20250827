package com.khyuna0.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khyuna.dto.MemberDto;
import com.khyuna0.member.validation.MemberValidator;

@Controller
public class MemberController {

	@RequestMapping(value = "/memberJoin")
	public String membrtJoin() {
		
		return "memberJoin";
	}
	
	@RequestMapping(value = "/memberJoinOk")
	public String membrtJoinOk(@ModelAttribute("memberDto") MemberDto memberDto, Model model , BindingResult result) {
		
		MemberValidator memberValidator = new MemberValidator();
		memberValidator.validate(memberDto, result);
		
		if(result.hasErrors()) { // 오류 있는지 확인 (유효성 체크)
			List<ObjectError> allErrors = result.getAllErrors(); // 모든 에러가 들어있음!
			List<String> errorMsg = new ArrayList<String>();
			
			for (ObjectError error : allErrors) {
				errorMsg.add(error.getDefaultMessage());// DefaltMessage = 에러 메세지
			}
			
			model.addAttribute("signupError", "회원 가입에 실패하셨습니다.");
			model.addAttribute("errorMsg", errorMsg);
			
			return "memberJoin";
		}
		
		return "memberJoinOk";
	}
}
