package aop.proxy;

import aop.service.NoticeService;
import aop.service.NoticeServiceImpl;
import org.springframework.cglib.proxy.Proxy;

/**
 * @author Ldp
 * @date 2021/1/7
 */
public class ProxyCall {

    public static void main(String[] args) {
        NoticeServiceImpl noticeServiceImpl = new NoticeServiceImpl();
        NoticeService noticeService = (NoticeService) Proxy.newProxyInstance(NoticeService.class.getClassLoader(), new Class<?>[]{NoticeService.class}, new ProxyInvocationHandler(noticeServiceImpl));
        noticeService.sayHello("alice");
    }

}
