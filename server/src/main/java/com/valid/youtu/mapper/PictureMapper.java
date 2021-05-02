package com.valid.youtu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.valid.youtu.entity.Picture;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PictureMapper extends BaseMapper<Picture> {
    @Select("SELECT p.id, p.name, p.create_time, p.story, u.user_name owner FROM (picture p INNER JOIN classify c ON p.cid=c.id) LEFT JOIN user u ON u.id = p.owner WHERE c.name=#{name} LIMIT #{page}, #{total}")
    List<Picture> getPicturesPagesByClassify(@Param("page") Integer page, @Param("total") Integer total, @Param("name")String name);

    @Select("SELECT p.id, p.name, p.create_time, p.story, u.user_name owner FROM (picture p INNER JOIN classify c ON p.cid=c.id) LEFT JOIN user u ON u.id = p.owner LIMIT #{page}, #{total}")
    List<Picture> getPicturesPages(@Param("page") Integer page, @Param("total") Integer total);

    @Select("SELECT COUNT(*) FROM picture p INNER JOIN classify c ON p.cid=c.id WHERE c.name=#{name} AND is_show=#{isShow}")
    Integer getTotalByClassify(@Param("name") String name, @Param("isShow") boolean isShow);

    @Select("SELECT COUNT(*) FROM picture p INNER JOIN classify c ON p.cid=c.id WHERE is_show=#{isShow}")
    Integer getTotal(@Param("isShow") boolean isShow);
}
