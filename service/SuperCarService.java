package com.onesoft.supercar.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onesoft.supercar.dao.SuperCarDao;
import com.onesoft.supercar.entity.SuperCar;
import com.onesoft.supercar.exception.BrandNotFound;
import com.onesoft.supercar.exception.CcNotAvailable;
import com.onesoft.supercar.exception.ColourNotFound;
import com.onesoft.supercar.exception.MilageNotAvailable;
import com.onesoft.supercar.exception.PriceNotAvailable;

@Service
public class SuperCarService {
	
	@Autowired
	SuperCarDao sd;

	public String list(List<SuperCar> car) {
		return sd.list(car);
	}

	public SuperCar min() {
		List<SuperCar> b = sd.getAll();
		SuperCar c = b.stream().min(Comparator.comparingInt(SuperCar::getPrice)).get();
		return c;
	}

	public String add(SuperCar ad) {
		return sd.add(ad);
	}

	public String delete(int id) {
		return sd.delete(id);
	}
	
	public List<SuperCar> col(String colour) throws ColourNotFound {
		List<SuperCar> c = sd.col(colour);
		if(c.isEmpty()) {
			throw new ColourNotFound("Not Available");
		}
		else {
			return c;
		}
	}

	public SuperCar maxq() {
		return sd.maxq();
	}

	public SuperCar minq() {
		return sd.minq();
	}

	public List<SuperCar> pri(int price) throws PriceNotAvailable{
		List<SuperCar> c = sd.pri(price);
		if(c.isEmpty()) {
			throw new PriceNotAvailable("Price MisMatch");
		}
		else {
			return c;
		}
	}

	public List<SuperCar> mil(int milage) throws MilageNotAvailable {
		List<SuperCar> b = sd.mil(milage);
		if(b.isEmpty()) {
			throw new MilageNotAvailable("Milage Not Available");
		}
		else {
			return b;
		}
	}
	
	public List<SuperCar> brand(String brand)throws BrandNotFound{
		List<SuperCar> b = sd.brand(brand);
		if(b.isEmpty()) {
			throw new BrandNotFound("out of stock");
		}
		else {
			return b;
		}
	}

	public List<SuperCar> cc(int cc) throws CcNotAvailable {
		List<SuperCar> b = sd.cc(cc);
		if(b.isEmpty()) {
			throw new CcNotAvailable("Sorry not available");
		}
		return b;
	}

	public String det(SuperCar detail) throws PriceNotAvailable {
		if(detail.getPrice()<100000) {
			throw new PriceNotAvailable("Low Price");
		}
		else {
			return sd.det(detail);
		}
	}

	public String chkbr(SuperCar detail) throws BrandNotFound {
		if(detail.getBrand().length()<5) {
			throw new BrandNotFound("Brand name must contail atleast 5 character");
		}
		else {
			return sd.chkbr(detail);
		}
	}
	
	public String chkclr(SuperCar colour) throws ColourNotFound {
		if(colour.getColour().equals("purple")) {
			throw new ColourNotFound("we don't accept this colour");
		}
		else {
			return sd.chkclr(colour);
		}
	}
	
	public String chkcc(SuperCar cc) throws CcNotAvailable {
		if(cc.getCc()<500) {
			throw new CcNotAvailable("it's not Supercar, CC is too low...");	
		}
		else {
			return sd.chkcc(cc);
		}
	}
	

}
