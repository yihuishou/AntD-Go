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

        CommonUser addUser = userServices.addUser(commonUser);
        responseMessage.setMessage("添加失败");
        responseMessage.setStrutsCode("400");
        responseMessage.setData(null);
        if (addUser != null) {
            responseMessage.setMessage("添加成功");
            responseMessage.setStrutsCode("200");
            responseMessage.setData(addUser);
        }

        return responseMessage;

    }

    @DeleteMapping("{id}")
    public ResponseMessage deleteUser(@PathVariable Integer id) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("删除失败");
        responseMessage.setStrutsCode("400");
        responseMessage.setData(null);

        boolean deleteResult = userServices.deleteUser(id);
        if (deleteResult) {
            responseMessage.setMessage("删除成功");
            responseMessage.setStrutsCode("200");
        }
        return responseMessage;

    }

    @PutMapping
    public ResponseMessage updateUser(@RequestBody CommonUser commonUser) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("更新失败");
        responseMessage.setStrutsCode("400");
        responseMessage.setData(new Object());
        CommonUser updateUser = userServices.updateUser(commonUser);
        if (updateUser != null) {
            responseMessage.setMessage("更新成功");
            responseMessage.setStrutsCode("200");
            responseMessage.setData(updateUser);
        }


        return responseMessage;

    }

    @GetMapping("{id}")
    public ResponseMessage findOneUser(@PathVariable Integer id) {
        ResponseMessage responseMessage = new ResponseMessage();
        final CommonUser oneUser = userServices.findOneUser(id);
        responseMessage.setMessage("查询成功");
        responseMessage.setStrutsCode("200");
        responseMessage.setData(oneUser);
        return responseMessage;

    }


}
