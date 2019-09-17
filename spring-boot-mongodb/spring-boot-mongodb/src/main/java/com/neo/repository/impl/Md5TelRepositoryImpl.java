package com.neo.repository.impl;

import com.neo.model.Md5TelDO;
import com.neo.repository.Md5TelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liqingshan
 * Date: 2019-09-17
 * Time: 18:39
 */
@Component
public class Md5TelRepositoryImpl implements Md5TelRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveMd5Tel(Md5TelDO md5TelDO) {
        mongoTemplate.save(md5TelDO);
    }
}
