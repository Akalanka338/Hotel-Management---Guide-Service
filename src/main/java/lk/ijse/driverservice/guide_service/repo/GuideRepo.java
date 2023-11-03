package lk.ijse.driverservice.guide_service.repo;

import lk.ijse.driverservice.guide_service.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GuideRepo extends JpaRepository<Guide, Long> {


    void deleteById(long id);

    @Query(value = "SELECT v FROM Guide v WHERE v.guide_name= :guide_name")
   ArrayList<Guide> findAllBy(String guide_name);


}
