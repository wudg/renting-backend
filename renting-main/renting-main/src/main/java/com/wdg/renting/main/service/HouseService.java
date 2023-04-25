package com.wdg.renting.main.service;

import com.wdg.renting.main.base.service.BaseService;
import com.wdg.renting.main.entity.House;
import com.wdg.renting.main.req.HouseAddReq;
import com.wdg.renting.main.req.HousePageReq;
import com.wdg.renting.main.res.HouseResponse;
import com.wdg.renting.main.res.PagerModel;
import org.springframework.web.multipart.MultipartFile;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.service
 * @Author: 吴第广
 * @CreateTime: 2023-04-22  20:47
 * @Description: TODO
 * @Version: 1.0
 */
public interface HouseService extends BaseService<House> {
    /**
     * 分页查询出租房信息
     * @param param 分页参数
     * @return 出租房分页数据
     */
    PagerModel<HouseResponse> listHousePage(HousePageReq param);

    /**
     * 获取出租房明细
     * @param id 出租房ID
     * @return 出租房明细
     */
    HouseResponse getHouseDetail(Long id);

    /**
     * 新增出租房
     * @param house 出租房信息
     * @return 是否新增成功
     */
    boolean addHouse(HouseAddReq house);

    /**
     * 文件上传
     * @param file 文件
     * @return 上传后访问路径
     */
    String uploadImg(MultipartFile file);
}
