/**
 * 
 */
package com.care.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.care.business.Medicine;
import com.care.business.User;

/**
 * @author abdra
 *
 */
@Repository
public class DonationDaoImpl implements DonationDao {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	DonatedMedicineRepository donatedMedicineRepository;
	
	@Autowired
	RequestedMedicineRepository requestedMedicineRepository;
	

	@Override
	public User getUser(String emailId, String pd, int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public int addUserProfile(User user)  throws Exception{
		
		System.out.println(">addUserProfile");
		
		UserProfile uprofile = new UserProfile();
		uprofile.setFirstName(user.getFirstName());
		uprofile.setLastName(user.getLastName());
		uprofile.setEmailId(user.getEmailId());
		uprofile.setPhoneNo(user.getPhoneNo());
		uprofile.setPd(user.getPwd());
		if(user.getAddress()!=null) {
			List<Address> address = new ArrayList<Address>();
			Address add = new Address();
			add.setLine(user.getAddress().getLine());
			add.setCity(user.getAddress().getCity());
			add.setState(user.getAddress().getState());
			add.setZipCode(user.getAddress().getZipCode());
			address.add(add);
			uprofile.setAddress(address);
		}
		userRepository.save(uprofile);
		
		System.out.println("Added User: "+uprofile.getId());
		System.out.println("< addUserProfile");
		
		return (int) uprofile.getId();
	}

	@Override
	public boolean addMedicines(int uid, List<Medicine> medicines) throws Exception {
		System.out.println(">addMedicines");
		
		if(medicines!=null) {
			for(Medicine m : medicines) {
				com.care.dao.DonatedMedicine med = new com.care.dao.DonatedMedicine();
				med.setName(m.getName());
				med.setType(m.getType());
				med.setPower(m.getPower());
				med.setQuantity(m.getQuantity());
				med.setDonatedBy(uid);
				med.setStatus("PENDING");
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				date = sdf.parse(m.getExpiryDate());
				med.setExpiryDate(date);
				
				donatedMedicineRepository.save(med);
			}
		}
		
		System.out.println("<added Medicines");
		return true;
	}
	
	@Override
	public boolean requestMedicines(int uid, List<Medicine> medicines) throws Exception {
		System.out.println(">requestMedicines");
		
		if(medicines!=null) {
			for(Medicine m : medicines) {
				com.care.dao.RequestedMedicine med = new com.care.dao.RequestedMedicine();
				med.setName(m.getName());
				med.setType(m.getType());
				med.setPower(m.getPower());
				med.setQuantity(m.getQuantity());
				med.setRequestedBy(uid);
				med.setStatus("PENDING");
				Calendar cal = Calendar.getInstance();
				med.setRequestedDate(cal.getTime());
				
				requestedMedicineRepository.save(med);
			}
		}
		
		System.out.println("<requested Medicines");
		return true;
	}

	@Override
	public Map<Medicine, User> getAllDonatedMedicines() throws Exception {

		System.out.println(">getAllDonatedMedicines");
		Map<Medicine, User> medicineMap = new HashMap<>();
		List<DonatedMedicine> donatedMedicine = (List<DonatedMedicine>) donatedMedicineRepository.findAll();
		if(donatedMedicine!=null && !donatedMedicine.isEmpty()) {
			for(DonatedMedicine m : donatedMedicine) {
				Medicine med = new Medicine();
				med.setId(m.getId());
				med.setName(m.getName());
				med.setType(m.getType());
				med.setPower(m.getPower());
				med.setQuantity(m.getQuantity());
				med.setStatus(m.getStatus());
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				String date  = sdf.format(m.getExpiryDate());
				med.setExpiryDate(date);
				
				Long id = (long) m.getDonatedBy();
				UserProfile up = userRepository.getById(id);
				
				User user = new User();
				user.setFirstName(up.getFirstName());
				user.setLastName(up.getLastName());
				user.setPhoneNo(up.getPhoneNo());
				user.setEmailId(up.getEmailId());
				
				com.care.business.Address add = new com.care.business.Address();
				add.setLine(up.getAddress().get(0).getLine());
				add.setCity(up.getAddress().get(0).getCity());
				add.setState(up.getAddress().get(0).getState());
				add.setZipCode(up.getAddress().get(0).getZipCode());
				user.setAddress(add);
				
				medicineMap.put(med, user);
			}
		}
		
		System.out.println("<getAllDonatedMedicines");
		return medicineMap;
	}

	@Override
	public Map<Medicine, User> getAllRequestedMedicines() throws Exception {
		System.out.println(">getAllDonatedMedicines");
		Map<Medicine, User> medicineMap = new HashMap<>();
		List<RequestedMedicine> requestedMedicine = (List<RequestedMedicine>) requestedMedicineRepository.findAll();
		if(requestedMedicine!=null && !requestedMedicine.isEmpty()) {
			for(RequestedMedicine m : requestedMedicine) {
				Medicine med = new Medicine();
				med.setName(m.getName());
				med.setType(m.getType());
				med.setPower(m.getPower());
				med.setQuantity(m.getQuantity());
				med.setStatus(m.getStatus());
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				String date  = sdf.format(m.getRequestedDate());
				med.setRequestedDate(date);
				
				Long id = (long) m.getRequestedBy();
				UserProfile up = userRepository.getById(id);
				
				User user = new User();
				user.setFirstName(up.getFirstName());
				user.setLastName(up.getLastName());
				user.setPhoneNo(up.getPhoneNo());
				user.setEmailId(up.getEmailId());
				
				com.care.business.Address add = new com.care.business.Address();
				add.setLine(up.getAddress().get(0).getLine());
				add.setCity(up.getAddress().get(0).getCity());
				add.setState(up.getAddress().get(0).getState());
				add.setZipCode(up.getAddress().get(0).getZipCode());
				user.setAddress(add);
				
				medicineMap.put(med, user);
			}
		}
		
		System.out.println("<getAllDonatedMedicines");
		return medicineMap;
	}

	@Override
	public boolean updateDonatedMedicine(Medicine m) throws Exception {
		System.out.println(">updateMedicines");
		
		com.care.dao.DonatedMedicine med = new com.care.dao.DonatedMedicine();
		med.setId(m.getId());
		med.setName(m.getName());
		med.setType(m.getType());
		med.setPower(m.getPower());
		med.setQuantity(m.getQuantity());
		med.setStatus(m.getStatus());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		date = sdf.parse(m.getRecievedDate());
		med.setRecievedDate(date);
		
		donatedMedicineRepository.save(med);
		
		System.out.println("<update Medicines");
		return true;
	}

	@Override
	public boolean updateRequestedMedicine(Medicine m) throws Exception {
		
		System.out.println(">updateRequestedMedicines");
		
		com.care.dao.RequestedMedicine med = new com.care.dao.RequestedMedicine();
		med.setId(m.getId());
		med.setName(m.getName());
		med.setType(m.getType());
		med.setPower(m.getPower());
		med.setQuantity(m.getQuantity());
		med.setStatus(m.getStatus());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		date = sdf.parse(m.getDonatedDate());
		med.setDonatedDate(date);
		
		requestedMedicineRepository.save(med);
		
		System.out.println("<updateRequestedMedicines");
		return true;
	}

}
