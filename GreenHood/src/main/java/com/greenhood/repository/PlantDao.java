package com.greenhood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenhood.model.Plant;
import com.greenhood.model.PlantType;

public interface PlantDao extends JpaRepository<Plant, Integer>{
	
	//---------------------------Get Plant By Plant Type ------------------
	public List<Plant> findByPlantType(PlantType plantType);
}
