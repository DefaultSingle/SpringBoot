package com.ly.SpringBoot.Service;

import com.ly.SpringBoot.Entity.Persion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 接口
 */
public interface PersionInterface extends JpaRepository<Persion,Long>{
        Persion findUserById(String id);
}
