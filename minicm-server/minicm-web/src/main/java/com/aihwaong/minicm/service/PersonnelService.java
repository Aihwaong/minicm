package com.aihwaong.minicm.service;

import com.aihwaong.minicm.mapper.PersonnelMapper;
import com.aihwaong.minicm.mapper.RoleMapper;
import com.aihwaong.minicm.model.PageResponseBean;
import com.aihwaong.minicm.model.Personnel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * +-------------------------------------------------------
 * |
 * +-------------------------------------------------------
 * | @package:       com.aihwaong.minicm.service
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
 * | @date:          2020/6/17 21:07
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Service
@Slf4j
public class PersonnelService implements UserDetailsService {

    @Autowired
    private PersonnelMapper personnelMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        Personnel personnel = personnelMapper.loadUserAccount(account);
        if (null == personnel) {
            throw new UsernameNotFoundException("账号不存在");
        }

        personnel.setRoles(roleMapper.getPerssonelRoles(personnel.getId()));

        return personnel;
    }



    /**
     * 获取用户id
     * @return Personnel
     */
    public Integer getPsersonnlId() {
        String personnelId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return  Integer.parseInt(personnelId);
    }

    /**
     * 获取所有职员
     * @return List<Personnel>
     */
    public PageResponseBean<Personnel> getAllPerssonelOfPage(Integer page, Integer size, String keyWord) {
        page = (page - 1) * size;
        List<Personnel> personnels = personnelMapper.getAllPerssonelOfPage(page, size, keyWord);
        Long total = personnelMapper.selectTotal(keyWord);
        for (Personnel personnel : personnels) {
            personnel.setPassword(null);
        }
        return new PageResponseBean<>(total, personnels);
    }

    /**
     * 新增职员
     * @param personnel personnelBean
     * @return int
     */
    public int insertPersonnel(Personnel personnel) {
        personnel.setCreateTime(new Timestamp(System.currentTimeMillis())); // 当前时间戳
        personnel.setPassword(passwordEncode(personnel.getPassword()));  // 密码加密
        return personnelMapper.insertSelective(personnel);
    }

    /**
     * 信息编辑
     * @param personnel personnelBean
     * @return int
     */
    public int updatePersonnel(Personnel personnel) {
        if (personnel.getPassword() != null && !"".equals(personnel.getPassword())) {
            personnel.setPassword(passwordEncode(personnel.getPassword()));  // 密码加密
        }
        return personnelMapper.updateByPrimaryKeySelective(personnel);
    }


    public int deletePersonnel(Integer id) {
        return personnelMapper.deleteByPrimaryKey(id);
    }

    /**
     * BCryptPasswordEncoder 加密
     * @param pwd 密码明文
     * @return 加密密文
     */
    private String passwordEncode(String pwd) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(pwd);
    }


    public Personnel selectPersonnel(Integer id) {
        Personnel personnel = personnelMapper.selectByPrimaryKey(id);
        personnel.setPassword(null);
        return personnel;
    }

    public List<Personnel> getAllPerssonel() {
        return personnelMapper.getAllPerssonel();
    }

    public int deletePersonnels(Integer[] idList) {
        return personnelMapper.deletePersonnels(idList);
    }
}
