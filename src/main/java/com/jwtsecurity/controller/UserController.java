package com.jwtsecurity.controller;

import com.jwtsecurity.bo.ResponseMessage;
import com.jwtsecurity.model.CommonUser;
import com.jwtsecurity.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by LadyLady on 2019-04-26.
 */
@RequestMapping("user")
@RestController
public class UserController {


    @Autowired
    private UserServices userServices;

    @PostMapping
    public ResponseMessage addUser(@RequestBody CommonUser commonUser) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("");
        responseMessage.setStrutsCode("");
        responseMessage.setData(new Object());
        return responseMessage;

    }

    @DeleteMapping("{id}")
    public ResponseMessage deleteUser(@PathVariable Integer id) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("");
        responseMessage.setStrutsCode("");
        responseMessage.setData(new Object());
        return responseMessage;

    }

    @PutMapping
    public ResponseMessage updateUser(@RequestBody CommonUser commonUser) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("");
        responseMessage.setStrutsCode("");
        responseMessage.setData(new Object());
        return responseMessage;


    }

    @GetMapping("{id}")
    public ResponseMessage findOneUser(@PathVariable Integer id) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("");
        responseMessage.setStrutsCode("");
        responseMessage.setData(new Object());
        return responseMessage;

    }


}
