package com.aihwaong.minicm.mapper;

import com.aihwaong.minicm.model.NoticeType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NoticeType record);

    int insertSelective(NoticeType record);

    NoticeType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NoticeType record);

    int updateByPrimaryKey(NoticeType record);

    List<NoticeType> selectAllDataOfPage(@Param("page") Integer page, @Param("size") Integer size, @Param("keyWord") String keyWord);

    Long selectTotal(@Param("keyWord") String keyWord);

    int deleteDatas(@Param("idList") Integer[] idList);

    List<NoticeType> selectAllNoticeTypes();
}