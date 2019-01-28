import lombok.*;

import java.util.Collection;
import java.util.HashMap;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-10-31 11:14:25
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Father {
    private String name;
    private Integer age;

    public Collection show(HashMap map) {
        System.out.println("我是父类。。。");
        return map.values();
    }

}
