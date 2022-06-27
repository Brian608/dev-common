package org.feather.support;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.feather.domain.User;
import org.feather.exception.ConditionException;
import org.feather.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.validation.constraints.NotNull;

/**
 * @author feather
 * @projectName dev-common
 * @description: TODO
 * @since 27-Jun-22 2:04 PM
 */
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class UserSupport {


    private  @NotNull IUserService userService;





    public User getCurrentUserInfo(){
        ServletRequestAttributes requestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String token = requestAttributes.getRequest().getHeader("accessToken");
        User currentUser = userService.getCurrentUserByToken(token);
        if (currentUser==null){
            throw  new ConditionException("非法用户");
        }
        return  currentUser;
    }
}
