package com.ly.SpringBoot.ServiceImpl;

import com.ly.SpringBoot.Dao.ManDao;
import com.ly.SpringBoot.Entity.Two;
import com.ly.SpringBoot.Service.ManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("manService")
@Transactional(rollbackFor = Exception.class)
public class ManServiceImpl implements ManService{
    @Autowired
    private ManDao manDao;

    /**
     * 添加一个用户并将用户信息写到缓存中
     * @param man
     * @return
     */
    @Override
    public boolean addMan(Two man) {
        try {
            manDao.save(man);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除用户并将缓存清除
     * @param id
     * @return
     */
    @Override
    @CacheEvict(value = "man",key = "#id")
    public boolean delete(Long id) {

        try {
            manDao.deleteById(id);
           return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @CachePut(value = "man",key = "#id")
    public boolean update(Long id) {
        return false;
    }

    /**
     * 查找用户，首先充缓存中查如果有直接返回，如果没有会执行查询方法并将结果放入到缓存中
     * @param id
     * @return
     */
    @Override
    @Cacheable(value = "man",key = "#id")
    public Two selectMan(Long id) {

        Two man = null;
        try {
            man = manDao.getOne(id);
            System.out.println("从数据库中查询用户信息");
            return man;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return man;
    }
}
