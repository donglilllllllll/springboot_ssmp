package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 凯祥
 */
@Data
@TableName(value = "tbl_book")

public class Book {

    private Integer id;
    private String type;
    private String name;
    private String description;

}
