package com.smr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smr.entity.PlanCategory;

public interface IPlanCategoryRepository extends JpaRepository<PlanCategory, Integer> {

}
