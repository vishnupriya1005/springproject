package com.onesoft;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class Sample {
	@GetMapping(value = "/hi")
	public String Hi() {
		return "Hello World";
	}

	@GetMapping(value = "/myname")
	public String Name() {
		return "Hi this is VishnupriyaKalyanaraman";
	}

	@GetMapping(value = "/add/{a}/{b}")
	public int add(@PathVariable int a, @PathVariable int b) {
		return a + b;
	}

	@GetMapping(value = "/factorial/{a}")
	public int factorial(@PathVariable int a) {
		int val = 1;
		for (int i = 1; i <= a; i++) {
			val = val * i;
		}
		return val;

	}

	@GetMapping(value = "/odd/{a}")
	public int odd(@PathVariable int a) {
		if (a % 2 == 1) {
			return a * a;
		} else {
			return a * a * a;
		}
	}

	@GetMapping(value = "/nonvowel/{a}")
	public int nonvowel(@PathVariable String a) {
		int count = 0;
		for (int i = 0; i < a.length() - 1; i++) {
			if (a.charAt(i) != 'a' && a.charAt(i) != 'e' && a.charAt(i) != 'i' && a.charAt(i) != 'o'
					&& a.charAt(i) != 'u') {
				count = count + 1;
			}
		}
		return count;
	}

	@RequestMapping(value = "/add/{a}")
	public int add(@PathVariable int a) {
		int sum = 0;
		for (sum = 0; a != 0; a = a / 10) {
			sum = sum + a % 10;
		}
		return sum;
	}

	@GetMapping(value = "/square/{a}")
	public List<Integer> square(@PathVariable int a) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i <= a; i++) {
			list.add(i * i);
		}
		return list;
	}

	@GetMapping(value = "/fibo/{v}")
	public List<Integer> fibo(@PathVariable int v) {
		int a = 0;
		int b = 1;
		int c = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= v; i++) {
			list.add(a);
			c = a + b;
			a = b;
			b = c;
		}
		return list;
	}

	@GetMapping(value = "/palin/{a}")
	public String palin(@PathVariable String a) {
		String b = "madam";
		for (int i = b.length() - 1; i > 0; i--) {
			if (b.equals(a)) {
				return "it is palindrome";
			} else {
				return "not a palindrome";
			}
		}
		return "program";
	}

	@GetMapping(value = "/getCar")
	public List<Car> getCar(@RequestBody List<Car> c) {
		return c;
	}

	@GetMapping(value = "/getAllCar")
	public Car getCar(@RequestBody Car c) {
		return c;
	}

	@GetMapping(value = "/maxPrice")
	public Car maxPrice(@RequestBody List<Car> c) {
		Car price = c.get(0);
		for (Car x : c) {
			if (x.getPrice() > price.getPrice()) {
				price = x;
			}
		}
		return price;

	}

	@GetMapping(value = "/minPrice")
	public int minPrice(@RequestBody List<Car> c) {
		Car price = c.get(0);
		for (Car x : c) {
			if (x.getPrice() < price.getPrice()) {
				price = x;
			}
		}
		return price.getPrice();
	}

	@GetMapping(value = "/color")
	public Car color(@RequestBody List<Car> c) {
		Car color = c.get(0);
		for (Car x : c) {
			if (x.getColor().equals("red")) {
				color = x;
			}
		}
		return color;
	}

	@GetMapping(value = "/color/{a}")
	public List<Car> color(@RequestBody List<Car> cars, @PathVariable String a) {
		List<Car> val = new ArrayList<>();
		for (Car x : cars) {
			if (x.getColor().equals(a)) {
				val.add(x);
			}
		}
		return val;
	}

	@GetMapping(value = "/price/{a}")
	public List<Car> price(@RequestBody List<Car> cars, @PathVariable int a) {
		List<Car> v = new ArrayList<>();
		for (Car x : cars) {
			if (x.getPrice() > a) {
				v.add(x);
			}
		}
		return v;
	}

	@GetMapping(value = "/gender/{a}")
	public List<Employee> gender(@RequestBody List<Employee> emp, @PathVariable String a) {
		List<Employee> val = new ArrayList<>();
		for (Employee x : emp) {
			if (x.getGender().equals(a)) {
				val.add(x);
			}
		}
		return val;
	}

	@GetMapping(value = "/maxsal")
	public Employee maxsal(@RequestBody List<Employee> emp) {
		Employee max = emp.get(0);
		for (Employee x : emp) {
			if (max.getSalary() < x.getSalary()) {
				max = x;
			}
		}
		return max;
	}

	@GetMapping(value = "/minsal")
	public Employee minsal(@RequestBody List<Employee> emp) {
		Employee min = emp.get(0);
		for (Employee x : emp) {
			if (min.getSalary() > x.getSalary()) {
				min = x;
			}
		}
		return min;
	}

	@GetMapping(value = "/salary")
	public List<Employee> getsal(@RequestBody List<Employee> emp) {
		for (Employee x : emp) {
			if (x.getSalary() < 35000 && x.getSalary() >= 25000) {
				x.setSalary(x.getSalary() + x.getSalary() * 20 / 100);
			} else if (x.getSalary() < 55000 && x.getSalary() >= 35000) {
				x.setSalary(x.getSalary() + x.getSalary() * 15 / 100);
			} else if (x.getSalary() <= 75000 && x.getSalary() >= 55000) {
				x.setSalary(x.getSalary() + x.getSalary() * 10 / 100);
			}
		}
		return emp;
	}
}
