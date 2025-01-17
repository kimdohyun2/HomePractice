package kr.bit.mapper;

import kr.bit.beans.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select user_idx from user_table where user_id=#{user_id}")
    Integer existId(@Param("user_id") String user_id);

    @Insert("insert into user_table(user_id, user_pw, user_name, user_gender, user_birthday, user_email, user_postcode, user_address, user_d_address, user_hobby ,user_job) " +
            "values(#{user_id}, #{user_pw}, #{user_name}, #{user_gender}, #{user_birthday}, #{user_email}, #{user_postcode}, #{user_address}, #{user_d_address}, #{user_hobby}, #{user_job})")
    Integer joinUser(User joinBean);

    @Select("select * from user_table where user_id=#{user_id} and user_pw=#{user_pw}")
    User loginUser(User loginBean);
}
