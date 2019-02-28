package com.ly.SpringBoot.Dao;

import com.ly.SpringBoot.Entity.Two;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ManDao extends JpaRepository<Two,Long>{

}
