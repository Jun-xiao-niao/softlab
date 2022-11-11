package junxiaoniao.softlab.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import junxiaoniao.softlab.common.ResponseResult;
import junxiaoniao.softlab.mapper.RoomMapper;
import junxiaoniao.softlab.model.entity.Room;
import junxiaoniao.softlab.model.vo.RoomUserVO;
import junxiaoniao.softlab.service.RoomService;
import junxiaoniao.softlab.service.RoomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
@Api("房间功能")
public class RoomController extends BaseController{

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomUserService roomUserService;

    @ApiOperation("创建房间")
    @RequestMapping(value = "/createroom", method = RequestMethod.POST)
    public ResponseResult register(@RequestBody Room room) {
        return roomService.create(room);
    }

    @ApiOperation("查看所有房间")
    @RequestMapping(value = "/checkroom", method = RequestMethod.GET)
    public ResponseResult checkroom() {
        List<Room> list = roomService.checkAll();
        return new ResponseResult(200, "查询成功", list);
    }

    @ApiOperation("查看房间的所有玩家")
    @RequestMapping(value = "/checkuser", method = RequestMethod.GET)
    public ResponseResult checkuser(@RequestParam("room") String id) {
        RoomUserVO users = roomUserService.checkAll(id);
        return new ResponseResult(200, "查询成功", users);
    }

    @ApiOperation("加入房间")
    @RequestMapping(value = "/enterroom", method = RequestMethod.POST)
    public ResponseResult enterRoom(@RequestParam("room") String id,@RequestParam("username") String username) {
        Room room = roomService.getRoomById(id);
        if (ObjectUtils.isEmpty(room)) {
            return new ResponseResult(409, "房间不存在");
        }
        return new ResponseResult(200, "进入房间成功", roomUserService.userEnter(room.getId(),username));
    }

}
