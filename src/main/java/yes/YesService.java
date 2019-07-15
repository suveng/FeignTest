package yes;

import com.alibaba.fastjson.JSON;
import feign.Feign;
import feign.gson.GsonDecoder;

/**
 * description:
 * @author suwenguang
 * @date 2019/7/15
 * @version 1.0.0
 **/
public class YesService {
    public YesResponse<YesUniversity> appCommonUniversitySearch(){
        Yes yes=Feign.builder().decoder(new GsonDecoder()).target(Yes.class,"http://api.yesapi.cn");
        YesVo yesVo=new YesVo();
        yesVo.setSchool_name("师范");
        yesVo.setApp_key("你的app_key");
        yesVo.setSign("你的sign");
        return yes.appCommonUniversitySearch(yesVo);
    }

    public static void main(String[] args) {
        YesService yesService = new YesService();
        YesResponse<YesUniversity> yesUniversityYesResponse = yesService.appCommonUniversitySearch();
        System.out.println(JSON.toJSONString(yesUniversityYesResponse));
    }
}
