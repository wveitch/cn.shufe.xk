package cn.shufe.xk.service.api;

import cn.shufe.xk.service.api.model.AccountInfo;

public interface AccountApi {
    /**
     * 根据名称查用户
     * @param name
     * @return
     */
    AccountInfo queryAccountByName(String name);
}
