package kr.bit.validator;

import kr.bit.beans.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String beanName = errors.getObjectName();
        if (beanName.equals("joinBean")) {
            if (!user.getUser_pw().equals(user.getUser_pw2())) {
                errors.rejectValue("user_pw2", "NotEqual");
            }

            if (user.isExistId()) {
                errors.rejectValue("user_id", "NotCheck");
            }
        }
    }
}
