package yes;

import lombok.Data;

import java.util.List;

/**
 * description:
 * @author suwenguang
 * @date 2019/7/15
 * @version 1.0.0
 **/
@Data
public class YesUniversity {
    private String err_code;
    private String err_msg;
    private List<School> schools;
}
