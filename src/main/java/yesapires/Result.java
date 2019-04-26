package yesapires;


import lombok.Data;

/**
 * @author suwenguang
 *         suveng@163.com
 * since 2019/4/22
 * description: 统一返回层
 **/
@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;
}
