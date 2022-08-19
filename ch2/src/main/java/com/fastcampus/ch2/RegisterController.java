package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller // ctrl+shift+o 자동 임포트 
public class RegisterController {
	@RequestMapping(value="/register/add", method= {RequestMethod.GET, RequestMethod.POST}) // 신규회원 가입
//	@GetMapping("/register/add") // 4.3부터 추가
	public String register() {
		return "registerForm";  // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST) // 신규회원 가입
	@PostMapping("/register/save")
	public String save(User user, Model m) throws Exception {
	//public String save(@ModelAttribute("user") User user, Model m) throws Exception {
		// 1. 유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
			
			m.addAttribute("msg", msg);
			return "forward:/register/add"; // 신규회원 가입화면으로 이동(redirect)
			//return "redirect:/register/add?msg="+msg; //URL재작성(rewriting)
		}
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}
}

//	@Controller
//	public class RegisterController {
//		@RequestMapping("/register/add")
//		public String register() {
//			return "registerForm";
//		}
//			
//		@RequestMapping("/register/save")
//		public String save() {
//			return "registerInfo";
//		}
//	}