package aop.controller;

import com.dp.test.test.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author Ldp
 * @date 2021/1/7
 */
@RestController
@RequestMapping()
@Validated
public class TestController {

    @PostMapping("/")
    public void test(@Validated @RequestBody User user) {

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }


    public void test1(@Valid User user) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
