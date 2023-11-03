package lk.ijse.driverservice.guide_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class guideDTO {
    private long id;
    private String guide_name;
    private String address;
    private String age;
    private String gender;
    private byte[]guide_img;
    private String experience;
    private String day_value;
    private String guide_contact;


}
