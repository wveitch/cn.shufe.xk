package cn.shufe.xk.web.intercept;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    private static final String SIGN_HEADER = "sign";

    // 获取token 签名
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        // https://juejin.cn/post/6844903758946664462
        String sign = request.getHeader(SIGN_HEADER);
        log.info("输出日志信息,sign:{}", sign);
        return true;
    }
}
