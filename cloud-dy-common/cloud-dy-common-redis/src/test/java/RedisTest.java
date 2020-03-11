import com.cloud.dy.common.CommonRedisApplication;
import com.cloud.dy.common.redis.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName : Test
 * @Author : zhangquansong
 * @Date : 2019/3/29 0029上午 11:04
 * @Description :
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {CommonRedisApplication.class})// 指定启动类
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void testRedisAdd() {
        for (int i = 0; i < 30; i++) {
            boolean v = redisUtils.set("qqq" + i, "qqqq1111qqq");
            System.out.println(v);
        }
    }
}
