package com.demo.MyFirstWeb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyWebController {
	
	@GetMapping(value = "/Hello")
	public String name() {
		return "Yuva";
	}

	@GetMapping(value = "/myWeb")
	public int age() {
		return 23;
	}

	@GetMapping(value = "/Myweb1/{a}")
	public String name1(@PathVariable String a) {
		return a;
	}

	@GetMapping(value = "/user/{id}/{role}")
	public String userDetails(@PathVariable int id, @PathVariable String role) {
		return "User ID: " + id + ", Role: " + role;
	}

	@GetMapping(value = "/even-numbers/{limit}")
	public List<Integer> getEvenNumbers(@PathVariable int limit) {
		List<Integer> evenNumbers = new ArrayList<>();

		for (int i = 1; i <= limit; i++) {

			if (i % 2 == 0) {
				evenNumbers.add(i);
			}
		}

		return evenNumbers;
	}

	@GetMapping(value = "/max/{a}/{b}")
	public int getMax(@PathVariable int a, @PathVariable int b) {

		if (a > b) {
			return a;
		} else {
			return b;
		}
	}

	@GetMapping(value = "/login")
	public String getLogin(@RequestParam String a, @RequestParam String b) {

		if (a.equals("Yuva@2002") && b.equals("Kumar@2002")) {
			return "Login accept";
		} else {
			return "Login not accept";
		}

	}

	@GetMapping(value = "/max1")
	public int getmax1(@RequestParam int[] a) {

		int max = a[0];

		for (int x : a) {
			if (x > max) {
				max = x;

			}
		}
		return max;
	}

	@GetMapping(value = "/prime")
	public String getPrime(@RequestParam int a) {

		boolean isPrime = true;

		for (int i = 2; i < a; i++) {
			if (a % i == 0) {

				isPrime = false;

			}

		}
		if (isPrime == true) {
			return "Prime Number";
		} else {
			return "Not Prime Number";
		}
	}

	@GetMapping(value = "/max2/{a}")
	public int getPalindrome(@PathVariable int a, @RequestParam int b, @RequestParam int c) {

	    if ((a > b) && (a > c)) {
	        return a;
	    } else if (b > c) {
	        return b;
	    } else {
	        return c;
	    }
	}


	@GetMapping(value = "/dublicate/{a}")
	public String getDuplicate(@PathVariable String a) {
		char[] a1 = a.toCharArray();

		for (int i = 0; i < a1.length; i++) {
			int count = 0;

			for (int j = i + 1; j < a1.length; j++) {
				if (a1[i] == a1[j]) {
					count++;
					a1[j] = '#';
				}
			}

			if (count >= 0 && a1[i] != '#') {
				return "" + a1[i];
			}
		}

		return "No duplicates found";
	}

	@PostMapping(value = "/mobiles")
	public MyMobile getMobile(@RequestBody MyMobile v) {
		return v;
	}

	@PostMapping(value = "/mobiles1")
	public List<MyMobile> getmobiles(@RequestBody List<MyMobile> e) {
		return e;
	}

	@PostMapping(value = "/mobiles2")
	public MyMobile getMobile1(@RequestBody List<MyMobile> a) {
		MyMobile p1 = a.stream().max(Comparator.comparing(MyMobile::getPrice)).get();
		return p1;
	}
	
	
	@GetMapping(value ="/yuva")
	public String getName() {
		return "Yuva";
		
	}
}
