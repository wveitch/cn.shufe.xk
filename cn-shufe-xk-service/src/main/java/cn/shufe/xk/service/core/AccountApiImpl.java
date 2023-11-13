package cn.shufe.xk.service.core;

import cn.shufe.xk.repository.orm.entity.AccountEntity;
import cn.shufe.xk.repository.orm.service.IAccountService;
import cn.shufe.xk.service.api.AccountApi;
import cn.shufe.xk.service.api.model.AccountInfo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Slf4j
@Service
public class AccountApiImpl implements AccountApi {
    @Resource
    private IAccountService iAccountService;
    @Override
    public AccountInfo queryAccountByName(String name) {
        LambdaQueryWrapper<AccountEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AccountEntity::getAccount, name);
        queryWrapper.eq(AccountEntity::getIsDeleted, 0);
        AccountEntity accountEntity = iAccountService.getOne(queryWrapper);
        return Objects.isNull(accountEntity) ? null : AccountInfo.builder()
                .id(accountEntity.getId())
                .account(accountEntity.getAccount())
                .role(accountEntity.getRole())
                .updatedAt(accountEntity.getUpdatedAt())
                .createdAt(accountEntity.getCreatedAt())
                .isDeleted(accountEntity.getIsDeleted())
                .build();
    }
}
