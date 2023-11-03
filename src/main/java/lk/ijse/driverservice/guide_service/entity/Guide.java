package lk.ijse.driverservice.guide_service.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String guide_name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String age;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    @Lob
    private byte[]guide_img;
    @Column(nullable = false)
    private String experience;
    @Column(nullable = false)
    private String day_value;
    @Column(nullable = false)
    private String guide_contact;












}
