import lombok.*;

import java.util.Collection;
import java.util.Map;

/**
 * @author liuxiaolun
 * @Description: TODO
 * @date 2018-10-31 11:15:43
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Son extends Father {
    private String name;
    private Integer age;

    public Collection show(Map map) {
        System.out.println("我是子类。。。");
        return map.values();
    }
}
