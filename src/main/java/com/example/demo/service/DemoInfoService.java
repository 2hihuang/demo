package com.example.demo.service;

import com.example.demo.bean.DemoInfo;
import com.example.demo.dao.DemoInfoRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class DemoInfoService {

    @Resource
    private DemoInfoRepository demoInfoRepository;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    public void test() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("mykey4", "random1=" + Math.random());
        System.out.println(valueOperations.get("mykey4"));
    }

    @Cacheable(value = "demoInfo")
    public DemoInfo findById(long id) {
        System.err.println("DemoInfoService.findById()====从数据库中获取id=" + id);
        Optional<DemoInfo> opt = demoInfoRepository.findById(id);
        return opt.get();
    }

    @CacheEvict(value = "demoInfo")
    public void deleteFromCache(long id) {
        System.out.println("DemoInfoServiceImpl.delete() 从缓存中删除");
    }
}
