package com.fastcampus.ch2;

import java.net.URLEncoder;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //ctrl+shift+o 자동 임포트 
@RequestMapping("/register")
public class RegisterController {
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
		
		ConversionService conversionService = binder.getConversionService();
		//System.out.println("conversionService = " + conversionService);
		
		/* User.java에서 @DateTimeFormat(pattern="yyyy-MM-dd")로 대체 가능 */
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false)); //"yyyy-MM-dd" 형식으로 입력시 Date 타입으로 변형시켜줌
		
		binder.registerCustomEditor(String[].class, "hobby", new StringArrayPropertyEditor("#")); //#으로 구분시 배열로 변형시켜줌
		//binder.setValidator(new UserValidator()); //UserValidator�� WebDataBinder�� ���� validator�� ���
		//binder.addValidators(new UserValidator());
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList = " + validatorList);
	}
	
	@RequestMapping(value="/add", method= {RequestMethod.GET}) // 신규회원 가입
//	@GetMapping("/register/add") // 4.3부터 추가
	public String register() {
		return "registerForm";  // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST) // 신규회원 가입
	@PostMapping("/add")
	public String save(@Valid User user, BindingResult result, Model m) throws Exception {
		System.out.println("result = " + result);
		System.out.println("user = " + user);
		
		// ���� ���� = Validator�� ���� �����ϰ�, validate()�� ���� ȣ��
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, result); //BindingResult�� Errors �������̽��� �ڼ�
		
		//User��ü�� ������ ��� ������ ������, registerForm�� �̿��ؼ� ������ ������� ��.
		if(result.hasErrors()) {
			return "registerForm";
		}
		
//		// 1. 유효성 검사
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "utf-8");
//			
//			m.addAttribute("msg", msg);
//			return "forward:/register/add"; // 신규회원 가입화면으로 이동(redirect)
//			//return "redirect:/register/add?msg="+msg; //URL재작성(rewriting)
//		}
		
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