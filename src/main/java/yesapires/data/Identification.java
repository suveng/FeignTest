package yesapires.data;

import lombok.Data;

/**
 * @author suwenguang
 *         suveng@163.com
 * since 2019/4/26
 * description: 身份证信息封装类
 **/
@Data
public class Identification {
    private Boolean is_legal;
    private String birthday;
    private Integer age;
    private String gender;
    private Integer code;
    private String province;
    private String city;
    private String area;
    private String address;
}
