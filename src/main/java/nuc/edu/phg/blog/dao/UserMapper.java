package nuc.edu.phg.blog.dao;

import nuc.edu.phg.blog.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer adminUserId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer adminUserId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}