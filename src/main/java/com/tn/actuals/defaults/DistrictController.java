package com.tn.actuals.defaults;

import com.tn.actuals.dao.DistrictRepoService;
import com.tn.actuals.dto.District;
import com.tn.actuals.views.DistrictView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistrictController {

    @Autowired
    private DistrictRepoService districtRepoService;

    Logger logger = LoggerFactory.getLogger(DistrictController.class);

    @GetMapping(path = "/getDistricts")
    public List<District> getDistricts() {
        List<District> districts = districtRepoService.findAll();
        return districts;

    }
    @PostMapping(path = "/addDistrict")
    public void addDistrict(
            @RequestBody DistrictView districtView) {

        logger.info("Adding district" + districtView.getDistrictName() + "started!");
        District district = new District();
        district.setDistrictCode(districtView.getDistrictCode());
        district.setDistrictName(districtView.getDistrictName());
        districtRepoService.addDistrict(district);
        logger.info("Adding district" + districtView.getDistrictName() + "completed!");
    }

    @PostMapping(path = "/updateDistrict")
    public void updateDistrict(
            @RequestBody DistrictView districtView) {

        logger.info("Updating district" + districtView.getDistrictName() + "started!");
        District district = new District();
        district.setDistrictCode(districtView.getDistrictCode());
        district.setDistrictName(districtView.getDistrictName());
        districtRepoService.updateDistrict(district);
        logger.info("Updating district" + districtView.getDistrictName() + "completed!");
    }

    @PostMapping(path = "/deleteDistrict")
    public void deleteDistrict(
            @RequestBody DistrictView districtView) {

        logger.info("Deleting district" + districtView.getDistrictName() + "started!");
        District district = new District();
        district.setDistrictCode(districtView.getDistrictCode());
        district.setDistrictName(districtView.getDistrictName());
        districtRepoService.deleteDistrict(district);
        logger.info("Deleting district" + districtView.getDistrictName() + "completed!");

    }

}