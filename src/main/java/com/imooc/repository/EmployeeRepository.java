package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public abstract class EmployeeRepository implements JpaRepository<Employee,Integer> {

    public abstract Employee findByName(String name);

    // where name like ?% and age <?
    public abstract List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    // where name like %? and age <?
    public abstract List<Employee> findByNameEndingWithAndAgeLessThan(String name, Integer age);

    // where name in (?,?....) or age <?
    public abstract List<Employee> findByNameInOrAgeLessThan(List<String> names, Integer age);

    // where name in (?,?....) and age <?
    public abstract List<Employee> findByNameInAndAgeLessThan(List<String> names, Integer age);

    @Query("select o from Employee o where id=(select max(id) from Employee t1)")
    public abstract Employee getEmployeeByMaxId();

    @Query("select o from Employee o where o.name=?1 and o.age=?2")
    public abstract List<Employee> queryParams1(String name, Integer age);

    @Query("select o from Employee o where o.name=:name and o.age=:age")
    public abstract List<Employee> queryParams2(@Param("name") String name, @Param("age") Integer age);

    @Query("select o from Employee o where o.name like %?1%")
    public abstract List<Employee> queryLike1(String name);

    @Query("select o from Employee o where o.name like %:name%")
    public abstract List<Employee> queryLike2(@Param("name") String name);

    @Query(nativeQuery = true, value = "select count(1) from employee")
    public abstract long getCount();

    @Modifying
    @Query("update Employee o set o.age where o.id=:id")
    public abstract void update(@Param("id")Integer id,@Param("age")Integer age);
}
