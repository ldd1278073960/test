package aop.begin.aop;

import aop.advice.MethodLogAdvice;
import aop.service.NoticeService;
import aop.service.NoticeServiceImpl;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author Ldp
 * @date 2021/1/7
 */
public class BeginAop {

    public static void main(String[] args) {
        // 定义代理工厂
        ProxyFactory proxyFactory = new ProxyFactory(new NoticeServiceImpl());
        // 给代理工厂添加接口
        proxyFactory.addInterface(NoticeService.class);
        MethodLogAdvice methodLogAdvice = new MethodLogAdvice();
        // 为工厂定义advice(通知)
        proxyFactory.addAdvice(methodLogAdvice);

        NoticeService proxy = (NoticeService) proxyFactory.getProxy();
        proxy.sayHello("帅坡一号你好");
        proxy.sayMySelf("帅坡一号再见");
        {

        }
    }

}
