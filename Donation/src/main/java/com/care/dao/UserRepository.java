/**
 * 
 */
package com.care.dao;

import org.springframework.data.repository.CrudRepository;

/**
 * @author abdra
 *
 */
public interface UserRepository extends CrudRepository<UserProfile, Long> {

	UserProfile getById(Long id);
}
