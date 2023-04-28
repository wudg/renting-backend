package com.wdg.renting.main.controller;

import com.alibaba.fastjson.JSON;
import com.wdg.renting.main.base.common.Result;
import com.wdg.renting.main.dto.TreeNode;
import com.wdg.renting.main.entity.HouseDetail;
import com.wdg.renting.main.entity.HouseType;
import com.wdg.renting.main.req.HouseAddReq;
import com.wdg.renting.main.req.HousePageReq;
import com.wdg.renting.main.res.HouseResponse;
import com.wdg.renting.main.res.PagerModel;
import com.wdg.renting.main.service.HouseDetailService;
import com.wdg.renting.main.service.HouseService;
import com.wdg.renting.main.service.HouseTypeService;
import com.wdg.renting.main.service.MapCityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.controller
 * @Author: 吴第广
 * @CreateTime: 2023-04-22  20:01
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/house")
@Slf4j
public class HouseController {

    @Resource
    private HouseDetailService houseDetailService;

    @Resource
    private HouseService houseService;
    @Resource
    private HouseTypeService houseTypeService;

    @Resource
    private MapCityService mapCityService;

    @GetMapping("/list")
    public Result<List<HouseDetail>> list() {
        return Result.success(houseDetailService.list());
    }

    @GetMapping("/listHouseType")
    public Result<List<HouseType>> listHouseType() {
        log.info("查询所有出租房类型");
        return Result.success(houseTypeService.list());
    }

    @GetMapping("/mapCity")
    public Result<List<TreeNode>> mapCity() {
        log.info("查询所有区域地址信息");
        return Result.success(mapCityService.listMapCity());
    }

    @GetMapping("/mapSubway")
    public Result<List<TreeNode>> mapSubway() {
        log.info("查询所有地铁信息");
        return Result.success(mapCityService.listMapSubway());
    }

    @GetMapping("/pageList")
    public Result<PagerModel<HouseResponse>> list(@ModelAttribute HousePageReq param) {
        // 查询数据
        log.info("分页查询出租房列表,参数:{}", JSON.toJSONString(param));
        return Result.success(houseService.listHousePage(param));
    }

    @GetMapping("/detail")
    public Result<HouseResponse> getById(@RequestParam("id") Long id) {
        log.info("查询出租房明细{}", id);
        return Result.success(houseService.getHouseDetail(id));
    }

    @PostMapping("/save")
    public Result<Boolean> save(@RequestBody HouseAddReq house) {
        log.info("新增出租房, param:{}", JSON.toJSONString(house));
        return Result.success(houseService.addHouse(house));
    }

    @PostMapping("/uploadImg")
    public Result<String> uploadImg(@RequestBody MultipartFile file) {
        return Result.success("上传成功", houseService.uploadImg(file));
    }
}
