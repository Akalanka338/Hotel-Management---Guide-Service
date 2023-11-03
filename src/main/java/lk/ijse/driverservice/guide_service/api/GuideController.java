package lk.ijse.driverservice.guide_service.api;

import lk.ijse.driverservice.guide_service.dto.guideDTO;
import lk.ijse.driverservice.guide_service.entity.Guide;
import lk.ijse.driverservice.guide_service.service.GuideService;


import lk.ijse.driverservice.guide_service.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/guide")
@CrossOrigin
public class GuideController {

    @Autowired
    GuideService guideService;

    @Autowired
    ModelMapper mapper;

    @PostMapping
    public ResponseUtil saveGuide(@RequestParam("id") Long id,
                                    @RequestParam("guide_name") String guide_name,
                                    @RequestParam("address") String address,
                                    @RequestParam("age") String age,
                                    @RequestParam("gender") String gender,
                                    @RequestParam("guide_img") MultipartFile guide_img,
                                    @RequestParam("experience") String experience,
                                    @RequestParam("day_value") String day_value,
                                    @RequestParam("guide_contact") String guide_contact
                                  ) throws IOException {
        guideDTO guide = new guideDTO(id, guide_name,address,age,gender,guide_img.getBytes(),experience,day_value,guide_contact);

        guideService.addGuide(guide);
        return new ResponseUtil("200", "Guide Added Successfully", null);
    }


    @PutMapping
    public ResponseUtil updateGuide(@RequestParam("id") Long id,
                                      @RequestParam("guide_name") String guide_name,
                                      @RequestParam("address") String address,
                                      @RequestParam("age") String age,
                                      @RequestParam("gender") String gender,
                                      @RequestParam("guide_img") MultipartFile guide_img,
                                      @RequestParam("experience") String experience,
                                      @RequestParam("day_value") String day_value,
                                      @RequestParam("guide_contact") String guide_contact
                                      ) throws IOException {


        Guide existsGuide = guideService.findById(id);

        if (existsGuide != null) {
            existsGuide.setGuide_name(guide_name);
            existsGuide.setAddress(address);
            existsGuide.setAge(age);
            existsGuide.setGender(gender);
            existsGuide.setGuide_img(guide_img.getBytes());
            existsGuide.setExperience(experience);
            existsGuide.setDay_value(day_value);
            existsGuide.setGuide_contact(guide_contact);


            guideService.updateGuide(existsGuide);
            return new ResponseUtil("200", "Updated Guide Data Sucessfull!", null);
        } else {
            return new ResponseUtil("404", "Guide not found", null);
        }
    }

    @DeleteMapping(params = "id")
    public ResponseUtil deleteGuide(@RequestParam Long id){

        guideService.deleteGuide(id);
        return new ResponseUtil("200" ,id+"Deleted SuccessFull",null);

    }
    @GetMapping
    public ResponseUtil getAllGuide(){
        ArrayList<guideDTO>guideDTOs=guideService.getAllGuides();

            return new ResponseUtil("200", "Show All Guides", guideDTOs);
    }

    @GetMapping(value = "api/search",params ="guide_name",produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseUtil searchByGuide(@RequestParam String guide_name){
        List<guideDTO> guideDTOArrayList=guideService.searchGuideByName(guide_name);
        return new ResponseUtil("200", guide_name+"Searching", guideDTOArrayList);

    }
}