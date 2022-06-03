package org.feather.service;

import org.feather.domain.UserDTO;

/**
 * @author duxuesong
 */
public interface IUserService {

    /**
     * 添加用户
     * @param userDTO
     */
    void  addUser(UserDTO userDTO);
}
