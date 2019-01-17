package edu.poly.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.poly.spring.model.Student;
import edu.poly.spring.service.HobbyService;
import edu.poly.spring.service.StudentService;
import edu.poly.spring.validator.StudentValidator;

@Controller
@RequestMapping("/account")
public class StudentController {

	@Autowired
	private StudentValidator studentValidator;

	@Autowired
	private StudentService studentService;

	@Autowired
	private HobbyService hobbyService;

	@GetMapping
	public String defaultRequest(Model model) {
		model.addAttribute("msg", "Spring BOOT");

		return "index";
	}

	@GetMapping({ "/dang-ky", "/register" })
	public String createStudent(Model model) {
		model.addAttribute("list", hobbyService.getAllHobbies());
		model.addAttribute("student", new Student());

		return "student/addStudent";
	}

	@PostMapping({ "/dang-ky", "/register" })
	public String createStudent(Model model, Student student, // @ModelAttribute("student") Student student,
			@RequestParam MultipartFile file, @RequestParam(required = false) String[] hobbies,
			BindingResult bindingResult) {
		studentValidator.validate(student, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("list", hobbyService.getAllHobbies());

			return "student/addStudent";
		}

		if (hobbies != null) {
			String hbies = "";
			for (String item : hobbies) {
				hbies += item + ", ";
			}
			student.setHobby(hbies);
		}

		if (file != null) {
			student.setAvatar(file.getOriginalFilename());
		}

		studentService.addStudent(student);

		return "redirect:/account/danh-sach-student";
	}

	@GetMapping("/danh-sach-student")
	public String getAllStudents(Model model) {
		model.addAttribute("listStudents", studentService.getAllStudents());
		model.addAttribute("sizeListStudent", studentService.getAllStudents().size());

		return "student/listStudent";
	}

	@GetMapping("/edit/{id}")
	public String editStudent(Model model, @PathVariable int id) {
		model.addAttribute("list", hobbyService.getAllHobbies());
		model.addAttribute("student", studentService.getStudentById(id));

		return "student/editStudent";
	}

	@GetMapping("/delete/{id}")
	public String removeStudent(@PathVariable int id) {
		studentService.removeStudent(id);

		return "redirect:/account/danh-sach-student";
	}

	@PostMapping({ "/edit" })
	public String editStudent(Model model, Student student, // @ModelAttribute("student") Student student,
			@RequestParam MultipartFile file, @RequestParam(required = false) String[] hobbies,
			BindingResult bindingResult) {
		studentValidator.validate(student, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("list", hobbyService.getAllHobbies());

			return "student/editStudent";
		}

		if (hobbies != null) {
			String hbies = "";
			for (String item : hobbies) {
				hbies += item + ", ";
			}
			student.setHobby(hbies);
		}

		if (file != null) {
			student.setAvatar(file.getOriginalFilename());
		}

		studentService.updateStudent(student);

		return "redirect:/account/danh-sach-student";
	}

}
