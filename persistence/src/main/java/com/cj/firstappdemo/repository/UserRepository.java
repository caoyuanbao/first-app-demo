package com.cj.firstappdemo.repository;

import com.cj.firstappdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/1/18 0018.
 */
@Repository
public class UserRepository {

    /**
     * 采用内存型存储方式
     */
    public final ConcurrentMap<Integer,User> repository = new ConcurrentHashMap<>();

    public final static AtomicInteger idGeneraor = new AtomicInteger();

    public boolean save(User user){
        Integer id = idGeneraor.incrementAndGet();
        user.setId(id);
        return repository.put(id,user) == null;
    }

    public Collection<User> findAll(){
        return repository.values();
    }
}
