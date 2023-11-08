package com.onesoft.supercar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onesoft.supercar.entity.SuperCar;
import com.onesoft.supercar.exception.BrandNotFound;
import com.onesoft.supercar.exception.CcNotAvailable;
import com.onesoft.supercar.exception.ColourNotFound;
import com.onesoft.supercar.exception.MilageNotAvailable;
import com.onesoft.supercar.exception.PriceNotAvailable;
import com.onesoft.supercar.service.SuperCarService;

import jakarta.persistence.Entity;

@RestController
@RequestMapping("/superdetail")
public class SuperCarController {
	
	@Autowired
	SuperCarService ss;
	
	@PostMapping("/list")
	public String list(@RequestBody List<SuperCar> car){
		return ss.list(car);
	}
	
	@GetMapping("minprice")
	public SuperCar min() {
		return ss.min();
	}
	
	@PutMapping("/add")
	public String add(@RequestBody SuperCar ad) {
		return ss.add(ad);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return ss.delete(id);
	}
	
	@GetMapping("col/{colour}")
	public List<SuperCar> col(@PathVariable String colour) throws ColourNotFound{
		return ss.col(colour);
	} 
	
	@GetMapping("/maxq")
	public SuperCar maxq() {
		return ss.maxq();
	}
	
	@GetMapping("/minq")
	public SuperCar minq() {
		return ss.minq();
	}
	
	@GetMapping("price/{price}")
	public List<SuperCar> pri(@PathVariable int price)throws PriceNotAvailable {
		return ss.pri(price);
	}
	
	@GetMapping("milage/{milage}")
	public List<SuperCar> mil(@PathVariable int milage) throws MilageNotAvailable{
		return ss.mil(milage);
	}
	
	@GetMapping("brand/{brand}")
	public List<SuperCar> brand(@PathVariable String brand)throws BrandNotFound{
		return ss.brand(brand);
	}
	
	@GetMapping("cc/{cc}")
	public List<SuperCar> cc(@PathVariable int cc) throws CcNotAvailable{
		return ss.cc(cc);
	}
	
	@PostMapping("checkprice")
	public String det(@RequestBody SuperCar detail) throws PriceNotAvailable {
		return ss.det(detail);
	}
	
	@PostMapping("checkbrand")
	public String chkbr(@RequestBody SuperCar detail) throws BrandNotFound {
		return ss.chkbr(detail);
	}
	
	@PostMapping("checkcolour")
	public String chkclr(@RequestBody SuperCar colour) throws ColourNotFound {
		return ss.chkclr(colour);
	}
	
	@PostMapping("checkcc")
	public String chkcc(@RequestBody SuperCar cc) throws CcNotAvailable {
		return ss.chkcc(cc);
	}

}
