package cn.shufe.xk.repository.orm.service.impl;

import cn.shufe.xk.repository.orm.entity.AccountEntity;
import cn.shufe.xk.repository.orm.mapper.AccountMapper;
import cn.shufe.xk.repository.orm.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class IAccountServiceImpl extends ServiceImpl<AccountMapper, AccountEntity> implements IAccountService {
}
