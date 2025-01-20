package kr.bit.service;

import kr.bit.beans.User;
import kr.bit.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserDao userDao;

    @Resource(name="loginBean") //RootAppContext- 세션영역에 설정한 빈 이름과 같기 때문에 주소값 자동주입
    private User loginBean;

    public void addUser(User joinBean){
        userDao.addUser(joinBean);
    }

    public boolean existId(String user_id){

        String user_name=userDao.existId(user_id);
        if(user_name==null){
            return true;  //사용할 수 있는 아이디면
        }
        return false;
    }

    public void getLoginUser(User loginProBean){

        User loginProBean2=userDao.getLoginUser(loginProBean);
        //user_idx, user_name
        if(loginProBean2!=null){
            loginBean.setUser_idx(loginProBean2.getUser_idx());
            //로그인되어있는 사람의 idx값 가져와서 User의 클래스 필드(user_idx)에 세팅
            loginBean.setUser_name(loginProBean2.getUser_name());
            loginBean.setUserLogin(true);  //로그인이 되어있는 상태이므로 true

            //비번, 아이디가 일치하면 -> 로그인이 된 상태라면
            //세션영역에 담은 loginBean객체로부터 idx, name, 로그인 여부확인을 설정한다
        }
    }

    public void getModifyUser(User modifyBean){

        User user=userDao.getModifyUser(loginBean.getUser_idx());
        //로그인한 사람의 idx기준으로 아이디, 이름 추출해서
        modifyBean.setUser_id(user.getUser_id());
        modifyBean.setUser_name(user.getUser_name());
        modifyBean.setUser_idx(user.getUser_idx());
    }

    public void modifyUser(User modifyBean){

        modifyBean.setUser_idx(loginBean.getUser_idx());
        userDao.modifyUser(modifyBean); //update
    }
}
