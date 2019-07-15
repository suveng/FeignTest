import yesapi.YesApiFeign;

/**
 * @author suwenguang
 *         suveng@163.com
 * since 2019/4/26
 * description:
 **/
public class TestApi {
    public static void main(String[] args) {
        YesApiFeign yesApiFeign = new YesApiFeign();
//        System.out.println(yesApi.getIdentificationInfo("445321199612300617"));
        System.out.println(yesApiFeign.getJokeRandOne());
    }
}
