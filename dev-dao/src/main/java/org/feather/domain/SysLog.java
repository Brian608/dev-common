package org.feather.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author feather
 * @projectName dev-common
 * @description: TODO
 * @since 18-Jul-22 4:09 PM
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysLog  extends Model<SysLog>  implements Serializable {
    private static final long serialVersionUID = -6309732882044872298L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String user;
    private String operation;
    private Integer time;
    private String uri;
    private String methodType;
    private String method;
    private String params;
    private String ip;
    private String contentType;
    private Date createTime;
}
