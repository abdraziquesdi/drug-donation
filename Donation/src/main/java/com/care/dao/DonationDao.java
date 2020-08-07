/**
 * 
 */
package com.care.dao;

import java.util.List;
import java.util.Map;

import com.care.business.Medicine;
import com.care.business.User;

/**
 * @author abdra
 *
 */
public interface DonationDao {

	User getUser(String emailId, String pd, int id) throws Exception;
	
	int addUserProfile(User user)  throws Exception;
	
	boolean addMedicines(int uid, List<Medicine> medicines) throws Exception;
	
	boolean requestMedicines(int uid, List<Medicine> medicines) throws Exception;
	
	Map<Medicine, User> getAllDonatedMedicines()  throws Exception;
	
	Map<Medicine, User> getAllRequestedMedicines()  throws Exception;
	
	boolean updateDonatedMedicine(Medicine medicine) throws Exception;
	
	boolean updateRequestedMedicine(Medicine medicine) throws Exception;
	
}
