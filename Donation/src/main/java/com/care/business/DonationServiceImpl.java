/**
 * 
 */
package com.care.business;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.care.dao.DonationDao;

/**
 * @author abdra
 *
 */
@Service
public class DonationServiceImpl implements DonationService{
	
	@Autowired
	private DonationDao donationDao;
	
	/**
	 * @param donationDao the donationDao to set
	 */
	public void setDonationDao(DonationDao donationDao) {
		this.donationDao = donationDao;
	}

	@Override
	public User getUser(String emailId, String pd, int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int addUserProfile(User user) throws Exception {
		return donationDao.addUserProfile(user);
	}

	@Override
	public boolean addMedicines(int uid, List<Medicine> medicines) throws Exception {
		return donationDao.addMedicines(uid, medicines);
	}

	@Override
	public boolean requestMedicines(int uid, List<Medicine> medicines) throws Exception {
		return donationDao.requestMedicines(uid, medicines);
	}

	@Override
	public Map<Medicine, User> getAllDonatedMedicines() throws Exception {
		return donationDao.getAllDonatedMedicines();
	}

	@Override
	public Map<Medicine, User> getAllRequestedMedicines() throws Exception {
		return donationDao.getAllRequestedMedicines();
	}

	@Override
	public boolean updateDonatedMedicine(Medicine medicine) throws Exception {
		return donationDao.updateDonatedMedicine(medicine);
	}

	@Override
	public boolean updateRequestedMedicine(Medicine medicine) throws Exception {
		return donationDao.updateRequestedMedicine(medicine);
	}

}
