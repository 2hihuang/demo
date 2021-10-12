package com.example.demo.dao;

import com.example.demo.bean.DemoInfo;
import org.springframework.data.repository.CrudRepository;

public interface DemoInfoRepository extends CrudRepository<DemoInfo, Long> {
}
