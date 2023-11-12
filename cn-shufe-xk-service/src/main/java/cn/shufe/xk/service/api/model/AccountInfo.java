package cn.shufe.xk.service.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfo {
        private String id;
        private String account;
        private String passwd;
        private String role;
        private Integer isDeleted;
        private Date createdAt;
        private Date updatedAt;
}
