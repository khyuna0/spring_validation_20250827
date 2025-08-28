package com.khyuna0.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khyuna0.dto.MemberDto;
import com.khyuna0.member.validation.MemberValidator;

@Controller
@RequestMapping("/member")
public class MemberController {

    @RequestMapping("/memberJoin")
    public String memberJoin(@ModelAttribute("memberDto") MemberDto memberDto) {
        return "memberJoin"; // /WEB-INF/views/memberJoin.jsp
    }

    @RequestMapping("/memberJoinOk")
    public String memberJoinOk(@ModelAttribute("memberDto") MemberDto memberDto,
                               BindingResult result, Model model) {
        MemberValidator validator = new MemberValidator();
        validator.validate(memberDto, result);
		
		if(result.hasErrors()) { //에러가 있는지 확인(유효성 체크)
			List<ObjectError> allErrors = result.getAllErrors(); //모든 에러 포함
			List<String> errorMsg = new ArrayList<String>();
			
			for(ObjectError error :allErrors) {
				 //에러메시지
				errorMsg.add(error.getDefaultMessage());
			}
			
			model.addAttribute("signupError", "회원 가입에 실패하였습니다.");
			model.addAttribute("errorMsg", errorMsg);
			
			model.addAttribute("memberDto", memberDto); 
			//가입화면에서 유저가 입력한 내용을 다시 보여주기 위해 memberDto를 가입화면으로 전송
			
			return "memberJoin";
		}
		
		model.addAttribute("memberDto", memberDto);
		return "memberJoinOk";
	}
	
	

}