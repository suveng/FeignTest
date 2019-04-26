package yesapires.info;

import lombok.Data;

/**
 * @author suwenguang
 *         suveng@163.com
 * since 2019/4/26
 * description:
 **/
@Data
public class JokeInfo<T> {
    private Integer err_code;
    private String err_msg;
    private T joke;
}
