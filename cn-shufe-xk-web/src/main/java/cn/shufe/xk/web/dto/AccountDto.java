package cn.shufe.xk.web.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private String id;
    private String account;
    private String passwd;
    private String role;
    private Integer isDeleted;
    private Date createdAt;
    private Date updatedAt;
}
