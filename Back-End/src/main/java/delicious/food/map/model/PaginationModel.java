package delicious.food.map.model;


import lombok.Data;

import java.io.Serializable;

/**
 * 分页 Model
 *
 * @author dhbxs
 * @since 2025/05/29 14:35
 */
@Data
public class PaginationModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer pageNum;

    private Integer pageSize;
}

