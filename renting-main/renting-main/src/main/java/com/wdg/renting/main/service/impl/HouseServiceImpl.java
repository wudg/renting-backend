package com.wdg.renting.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wdg.renting.main.base.service.impl.BaseServiceImpl;
import com.wdg.renting.main.entity.House;
import com.wdg.renting.main.entity.HouseDetail;
import com.wdg.renting.main.mapper.HouseMapper;
import com.wdg.renting.main.req.HouseAddReq;
import com.wdg.renting.main.req.HousePageReq;
import com.wdg.renting.main.res.HouseResponse;
import com.wdg.renting.main.res.PagerModel;
import com.wdg.renting.main.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @BelongsProject: renting-backend
 * @BelongsPackage: com.wdg.renting.main.service.impl
 * @Author: 吴第广
 * @CreateTime: 2023-04-22  20:47
 * @Description: TODO
 * @Version: 1.0
 */
@Service
@Slf4j
public class HouseServiceImpl extends BaseServiceImpl<HouseMapper, House> implements HouseService {
    @Value("${config.uploadDir}")
    private String uploadDir;

    @Value("${config.domain}")
    private String domain;

    @Autowired
    private HouseDetailService houseDetailService;

    @Autowired
    private NcSubwayService ncSubwayService;

    @Autowired
    private HouseTypeService houseTypeService;

    @Autowired
    private NcRegionService ncRegionService;
    @Override
    public PagerModel<HouseResponse> listHousePage(HousePageReq param) {
        PageHelper.startPage(param.getPageNum(),param.getPageSize());
        List<HouseResponse> list = mapper.listHousePage(param);

        PagerModel<HouseResponse> resultList = new PagerModel<>();

        PageInfo<HouseResponse> pageInfo = new PageInfo<>(list);
        resultList.setTotal(pageInfo.getTotal());
        resultList.setRows(list);
        return resultList;
    }

    @Override
    public boolean addHouse(HouseAddReq house) {
        House houseAdd = new House()
                .setHouseTypeId(house.getHouseTypeId())
                .setArea(house.getArea())
                .setPrice(house.getPrice())
                .setCover(house.getCover())
                .setVillageName(house.getVillageName())
                .setLevel(house.getLevel())
                .setToward(house.getToward())
                .setBalcony(house.getBalcony())
                .setKitchen(house.getKitchen())
                .setImages(JSON.toJSONString(house.getPhotos()))
                .setToilet(house.getToilet())
                .setDescription(house.getDescription())
                ;
        this.save(houseAdd);

        HouseDetail houseDetail = new HouseDetail()
                .setHouseId(houseAdd.getId())
                .setPrice(house.getPrice())
                .setPublisherId(100L)
                .setHouseNo(house.getHouseNo())
                .setPowerRate(house.getPowerRate())
                .setWaterRate(house.getWaterRate())
                .setRegionId(house.getLocation().get(1))
                .setDistrictId(house.getLocation().get(0))
                .setSubwayLineId(house.getSubwayLocation().get(0))
                .setSubwayStationId(house.getSubwayLocation().get(1));
        houseDetailService.save(houseDetail);
        return true;
    }

    @Override
    public HouseResponse getHouseDetail(Long id) {
        return mapper.getHouseDetail(id);
    }

    @Override
    public String uploadImg(MultipartFile file){
        CreateFileDir(uploadDir);
        String filename = null;
        try {
            filename = UUID.randomUUID().toString().replaceAll("-", "")+file.getOriginalFilename();
            log.info("文件上次成功,路径:{}", uploadDir + filename);
            file.transferTo(new File(uploadDir,filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return domain + filename;
    }

    protected void CreateFileDir(String filepath) {
        File dir = new File(filepath);
        if (!dir.exists())
            dir.mkdirs();
    }
}
