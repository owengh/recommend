package com.cognition.bl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cognition.bl.domain.Emp;
/**
 * 参数一：需要映射的实体
 * 参数二：实体里面的OID的类型
 * @author lenovo
 *
 */
public interface EmpRepository extends JpaRepository<Emp, Integer>,JpaSpecificationExecutor<Emp>{
	
	//查询name(驼峰式名称)
	public List<Emp> findByName(String name);
	public List<Emp> findByNameAndGender(String name,String gender);
	public List<Emp> findByTelephoneLike(String telphone);
	
	@Query("from Emp where name = ?")
	public List<Emp> queryName(String name);
	
	@Query(value="select * from t_emp where name = ?",nativeQuery=true)
	public List<Emp> queryName2(String name);
	
	@Query("update Emp set address = ? where id = ?")
	@Modifying // 进行修改操作
	public void updateAddressById(String address,Integer id);
}
