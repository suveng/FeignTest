package juhe;

import feign.Param;
import feign.RequestLine;
import juhe.vo.BankCardQueryVO;
import yesapires.Result;
import yesapires.data.Identification;
import yesapires.info.IdentificationInfo;

/**
 * description:
 * @author suwenguang
 * @date 2019/7/10
 * @version 1.0.0
 **/
public class JuheService {

    interface BankcardCoreQuery {
        /**
         * yes api 的 获取身份证信息的api
         * @param service 服务名
         * @param appKey key
         * @param idNumber 身份证号码
         * @param sign 签名
         * @return IdentificationInfo
         */
        @RequestLine("POST /bankcardcore/query ?bankcard={bankcard}&key={key}")
        Result<IdentificationInfo<Identification>> bankcardCoreQuery(BankCardQueryVO bankCardQueryVO);
    }
}
