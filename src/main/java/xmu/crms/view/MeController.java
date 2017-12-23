package xmu.crms.view;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xmu.crms.dto.UserDTO;
import xmu.crms.vo.SchoolVO;
import xmu.crms.vo.UserVO;

@RestController
public class MeController {

    @ResponseStatus(value= HttpStatus.OK)
    @RequestMapping(value="/me",method = RequestMethod.GET)
    @ResponseBody
    public UserVO homepage()
    {
        SchoolVO school=new SchoolVO(123,"厦门大学");
        UserVO user=new UserVO(3486,"XXX","XXXX","xxxxxx","xxxxxx","xxxxxx","male","xxxx","xxxxxx",school);
        return user;
    }

    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    @RequestMapping(value="/me",method = RequestMethod.PUT)
    @ResponseBody
    public void registerFirst(@RequestBody UserVO user)
    {

    }

    @ResponseStatus(value= HttpStatus.CREATED)
    @RequestMapping(value="/signin",method = RequestMethod.POST)
    @ResponseBody
    public UserVO index(@RequestBody UserDTO u)
    {
        UserVO user;
        if(u.getPhone().equals("123"))
        {
            user=new UserVO(3486,"李四","student","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjaWQiOiJPQTAwMDEiLCJpYXQiOjE0ODI2NTcyODQyMjF9.TeJpy936w610Vrrm+c3+RXouCA9k1AX0Bk8qURkYkdo=");
        }
        else
        {
            user=new UserVO(3486,"张三","teacher","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjaWQiOiJPQTAwMDEiLCJpYXQiOjE0ODI2NTcyODQyMjF9.TeJpy936w610Vrrm+c3+RXouCA9k1AX0Bk8qURkYkdo=");
        }
        System.out.print(user);
        return user;
    }


}
