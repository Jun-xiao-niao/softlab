package junxiaoniao.softlab.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import junxiaoniao.softlab.common.ResponseResult;
import junxiaoniao.softlab.mapper.RoomMapper;
import junxiaoniao.softlab.model.entity.Room;
import junxiaoniao.softlab.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {
    public ResponseResult create(Room room) {
        //查询是否有相同数字的房间
        QueryWrapper<Room> wrapper = new QueryWrapper<>();
        wrapper.eq("id", room.getId());
        Room cRoom = baseMapper.selectOne(wrapper);
        if (!ObjectUtils.isEmpty(cRoom)) {
            return new ResponseResult(409, "房间已存在");
        }
        baseMapper.insert(room);
        return new ResponseResult(200, "房间创建成功");
    }

    public List<Room> checkAll() {
        return baseMapper.selectList(null);
    }

    public Room getRoomById(String id) {
        QueryWrapper<Room> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        Room room = baseMapper.selectOne(wrapper);
        return room;
    }
}
