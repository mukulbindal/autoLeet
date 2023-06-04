package com.mukul.leetcode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukul.leetcode.utils.SeleniumUtil;

@RestController
public class LeetcodeController {
	@GetMapping(path = "/leetcode/submit")
	public String submitLeetcode() {
		try {
			SeleniumUtil.submit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return "Some error occured";
		}
		return "Success";
	}
}
