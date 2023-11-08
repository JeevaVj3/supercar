package com.onesoft.supercar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.onesoft.supercar.entity.SuperCar;

public interface SuperCarRepository extends JpaRepository<SuperCar, Integer>{

	@Query(value = "select * from supercar where colour like ?", nativeQuery = true)
	List<SuperCar> col(String a);

	@Query(value = "select * from supercar where price = ( select max(price) from supercar)", nativeQuery = true)
	SuperCar maxq();

	@Query(value = "select * from supercar where price = (select min(price) from supercar)", nativeQuery = true)
	SuperCar minq();

	@Query(value = "select * from supercar where price = ?", nativeQuery = true)
	List<SuperCar> pri(int price);

	@Query(value = "select * from supercar where milage >?", nativeQuery = true)
	List<SuperCar> mil(int milage);

	@Query(value = "select * from supercar where brand like ?%", nativeQuery = true)
	List<SuperCar> brand(String brand);

	@Query(value = "select * from supercar where cc >?", nativeQuery = true)
	List<SuperCar> cc(int cc);

}
