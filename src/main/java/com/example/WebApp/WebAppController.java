package com.example.WebApp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/WebApp")
public class WebAppController {
@GetMapping(value="/get")	
public String getthis() {
	return "hello";
}

@GetMapping(value="/vendhan/{a}/{b}")	
public String getName(@PathVariable String a, @PathVariable String b) {
	return a+" "+b;
}

@GetMapping(value="/salary/{c}/{d}")
public int getprice(@PathVariable int c, @PathVariable int d ) {
	return c+d;
}
	
@GetMapping(value="/rev/{a}")
public String getMethodname(@PathVariable String a) {
	String str=" ";
	for(int i=a.length()-1; i>=0; i--) {
str=str+a.charAt(i);
	}
	return str;
}

@GetMapping(value="/prime/{a}/{b}")
public ArrayList<Integer> prime(@PathVariable int a, @PathVariable int b) {
	ArrayList<Integer>prime=new ArrayList<>();
for(int i=a; i<=b; i++) {
	boolean temp=true;
	for(int j=2; j<i; j++) {
		if(i%j==0) {
			temp=false;
		}
		}
	if(temp==true) {
		prime.add(i);
	}
}
return prime;

}
@GetMapping(value="/getCar")
public Car getthis(@RequestBody Car c) {
	return c;
}

@GetMapping(value="/getListc")
public List<Car> getthis1(@RequestBody List<Car> car) {
	return car;
}

@GetMapping(value="/getCarr")
public int getthis1(@RequestBody Car c) {
	return c.getPrice();
}

@GetMapping(value="/getListcarrr")
public List<Car> getthis11(@RequestBody List<Car> car) {
	return car.stream().filter(X->X.getPrice()<3000 && X.getPrice()>1000).collect(Collectors.toList());
}
@GetMapping(value="/gettax")
public Car getthis11(@RequestBody Car c) {
c.setPrice(c.getPrice()+1000);
return c;		
}

@GetMapping(value="/dupliuni/{a}")
public String Word(@PathVariable String a) {	
	String result=Names(a);
	return result;
}
public String Names(@PathVariable String a) {
	Map<Character, Long> characters=a.chars().mapToObj(C->(char)C).collect(Collectors.groupingBy(C->C, Collectors.counting()));
	StringBuilder objects =new StringBuilder();

	characters.entrySet().stream().filter(X->X.getKey().isLowerCase(X.getKey())).filter(X->X.getKey()>1)
	.forEach(X->objects.append(X.getKey()));
  
	characters.entrySet().stream().filter(X->X.getKey().isUpperCase(X.getKey())).filter(X->X.getKey()==1)
	.forEach(X->objects.append(X.getKey()));
	
	return objects.toString();	
}


}

