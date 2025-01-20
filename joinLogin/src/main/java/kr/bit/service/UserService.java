package kr.bit.service;

import kr.bit.beans.User;
import kr.bit.dao.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class UserService {
    @Resource(name = "loginBean")
    private User loginBean;

    @Autowired
    private UserDAO userDAO;

    public boolean existId(String user_id) {
        if(userDAO.existId(user_id) == null){
            return false;
        }else{
            return true;
        }
    }

    public void joinUser(User user) {
        userDAO.joinUser(user);
    }

    public void loginUser(User user) {
        User temp = userDAO.loginUser(user);
        if(temp != null){
            loginBean.setUserLogin(true);
            loginBean.setUser_idx(temp.getUser_idx());
            loginBean.setUser_id(temp.getUser_id());
            loginBean.setUser_name(temp.getUser_name());
            loginBean.setUser_gender(temp.getUser_gender());
            loginBean.setUser_birthday(temp.getUser_birthday());
            loginBean.setUser_email(temp.getUser_email());
            loginBean.setUser_postcode(temp.getUser_postcode());
            loginBean.setUser_address(temp.getUser_address());
            loginBean.setUser_d_address(temp.getUser_d_address());
            loginBean.setUser_hobby(temp.getUser_hobby());
            loginBean.setUser_job(temp.getUser_job());
        }
    }
}
