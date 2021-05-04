package com.valid.youtu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.valid.youtu.entity.Picture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PictureMapper extends BaseMapper<Picture> {
    List<Picture> getPicturesPages(Map<String, Object> map);

    Integer getTotal(Map<String, Object> map);

    Integer modifyPictureState(String id);
}
