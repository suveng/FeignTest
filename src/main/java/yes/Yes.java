package yes;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import lombok.Data;
import yesapires.Result;
import yesapires.info.JokeInfo;

/**
 * description:
 * @author suwenguang
 * @date 2019/7/15
 * @version 1.0.0
 **/

public interface Yes {

    @RequestLine("POST /?s=App.Common_University.Search")
    YesResponse<YesUniversity> appCommonUniversitySearch(@QueryMap YesVo vo);

    @RequestLine("POST ?service={service}&app_key={appKey}&sign={sign}")
    Result<JokeInfo<String>> res(@Param("service") String service, @Param("appKey") String appKey, @Param("sign") String sign);
}
