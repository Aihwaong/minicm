package com.aihwaong.minicm.controller.system;

import com.aihwaong.minicm.model.PageResponseBean;
import com.aihwaong.minicm.model.Personnel;
import com.aihwaong.minicm.model.ResponseBean;
import com.aihwaong.minicm.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.controller.system
 * +-------------------------------------------------------
 * | @Title:
 * +-------------------------------------------------------
 * | @ProjectName:   cm
 * +-------------------------------------------------------
 * | @Description:   功能描述
 * +-------------------------------------------------------
 * | @author:        王富琳
 * +-------------------------------------------------------
 * | @email:         < 894633456@qq.com >
 * +-------------------------------------------------------
 * | @date:          2020/6/23 21:41
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@RestController
@RequestMapping("/system/authority/perssonel")
public class PerssonelController {

    @Autowired
    private PersonnelService personnelService;

    @GetMapping("/getAllPersonnel")
    public List<Personnel> getAllPersonnel() {
        return personnelService.getAllPerssonel();
    }

    @GetMapping("/")
    public PageResponseBean<Personnel> getAllPerssonelOfPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            String keyWord) {
        return personnelService.getAllPerssonelOfPage(page, size, keyWord);
    }

    @GetMapping("/{id}")
    public Personnel getPersonnel(
            @PathVariable("id") Integer id
    ) {
        return personnelService.selectPersonnel(id);
    }

    @PostMapping("/")
    public ResponseBean insertPersonnel(
            @RequestBody Personnel personnel
    ) {
        int result = personnelService.insertPersonnel(personnel);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("新增成功");
        } else {
            return responseBean.setMessage("新增失败");
        }
    }

    @PutMapping("/")
    public ResponseBean updatePersonnel(
            @RequestBody Personnel personnel
    ) {
        int result = personnelService.updatePersonnel(personnel);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("修改成功");
        } else {
            return responseBean.setMessage("修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseBean deletePersonnel(
            @PathVariable("id") Integer id
    ) {
        int result = personnelService.deletePersonnel(id);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }

    @DeleteMapping("/")
    public ResponseBean deletePersonnels(Integer[] idList
    ) {
        int result = personnelService.deletePersonnels(idList);
        ResponseBean responseBean = ResponseBean.buildResponseBean();
        if (result > 0) {
            return responseBean.setMessage("删除成功");
        } else {
            return responseBean.setMessage("删除失败");
        }
    }

}
