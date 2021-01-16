package aop.service;

/**
 * @author Ldp
 * @date 2021/1/7
 */
public class NoticeServiceImpl implements NoticeService {
    @Override
    public void sayHello(String name) {
        System.out.println("hello,"+name);
    }

    @Override
    public void sayMySelf(String self) {
        System.out.println("self,"+ self);
    }

    public static void main(String[] args) {
        NoticeServiceImpl noticeService = new NoticeServiceImpl();
        noticeService.sayHello("hi");
    }
}
