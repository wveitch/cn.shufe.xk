package cn.shufe.xk.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResult<T> {
    private String code;
    private String msg;
    private T data;



    public static <T> BaseResult<T> success(T data) {
        return new BaseResult<>("0", "请求成功", data);
    }
}
