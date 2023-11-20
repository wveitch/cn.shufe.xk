package cn.shufe.xk.web.intercept;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    private static final String SIGN_HEADER = "sign";

    // 获取token 签名
    // 签名可以用hutool中的sign
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        // https://juejin.cn/post/6844903758946664462
        String sign = request.getHeader(SIGN_HEADER);
        // hutool签名策略
        byte[] data = "我是一段测试字符串".getBytes();
        Sign sign1 = SecureUtil.sign(SignAlgorithm.MD5withRSA);
        //签名
        byte[] signed = sign1.sign(data);
        //验证签名
        boolean verify = sign1.verify(data, signed);
        log.info("输出日志信息,sign:{}", sign);
        return true;
    }
}
