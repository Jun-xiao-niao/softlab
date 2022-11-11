package junxiaoniao.softlab.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import junxiaoniao.softlab.common.ResponseResult;
import junxiaoniao.softlab.mapper.RoomUserMapper;
import junxiaoniao.softlab.model.entity.RoomUser;
import junxiaoniao.softlab.model.vo.RoomUserVO;
import junxiaoniao.softlab.service.RoomUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RoomUserServiceImpl extends ServiceImpl<RoomUserMapper, RoomUser> implements RoomUserService {
    public RoomUserVO userEnter(String room, String username){
        RoomUser roomUser = new RoomUser().setRoom(room).setUsername(username);
        baseMapper.insert(roomUser);
        return getRoomUserVO(room);
    }

    public RoomUserVO checkAll(String room){
        return getRoomUserVO(room);
    }

    private RoomUserVO getRoomUserVO(String room) {
        QueryWrapper<RoomUser> wrapper = new QueryWrapper<>();
        wrapper.eq("room", room);
        List<RoomUser> roomUsers = baseMapper.selectList(wrapper);
        List<String> users = null;
        for (int i = 0; i < roomUsers.size(); i++){
            users.add(roomUsers.get(i).getUsername());
        }
        return new RoomUserVO().setRoom(room).setUsername(users);
    }
}