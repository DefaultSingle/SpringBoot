package com.ly.SpringBoot.Service;

import com.ly.SpringBoot.Entity.Two;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 */
public interface ManService {

    boolean addMan(Two man);

    boolean delete(Long id);

    boolean update(Long id);

    Two selectMan(Long id);
}
