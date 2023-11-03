package lk.ijse.driverservice.guide_service.service;

import lk.ijse.driverservice.guide_service.dto.guideDTO;
import lk.ijse.driverservice.guide_service.entity.Guide;

import java.util.ArrayList;
import java.util.List;


public interface GuideService {
    void  addGuide(guideDTO guideDTO);

    void  deleteGuide(long id);

    void updateGuide(Guide guideDTO);

    ArrayList<guideDTO> getAllGuides();

    List<guideDTO> searchGuideByName(String guide_name);

    Guide findById(long id);
}
