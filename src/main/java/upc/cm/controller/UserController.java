package upc.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import upc.cm.model.SystemUser;
import upc.cm.repository.CommunityRe;
import upc.cm.repository.SURe;
import upc.cm.utils.AjaxResult;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private SURe suRe;

    @Autowired
    CommunityRe communityRe;

    @PostMapping("/login")
    private Object login(
            @RequestBody SystemUser systemUser
    ) {
        try {
            SystemUser systemUser1 = suRe.findFirstByUserAccount(systemUser.getUserAccount());
            if (systemUser1.getUserPassword().equals(systemUser.getUserPassword())) {
                return AjaxResult.success("success");
            } else
                return AjaxResult.error("error");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("error");
        }
    }
}
