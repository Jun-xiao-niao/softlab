package junxiaoniao.softlab.service;

import com.baomidou.mybatisplus.extension.service.IService;
import junxiaoniao.softlab.common.ResponseResult;
import junxiaoniao.softlab.model.entity.RoomUser;
import junxiaoniao.softlab.model.vo.RoomUserVO;

public interface RoomUserService extends IService<RoomUser> {


    /**
     * ---
     *
     * @param ---
     * @return ---
     */
    RoomUserVO userEnter(String room, String username);

    /**
     * ---
     *
     * @param ---
     * @return ---
     */
    RoomUserVO checkAll(String room);
}
