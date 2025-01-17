package kr.bit.dao;

import kr.bit.beans.User;
import kr.bit.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
    @Autowired
    private UserMapper userMapper;

    public Integer existId(String user_id){
        return userMapper.existId(user_id);
    }

    public void joinUser(User joinBean){
        userMapper.joinUser(joinBean);
    }

    public User loginUser(User loginBean){
        return userMapper.loginUser(loginBean);
    }
}
