package xyz.springboot.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class SimpleController {
	
	@GetMapping("/hello")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:18080")
	public String hello(Model model) {
		model.addAttribute("name","dahun");
		return "hello";
	}
	
	@GetMapping("/test")
	@ResponseBody
	public EntityModel<Sample> test() {
		System.out.println("확인");
		Sample sample = new Sample();
		sample.setPrefix("Hey,");
		sample.setName("dahun");
		EntityModel<Sample> sampleResource = new EntityModel<>(sample);
		sampleResource.add(linkTo(methodOn(SimpleController.class).test()).withSelfRel());
		return sampleResource;
	}
	
	@GetMapping("/errors")
	public String error() {
		System.out.println("확인");
		throw new SampleException();
	}
	
	@ExceptionHandler(SampleException.class)
	@ResponseBody
	public AppError smapleError(SampleException e) {
		AppError appError = new AppError();
		
		appError.setMessage("error.app.key");
		appError.setReason("IDK IDK IDK");
		return appError;
	}
	
}
