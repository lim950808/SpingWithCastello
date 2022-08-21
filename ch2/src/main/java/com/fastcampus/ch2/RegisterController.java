package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // ctrl+shift+o �ڵ� ����Ʈ 
@RequestMapping("/register")
public class RegisterController {
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		
		ConversionService conversionService = binder.getConversionService();
		System.out.println("conversionService = " + conversionService);
		
		/* User.java���� @DateTimeFormat(pattern="yyyy-MM-dd")�� ��ü ���� */
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false)); //"yyyy-MM-dd" �������� �Է½� Date Ÿ������ ����������
		
		binder.registerCustomEditor(String[].class, "hobby", new StringArrayPropertyEditor("#")); //#���� ���н� �迭�� ����������
	}
	
	@RequestMapping(value="/add", method= {RequestMethod.GET, RequestMethod.POST}) // �ű�ȸ�� ����
//	@GetMapping("/register/add") // 4.3���� �߰�
	public String register() {
		return "registerForm";  // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST) // �ű�ȸ�� ����
	@PostMapping("/save")
	public String save(User user, BindingResult result, Model m) throws Exception {
		System.out.println("result = " + result);
		System.out.println("user = " + user);
		
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
		return true;
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