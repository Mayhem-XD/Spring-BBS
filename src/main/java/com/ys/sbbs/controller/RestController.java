package com.ys.sbbs.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sbbs/rest")

public class RestController {
	@RequestMapping("/hello")
	public String hello() {
		return "<h1>Hello World!!!</h1>";
	}
}
