package com.valid.youtu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.valid.youtu.entity.Picture;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PictureMapper extends BaseMapper<Picture> {
    @Select("SELECT p.id, p.name, p.create_time FROM picture p INNER JOIN classify c ON p.cid=c.id WHERE c.name=#{name}")
    IPage<Picture> getPicturesByClassify(Page<?> page, @Param("name")String name);
}
