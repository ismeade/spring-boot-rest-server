package com.ade.demo.server.modules.serv.service;

import com.ade.demo.server.modules.serv.service.dto.SortDto;

import java.util.List;

/**
 * 排序业务处理service
 */
public interface SortService {

    /**
     * 排序集合
     * @param list
     * @return
     */
    List<Object> sort(List<Object> list);

    /**
     * 查看排序记录
     * @param page
     * @param pageSize
     * @return
     */
    List<SortDto> findAll(Integer page, Integer pageSize);

}
