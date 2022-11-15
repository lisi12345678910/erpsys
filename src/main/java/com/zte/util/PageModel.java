package com.zte.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageModel<T> {

    private int pageNum;  // 当前页数
    private int pageSize; // 每页显示条数
    private int totalPage; // 总页数
    private int totalCount; // 总条数
    private List<T> data;

}
