package junxiaoniao.softlab.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import junxiaoniao.softlab.model.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoomMapper extends BaseMapper<Room> {
}
