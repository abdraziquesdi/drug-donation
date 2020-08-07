/**
 * 
 */
package com.care.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.care.business.DonationService;
import com.care.business.Medicine;
import com.care.business.User;

/**
 * @author abdra
 *
 */
@RestController
public class DonationController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	
	@Autowired
	private DonationService donationService;

	@RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
	public String welcome(@PathVariable("id") String id,  Map<String, Object> model) {
		model.put("message", this.message);
		return this.message+" "+id;
	}
	
	@RequestMapping(value = "/userprofile", method = RequestMethod.POST)
	public Map<String, Object> addUserProfile(@RequestBody User user,  Map<String, Object> model) {
		
		Map<String,Object> response = new HashMap<String,Object>();
		boolean status = false;
		
		try {
			System.out.println("First NAme: " + user.getFirstName());
			int uid = donationService.addUserProfile(user);
			response.put("uid", uid);
			status = true;
		} catch (Exception e) {
			System.out.println("exception caught: " + e);
		}
		
		response.put("status", status);
		response.put("timeStamp", Calendar.getInstance().getTime());
		return response;
	}
	
	@RequestMapping(value = "/userprofile/{uid}/donatemedicines", method = RequestMethod.POST)
	public Map<String, Object> addMedicines(@PathVariable("uid") String uid, 
						@RequestBody List<Medicine> medicines,  Map<String, Object> model) {
		
		Map<String,Object> response = new HashMap<String,Object>();
		boolean status = false;
		
		try {
			donationService.addMedicines(Integer.valueOf(uid), medicines);
			status = true;
		} catch (Exception e) {
			System.out.println("exception caught: " + e);
			e.printStackTrace();
		}
		response.put("status", status);
		response.put("timeStamp", Calendar.getInstance().getTime());
		return response;
	}
	
	@RequestMapping(value = "/userprofile/{uid}/requestmedicines", method = RequestMethod.POST)
	public Map<String, Object> requestMedicines(@PathVariable("uid") String uid, 
						@RequestBody List<Medicine> medicines,  Map<String, Object> model) {
		
		Map<String,Object> response = new HashMap<String,Object>();
		boolean status = false;
		
		try {
			donationService.requestMedicines(Integer.valueOf(uid), medicines);
			status = true;
		} catch (Exception e) {
			System.out.println("exception caught: " + e);
			e.printStackTrace();
		}
		response.put("status", status);
		response.put("timeStamp", Calendar.getInstance().getTime());
		return response;
	}
	
	@RequestMapping(value = "/admin/donatedmedicines", method = RequestMethod.GET)
	public Map<String, Object> getDonatedMedicines(Map<String, Object> model) {
		
		Map<String,Object> response = new HashMap<String,Object>();
		boolean status = false;
		
		try {
			List<Medicine> donatedMedicine = new ArrayList<>();
			Map<Medicine, User> medicineMap = donationService.getAllDonatedMedicines();
			donatedMedicine.addAll(medicineMap.keySet());
			response.put("donatedMedicines", donatedMedicine);
			status = true;
		} catch (Exception e) {
			System.out.println("exception caught: " + e);
			e.printStackTrace();
		}
		response.put("status", status);
		response.put("timeStamp", Calendar.getInstance().getTime());
		return response;
	}
	
	@RequestMapping(value = "/admin/requestedmedicines", method = RequestMethod.GET)
	public Map<String, Object> getRequestedMedicines(Map<String, Object> model) {
		
		Map<String,Object> response = new HashMap<String,Object>();
		boolean status = false;
		
		try {
			List<Medicine> requestedMedicine = new ArrayList<>();
			Map<Medicine, User> medicineMap = donationService.getAllRequestedMedicines();
			requestedMedicine.addAll(medicineMap.keySet());
			response.put("requestedMedicines", requestedMedicine);
			status = true;
		} catch (Exception e) {
			System.out.println("exception caught: " + e);
			e.printStackTrace();
		}
		response.put("status", status);
		response.put("timeStamp", Calendar.getInstance().getTime());
		return response;
	}
	
	@RequestMapping(value = "/admin/donatedmedicines", method = RequestMethod.PUT)
	public Map<String, Object> updateDonatedMedicines(@RequestBody Medicine medicine,  Map<String, Object> model) {
		
		Map<String,Object> response = new HashMap<String,Object>();
		boolean status = false;
		
		try {
			donationService.updateDonatedMedicine(medicine);
			status = true;
		} catch (Exception e) {
			System.out.println("exception caught: " + e);
			e.printStackTrace();
		}
		response.put("status", status);
		response.put("timeStamp", Calendar.getInstance().getTime());
		return response;
	}
	
	@RequestMapping(value = "/admin/requestedmedicines", method = RequestMethod.PUT)
	public Map<String, Object> updatedRequestedMedicines(@RequestBody Medicine medicine, Map<String, Object> model) {
		
		Map<String,Object> response = new HashMap<String,Object>();
		boolean status = false;
		
		try {
			donationService.updateRequestedMedicine(medicine);
			status = true;
		} catch (Exception e) {
			System.out.println("exception caught: " + e);
			e.printStackTrace();
		}
		response.put("status", status);
		response.put("timeStamp", Calendar.getInstance().getTime());
		return response;
	}
}
