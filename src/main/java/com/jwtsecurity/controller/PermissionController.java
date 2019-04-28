package com.jwtsecurity.controller;

import com.jwtsecurity.bo.ResponseMessage;
import com.jwtsecurity.model.CommonPermission;
import com.jwtsecurity.services.PermissionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by LadyLady on 2019-04-26.
 */
@RequestMapping("permission")
@RestController
public class PermissionController {


    @Autowired
    private PermissionServices permissionServices;

    @PostMapping
    public ResponseMessage addPermission(@RequestBody CommonPermission commonPermission) {

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("更新失败");
        responseMessage.setStrutsCode("400");
        responseMessage.setData(null);
        CommonPermission addPermission = permissionServices.addPermission(commonPermission);

        if (addPermission != null) {
            responseMessage.setMessage("更新成功");
            responseMessage.setStrutsCode("200");
            responseMessage.setData(addPermission);
        }

        return responseMessage;

    }

    @DeleteMapping("{id}")
    public ResponseMessage deletePermission(@PathVariable Integer id) {
        ResponseMessage responseMessage = new ResponseMessage();

        if (permissionServices.deletePermission(id)) {
            responseMessage.setMessage("删除成功");
            responseMessage.setStrutsCode("200");
            responseMessage.setData(null);
        }

        responseMessage.setMessage("删除失败");
        responseMessage.setStrutsCode("400");
        responseMessage.setData(null);


        return responseMessage;


    }

    @PutMapping
    public ResponseMessage updatePermission(@RequestBody CommonPermission commonPermission) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("更新失败");
        responseMessage.setStrutsCode("400");
        responseMessage.setData(null);

        CommonPermission updatePermission = permissionServices.updatePermission(commonPermission);
        if (updatePermission != null) {
            responseMessage.setMessage("更新成功");
            responseMessage.setStrutsCode("200");
            responseMessage.setData(updatePermission);
        }
        return responseMessage;
    }

    @GetMapping("{id}")
    public ResponseMessage findOnePermission(@PathVariable Integer id) {
        ResponseMessage responseMessage = new ResponseMessage();

        responseMessage.setMessage("查询失败");
        responseMessage.setStrutsCode("400");
        responseMessage.setData(null);

        CommonPermission onePermission = permissionServices.findOnePermission(id);


        if (onePermission != null) {
            responseMessage.setMessage("查询成功");
            responseMessage.setStrutsCode("200");
            responseMessage.setData(onePermission);

        }
        return responseMessage;


    }


}
