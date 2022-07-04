package org.feather.service;
import org.feather.domain.User;
import org.feather.dto.LoginDTO;
import org.feather.dto.UserDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * @projectName: dev-common
 * @package: org.feather.service.impl
 * @className: IUserService
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/6/27 21:01
 * @version: 1.0
 */
public interface IUserService {

    /**
     * 添加用户
     * @param userDTO
     */
    void  addUser(UserDTO userDTO);

    Map<String, Object> login(LoginDTO loginDTO);

    List<User>   getAll();

    User getCurrentUserByToken(String token);

    /**
     * 导出用户
     */
    void exportExcel();

    /**
     * 导入数据
     */
    void  importExcel();

    /**
     * 导入用户
     * @param file
     * @throws IOException
     */
    void  importUser(MultipartFile file) throws IOException;


    //String  createUserToken(User user);


    //    String generateToken(String src);
//
    User getUserByPhone(String phone);

    /**
     * 登出
     * @param refreshToken
     * @param userId
     */
    void loginOut(String refreshToken, Long userId);

    /**
     * 刷新token
     * @param refreshToken
     */
    String refreshAccessToken(String refreshToken) throws Exception;
}
