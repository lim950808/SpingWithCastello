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

@Controller // ctrl+shift+o �ڵ� ����Ʈ 
public class RegisterController {
	@RequestMapping(value="/register/add", method= {RequestMethod.GET, RequestMethod.POST}) // �ű�ȸ�� ����
//	@GetMapping("/register/add") // 4.3���� �߰�
	public String register() {
		return "registerForm";  // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST) // �ű�ȸ�� ����
	@PostMapping("/register/save")
	public String save(User user, Model m) throws Exception {
	//public String save(@ModelAttribute("user") User user, Model m) throws Exception {
		// 1. ��ȿ�� �˻�
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�.", "utf-8");
			
			m.addAttribute("msg", msg);
			return "forward:/register/add"; // �ű�ȸ�� ����ȭ������ �̵�(redirect)
			//return "redirect:/register/add?msg="+msg; //URL���ۼ�(rewriting)
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