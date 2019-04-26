package yesapi;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import common.encryption.EncryptionUtil;
import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import lombok.extern.slf4j.Slf4j;
import yesapires.data.Identification;
import yesapires.Result;
import yesapires.info.IdentificationInfo;
import yesapires.info.JokeInfo;

/**
 * @author suwenguang
 *         suveng@163.com
 * since 2019/4/26
 * description:
 **/
@Slf4j
public class YesApi {

    private static final String YESAPI_CN = "http://hn216.api.yesapi.cn/";
    private static final String APP_SECRET = "CVQY81HcB9s0yx0IL7WDqZ7igYtPGqvW5ndZx7pS1m8v3pTUQEONNAmJ9ubN9RUttVGM";
    /**
     * yes api 的appKey，在个人中心获取
     */
    private static final String APP_KEY = "306A694C31D460966F710B8FD7A85BF0";
    private static final GsonDecoder DECODER = new GsonDecoder();
    private String service;


    interface AppCommonIDCard {
        /**
         * yes api 的 获取身份证信息的api
         * @param service 服务名
         * @param appKey key
         * @param idNumber 身份证号码
         * @param sign 签名
         * @return IdentificationInfo
         */
        @RequestLine("GET ?service={service}&app_key={appKey}&id_number={idNumber}&sign={sign}")
        Result<IdentificationInfo<Identification>> res(@Param("service") String service,@Param("appKey") String appKey, @Param("idNumber") String idNumber, @Param("sign") String sign);
    }


    interface AppCommonJokeRandOne {
        /**
         * yes api 的 随机一个笑话 的api
         * @param appKey key
         * @param sign 签名
         * @return JokeInfo<String>
         */
        @RequestLine("POST ?service={service}&app_key={appKey}&sign={sign}")
        Result<JokeInfo<String>> res(@Param("service") String service,@Param("appKey") String appKey, @Param("sign") String sign);
    }


    /**
     * 获取身份证信息的api
     * @param idNumber 身份证号码
     * @return IdentificationInfo
     */
    public Identification getIdentificationInfo(String idNumber) {
        AppCommonIDCard appCommonIDCard = Feign.builder()
                .decoder(DECODER)
                .target(AppCommonIDCard.class, YESAPI_CN);

        // Fetch and print a list of the contributors to this library.
        String s = "App.Common_IDCard.Parse";
        Result<IdentificationInfo<Identification>> res = appCommonIDCard.res(s,APP_KEY, idNumber, this.getSign(APP_KEY, idNumber,s));
        log.info("res:{}", new Gson().toJson(res));
        return res.getData().getInfo();
    }

    public String getJokeRandOne(){
        AppCommonJokeRandOne appCommonJokeRandOne=Feign.builder()
                .decoder(DECODER)
                .target(AppCommonJokeRandOne.class,YESAPI_CN);
        service = "App.Common_Joke.RandOne";
        Result<JokeInfo<String>> res = appCommonJokeRandOne.res(service,APP_KEY, getSign(APP_KEY,service));
        log.info("==== yes api 返回： {}", JSON.toJSONString(res));
        return res.getData().getJoke();
    }





    /**
     * 获取yes api 的sign
     * @param args api 的参数
     * @return sign
     */
    private String getSign(String... args) {
        //将全部参数名字将按字典排序后（需要先排除sign参数）
        StringBuilder stringBuilder = new StringBuilder();
        for (String a : args) {
            stringBuilder.append(a);
        }
        //在最后追加app_secrect
        stringBuilder.append(APP_SECRET);
        String cache = stringBuilder.toString();
        //进行md5，生成签名sign,全部转换成大写
        return EncryptionUtil.md5Hex(cache).toUpperCase();
    }

}
