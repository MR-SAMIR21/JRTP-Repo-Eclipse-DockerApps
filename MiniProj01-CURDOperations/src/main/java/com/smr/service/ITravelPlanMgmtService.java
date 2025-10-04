package com.smr.service;

import java.util.List;
import java.util.Map;

import com.smr.entity.TravelPlan;

public interface ITravelPlanMgmtService {

	public String registerTravelPlan(TravelPlan plan); //save operation
	public Map<Integer, String> getTravelPlanCategories(); //for select operation
	public List<TravelPlan> showAllTravelPlan(); //for select operation
	public TravelPlan showTravelPlanById(Integer planId); //for edit operation (To show the existing record for editing)
	public String updateTravelPlan(TravelPlan plan); // for edit operation for submission
	public String deleteTravelPlan(Integer planId); // for deletion operation (hard deletion)
	public String changeTravelPlanStatus(Integer planId,String status);// for soft deletion activity
	
}
