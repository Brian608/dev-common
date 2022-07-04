package org.feather.domain;

import lombok.Data;

import java.util.Date;

/**
 * @projectName: dev-common
 * @package: org.feather.domain
 * @className: RefreshTokenDetails
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/7/4 22:03
 * @version: 1.0
 */
@Data
public class RefreshTokenDetails {
    private Long id;

    private Long userId;

    private String refreshToken;

    private Date creatTime;
}
