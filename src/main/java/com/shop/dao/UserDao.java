package com.shop.dao;

import com.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface UserDao extends JpaRepository<User, Integer> {
	
// 1) �� ������ ����� ���������� ������ ����� �� ������	
//	@Query("select u from User u where u.name=:param1 and u.email=:param2")
//	User findUserByNameEmail(@Param("param1")String name, @Param("param2")String email);

// 2) �� ������ ����� ���������� ������ ����� �� ������(����������� ���, �� � ������� findBy
	// � �� �� ���� ��������, �� ��� ��@Query("select u from User u where u.name=:param1 and u.email=:param2")
	 // ����� �������� ������
	 
	User findByLastNameAndEmail(String name, String email);

	@Query("select u from User u left join fetch u.products where u.id=:id")
	User findUserWithProducts(@Param("id") int id);

	User findByFirstName(String firstName);

	User findByLastName(String lastName);

	User findByEmail(String email);

	User findByNumberPhone(String phone);

	@Query("select distinct u from User u left join fetch u.specefications where u.id=:id")
	User findUserWithSpecefications(@Param("id") int id);

	@Query("select u from User u where u.uuid =:uuid")
	User findByUuid(@Param("uuid") String uuid);





}
