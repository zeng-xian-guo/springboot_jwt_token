package com.example.demo.Repository;

import com.example.demo.Entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeptRepository extends JpaRepository<Dept,String> {

    List<Dept> findAllByPid(@Param("pid") String pid);

}
