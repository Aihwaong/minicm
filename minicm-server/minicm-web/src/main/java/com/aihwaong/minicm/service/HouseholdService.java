package com.aihwaong.minicm.service;

import com.aihwaong.minicm.mapper.*;
import com.aihwaong.minicm.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * | @date:          2020/6/28 15:50
 * +-------------------------------------------------------
 * | @updateUser:    修改人
 * +-------------------------------------------------------
 * | @updateTime:    修改时间
 * +-------------------------------------------------------
 */
@Service
public class HouseholdService {

    @Autowired
    private HouseholdInfoMapper householdInfoMapper;

    @Autowired
    private HouseholdAccountMapper householdAccountMapper;

    @Autowired
    private StoriedHouseMapper storiedHouseMapper;

    @Autowired
    private HouseHoldMapper houseHoldMapper;

    @Autowired
    private NationMapper nationMapper;

    public PageResponseBean<HouseholdInfo> selectAllDataOfPage(
            Integer page,
            Integer size,
            String realName,
            String identityDocument,
            String telephone,
            Byte nation
    ) {
        page = (page - 1) * size;
        List<HouseholdInfo> roles = householdInfoMapper.selectAllDataOfPage(page, size, realName, identityDocument, telephone, nation);
        Long total = householdInfoMapper.selectTotal(realName, identityDocument, telephone, nation);
        return new PageResponseBean<>(total, roles);
    }

    public HouseholdInfo selectHouseholdInfo(Integer id) {
        return householdInfoMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public Boolean insertHouseholdInfo(HouseholdInfo householdInfo) {
        Timestamp newTime = new Timestamp(System.currentTimeMillis());

        /* -------------- 新增业主信息 -------------- */
        householdInfo.setCreateTime(newTime);
        int infoResult = householdInfoMapper.insertSelective(householdInfo);

        /* -------------- 新增业主账号信息 ------- */
        HouseholdAccount householdAccount = new HouseholdAccount();
        // 关联业主信息
        householdAccount.setHouseholdInfoId(infoResult);
        // 业主账号为手机号码
        householdAccount.setAccount(householdInfo.getTelephone());
        // 业主登录密码 初始为身份证后六位
        String passwordCode = householdInfo.getIdentityDocument().substring(12);
        // BCryptPassword加密
        String passwordEncode = new BCryptPasswordEncoder().encode(passwordCode);
        householdAccount.setPassword(passwordEncode);
        householdAccount.setCreateTime(newTime);
        int accountResult = householdAccountMapper.insertSelective(householdAccount);

        return infoResult > 0 && accountResult > 0;
    }

    public int updateHouseholdInfo(HouseholdInfo householdInfo) {
        householdInfo.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return householdInfoMapper.updateByPrimaryKeySelective(householdInfo);
    }

    public int deleteHouseholdInfo(Integer id) {
        return householdInfoMapper.deleteByPrimaryKey(id);
    }

    public int deleteDatas(Integer[] idList) {
        return householdInfoMapper.deleteDatas(idList);
    }

    public List<Nation> selectAllNation() {
        return nationMapper.selectAllNation();
    }

    public List<BuildingArea> getHouses(Integer ridgepole, Integer unit) {
        return storiedHouseMapper.getHouses(ridgepole, unit);
    }

    public int checkIn(HouseHold houseHold) {
        // 判断是否重复登记
        HouseHold hh = houseHoldMapper.selectByHouseId(houseHold.getHouseholdId(), houseHold.getHouseId());
        if (hh != null) {
            return 0;
        }
        // 入住登记
        houseHold.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return houseHoldMapper.insertSelective(houseHold);
    }

    public List<StoriedHouse> selectCheckInByHouseHoldId(Integer household) {
        return storiedHouseMapper.selectCheckInByHouseHoldId(household);
    }
}
