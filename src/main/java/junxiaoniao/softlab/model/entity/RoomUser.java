package junxiaoniao.softlab.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@Builder
@TableName("room_user")
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class RoomUser {

    //用户ID,雪花算法，自增ID
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @TableField("room")
    private String room;

    @TableField("username")
    private String username;

}
