import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @author wangxj
 * @date 2020/5/10 22:01
 */
public class SnowFlake {
    private long workerId = 0 ;
    public static void main(String[] args) {

        //Snowflake snowflake = IdUtil.createSnowflake(0, 0);
        Snowflake snowflake1 = IdUtil.getSnowflake(0, 0);
        long generateDateTime = snowflake1.getGenerateDateTime(1);
        System.out.println(snowflake1.nextId());
    }

}
