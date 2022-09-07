package huanbi;

import lombok.Data;

import java.util.List;

/**
 * @author Ldp
 * @date 2022/5/28
 */
@Data
public class HuanBi {

    private String date;

    private Integer swipeNum;

    private Integer swipeUserNum;

    private List<Object> list;
}
