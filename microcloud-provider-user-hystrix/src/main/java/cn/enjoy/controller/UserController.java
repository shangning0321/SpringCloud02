package cn.enjoy.controller;

import cn.enjoy.vo.Users;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringCloud02
 * @description:
 * @author: liu yan
 * @create: 2021-03-28 14:25
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping("/get/{name}")
    @HystrixCommand
    public  Object get(@PathVariable("name")String name) {
        Users users = new Users();
        users.setName(name);
        users.setAge(18);
        users.setSex("F");
        return users;
    }
}
