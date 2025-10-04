package com.smr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smr.config.AppConfigProperties;
import com.smr.constants.TravelPlanConstants;
import com.smr.entity.PlanCategory;
import com.smr.entity.TravelPlan;
import com.smr.repository.IPlanCategoryRepository;
import com.smr.repository.ITravelPlanRepository;

@Service
public class TravelPlanMgmtServiceImpl implements ITravelPlanMgmtService {

	@Autowired
	private ITravelPlanRepository travelPlanRepo;
	@Autowired
	private IPlanCategoryRepository planCategoryRepo;
	
	private Map<String, String> messages;
	
	
	@Autowired
	public TravelPlanMgmtServiceImpl(AppConfigProperties props) {
		messages=props.getMessages();
		System.out.println("Messages::"+messages);
	}
	
	@Override
	public String registerTravelPlan(TravelPlan plan) {
		//save the object
		TravelPlan saved = travelPlanRepo.save(plan);
		/* if(saved.getPlanId()!=null)
			return "TravelPlan is saved with the id value :" +saved.getPlanId();
		else
			return "Problem in saving the TravelPlan";*/
		
//		return saved.getPlanId()!=null?messages.get("save-success")+saved.getPlanId() :messages.get("save-failure");
		return saved.getPlanId()!=null?messages.get(TravelPlanConstants.SAVE_SUCCESS)+saved.getPlanId() :messages.get(TravelPlanConstants.SAVE_FAILURE);

		
	}

	@Override
	public Map<Integer, String> getTravelPlanCategories() {
		// get All TravelPlan Categories
		List<PlanCategory> list = planCategoryRepo.findAll();
		Map<Integer, String> categoriesMap = new HashMap<Integer, String>();
		list.forEach(category ->{
			categoriesMap.put(category.getCategoryId(), category.getCategoryName());
		});
		return categoriesMap;
	}

	@Override
	public List<TravelPlan> showAllTravelPlan() {
		return travelPlanRepo.findAll();
	}

	@Override
	public TravelPlan showTravelPlanById(Integer planId) {
		/*Optional<TravelPlan> opt = travelPlanRepo.findById(planId);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new IllegalArgumentException("plan id not found");
		}*/
//		return travelPlanRepo.findById(planId).orElseThrow(()->new IllegalArgumentException("find-by-id-failure"));
		return travelPlanRepo.findById(planId).orElseThrow(()->new IllegalArgumentException(TravelPlanConstants.FIND_BY_ID_FAILURE));

	}

	
	@Override
	public String updateTravelPlan(TravelPlan plan) {
		
		Optional<TravelPlan> opt = travelPlanRepo.findById(plan.getPlanId());
		if (opt.isPresent()) {
			//update the object
			travelPlanRepo.save(plan);
//			return plan.getPlanId()+messages.get("update-success");
			return plan.getPlanId()+messages.get(TravelPlanConstants.UPDATE_SUCCESS);
		}
		else {
//			return plan.getPlanId()+messages.get( "update-failure");
			return plan.getPlanId()+messages.get(TravelPlanConstants.UPDATE_FAILURE);
		}

		   
	}

	@Override
	public String deleteTravelPlan(Integer planId) {
		Optional<TravelPlan> opt = travelPlanRepo.findById(planId);
		if (opt.isPresent()) {
			//update the object
			travelPlanRepo.deleteById(planId);
//			return planId+messages.get("delete-success");
			return planId+messages.get(TravelPlanConstants.DELETE_SUCCESS);
		}
		else {
//			return planId+messages.get("delete-failure");
			return planId+messages.get(TravelPlanConstants.DELETE_FAILURE);
		}
	}

	@Override
	public String changeTravelPlanStatus(Integer planId, String status) {
		Optional<TravelPlan> opt = travelPlanRepo.findById(planId);
		if (opt.isPresent()) {
			TravelPlan plan = opt.get();
			plan.setActiveSW(status);
			travelPlanRepo.save(plan);
//			return planId+messages.get("status-change-success");
			return planId+messages.get(TravelPlanConstants.STATUS_CHANGE_SUCCESS);
		}
		else {
//			return planId+messages.get("status-change-failure");
			return planId+messages.get(TravelPlanConstants.STATUS_CHANGE_FAILURE);
		}
	}

}
