package com.aihwaong.minicm.mapper;

import com.aihwaong.minicm.model.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKeyWithBLOBs(Notice record);

    int updateByPrimaryKey(Notice record);

    List<Notice> selectAllDataOfPage(
            @Param("page") Integer page,
            @Param("size") Integer size,
            @Param("title") String title,
            @Param("typeId") Integer typeId,
            @Param("editor") String editor,
            @Param("dates") Date[] dates
    );

    Long selectTotal(
            @Param("title") String title,
            @Param("typeId") Integer typeId,
            @Param("editor") String editor,
            @Param("dates") Date[] dates
    );

    int deleteDatas(@Param("idList") Integer[] idList);
}