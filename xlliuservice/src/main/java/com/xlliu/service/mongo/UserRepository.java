package com.xlliu.service.mongo;

import com.xlliu.po.vo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-12-24 15:08:06
 **/
@Service
public interface UserRepository extends MongoRepository<User, Integer> {

}
