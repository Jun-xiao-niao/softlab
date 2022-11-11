package junxiaoniao.softlab.service;

import com.baomidou.mybatisplus.extension.service.IService;
import junxiaoniao.softlab.common.ResponseResult;
import junxiaoniao.softlab.model.entity.Room;

import java.util.List;

public interface RoomService extends IService<Room> {
    /**
     * 创建房间
     *
     * @param Room
     * @return 创建对象
     */
    ResponseResult create(Room room);


    /**
     * 查找房间
     *
     * @param
     * @return 所有房间
     */
    List<Room> checkAll();


    /**
     * 进入房间
     *
     * @param id
     * @return 对应房间
     */
    Room getRoomById(String id);
}
