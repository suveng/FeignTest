package yes;

import lombok.Data;

/**
 * description:
 * @author suwenguang
 * @date 2019/7/15
 * @version 1.0.0
 **/
@Data
public class YesResponse<T> {
    private Integer ret;
    private String msg;
    private T data;
}
