package junxiaoniao.softlab.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@Builder
@TableName("room")
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    private String id;

    @TableField("number")
    private Integer number;

}
