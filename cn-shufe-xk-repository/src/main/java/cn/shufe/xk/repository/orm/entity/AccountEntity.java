package cn.shufe.xk.repository.orm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("account")
public class AccountEntity {
    @TableField(value = "id")
    private String id;
    @TableField(value = "account")
    private String account;
    @TableField(value = "passwd")
    private String passwd;
    @TableField(value = "role")
    private String role;
    @TableField(value = "is_deleted")
    private Integer isDeleted;
    @TableField(value = "created_at")
    private Date createdAt;
    @TableField(value = "updated_at")
    private Date updatedAt;
}
