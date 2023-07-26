package com.ys.sbbs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/rest")

public class RestController {
	@GetMapping("/hello")
	public String hello() {
		return "<h1>Hello World!!!</h1>";
	}
}
