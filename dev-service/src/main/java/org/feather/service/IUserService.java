package org.feather.service;

import org.feather.domain.User;
import org.feather.dto.UserDTO;

import java.util.List;

/**
 * @author duxuesong
 */
public interface IUserService {

    /**
     * 添加用户
     * @param userDTO
     */
    void  addUser(UserDTO userDTO);

    List<User>   getAll();

    /**
     * 导出用户
     */
   void exportExcel();
}
