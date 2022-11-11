package junxiaoniao.softlab.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import junxiaoniao.softlab.model.entity.RoomUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoomUserMapper extends BaseMapper<RoomUser> {
}
