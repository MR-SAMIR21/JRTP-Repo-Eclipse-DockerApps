package com.smr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smr.entity.TravelPlan;

public interface ITravelPlanRepository extends JpaRepository<TravelPlan, Integer> {

}
