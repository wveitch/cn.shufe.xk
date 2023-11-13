package cn.shufe.xk.web.controller;

import cn.shufe.xk.service.api.AccountApi;
import cn.shufe.xk.service.api.model.AccountInfo;
import cn.shufe.xk.web.dto.AccountDto;
import cn.shufe.xk.web.dto.BaseResult;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountApi accountApi;

    @GetMapping("/getAccountByName")
    public BaseResult<AccountDto> getAccountByName(String name) {
        AccountInfo accountInfo = accountApi.queryAccountByName(name);
        log.info("test:{}", JSON.toJSONString(accountInfo));
        return Objects.isNull(accountInfo) ? BaseResult.fail() : BaseResult.success(AccountDto.builder()
                .account(accountInfo.getAccount())
                .passwd(accountInfo.getPasswd())
                .build());
//        return AccountDto.builder().build();
    }
}
