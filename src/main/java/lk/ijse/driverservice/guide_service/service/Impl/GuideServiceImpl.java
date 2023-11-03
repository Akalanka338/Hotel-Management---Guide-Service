package lk.ijse.driverservice.guide_service.service.Impl;

import lk.ijse.driverservice.guide_service.dto.guideDTO;
import lk.ijse.driverservice.guide_service.entity.Guide;
import lk.ijse.driverservice.guide_service.repo.GuideRepo;
import lk.ijse.driverservice.guide_service.service.GuideService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class GuideServiceImpl implements GuideService {

    @Autowired
    GuideRepo guideRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public void addGuide(guideDTO guideDTO) {
        if (guideRepo.existsById(guideDTO.getId())){
            throw new RuntimeException(guideDTO.getId()+"Already Exists");
        }

        Guide guide=modelMapper.map(guideDTO,Guide.class);
//        vehicle.setVehicle_brand(vehicleDTO.getVehicle_brand());
//        vehicle.setVehicle_img(vehicleDTO.getVehicle_img());
//        vehicle.setVehicle_category(vehicleDTO.getVehicle_category());
//        vehicle.setFuel_type(vehicleDTO.getFuel_type());
//        vehicle.getDriver_contact(vehicleDTO.getDriver_contact());

        guideRepo.save(guide);
    }

    @Override
    public void deleteGuide(long id) {
        if (!guideRepo.existsById(id)){
            throw new RuntimeException("Guide"+id+"Not Available Deleted");
        }
        guideRepo.deleteById(id);
    }

    @Override
    public void updateGuide(Guide guideDTO) {
        Optional<Guide>Byid=guideRepo.findById(guideDTO.getId());
        if (Byid.isEmpty()){
            throw new RuntimeException("Id doesent Exists");
        }
        guideRepo.save(modelMapper.map(guideDTO,Guide.class));
    }

    @Override
    public ArrayList<guideDTO> getAllGuides() {
        return modelMapper.map(guideRepo.findAll(), new TypeToken<ArrayList<guideDTO>>() {}.getType());
    }

    @Override
    public List<guideDTO> searchGuideByName(String guide_name) {
        return modelMapper.map(guideRepo.findAllBy(guide_name), new TypeToken<ArrayList<guideDTO>>() {}.getType());
    }

    @Override
    public Guide findById(long id) {
        if (!guideRepo.existsById(id)){
            throw new RuntimeException("Guide"+id+"Not Available");
        }
        Optional<Guide> byId=guideRepo.findById(id);
        return byId.get();
    }
}
