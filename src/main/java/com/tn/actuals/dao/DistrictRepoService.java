package com.tn.actuals.dao;

import com.tn.actuals.dto.District;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepoService {

    public District findById(int id);
    public List<District> findAll();
    public List<District> findByDistrictCode(int id);
    public void addDistrict(District districts);
    public void updateDistrict(District districts);
    public void deleteDistrict(District districts);
}
