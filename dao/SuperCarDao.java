package com.onesoft.supercar.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onesoft.supercar.entity.SuperCar;
import com.onesoft.supercar.repository.SuperCarRepository;

@Repository
public class SuperCarDao {
	
	@Autowired
	SuperCarRepository sr;

	public String list(List<SuperCar> car) {
		sr.saveAll(car  );
		return "Succes";
	}

	public List<SuperCar> getAll() {
		return sr.findAll();
		}

	public String add(SuperCar ad) {
		sr.save(ad);
		return "Save";
	}

	public String delete(int id) {
		sr.deleteById(id);
		return "deleted";
	}
	
	public List<SuperCar> col(String colour){
		return sr.col(colour);
	}

	public SuperCar maxq() {
		return sr.maxq();
	}
	
	public SuperCar minq() {
		return sr.minq();
	}

	public List<SuperCar> pri(int price) {
		return sr.pri(price);
	}

	public List<SuperCar> mil(int milage) {
		return sr.mil(milage);
	}
	
	public List<SuperCar> brand(String brand){
		return sr.brand(brand);
	}
	
	public List<SuperCar> cc(int cc){
		return sr.cc(cc);
	}

	public String det(SuperCar detail) {
		sr.save(detail);
		return "Saved";
	}

	public String chkbr(SuperCar detail) {
		sr.save(detail);
		return "Succesfully saved";
	}

	public String chkclr(SuperCar colour) {
		sr.save(colour);
		return "Saved";
	}

	public String chkcc(SuperCar cc) {
		sr.save(cc);
		return "saved";
	}

}
