import com.qianfeng.pojo.UserInfo;
import com.qianfeng.service.MenuInfoService;
import com.qianfeng.service.RoleInfoService;
import com.qianfeng.service.UserInfoService;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.NoSuchAlgorithmException;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)//junit整合spring的测试//立马开启了spring的注解
@ContextConfiguration(locations={"classpath:spring-mybatis.xml","classpath:spring-service.xml"})//加载核心配置文件，自动构建spring容器
public class JunitDemo {
    @Autowired
    MenuInfoService menuInfoService;

    @Test
    public void getMD5Password() throws NoSuchAlgorithmException {

        String s = DigestUtils.md5Hex("121313");
        //2 32次方-1*一亿次
        //超算(超级计算机)
        for(int i=0;i<10;i++){
            s = DigestUtils.md5Hex(s.substring(15));
        }
        System.out.println(s);
    }
}
