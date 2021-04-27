package com.valid.youtu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.valid.youtu.entity.Picture;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PictureMapper extends BaseMapper<Picture> {
    @Select("SELECT p.id, p.name, p.create_time FROM picture p INNER JOIN classify c ON p.cid=c.id WHERE c.name=#{name}")
    List<Picture> getPicturesByClassify(String name);
}
