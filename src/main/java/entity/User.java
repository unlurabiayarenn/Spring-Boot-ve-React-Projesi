package entity;

import entity.enums.Gender;
import entity.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")

//lombok anatasyonu kullanıldı
@AllArgsConstructor
@NoArgsConstructor
@Data //getter setterı bu şekilde daha rahat kullanım oldu

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column//(name= id)
    private Integer id;

    @Column(name= "identity_no" , length=11, unique=true) //bu şekilde tanımlama yapılmasının sebebi dbde bu şekilde kayıtlı olup entity adının buna karşılık geldiğini göstermek
    private String identityNo;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    @Enumerated(EnumType.STRING) //DB DE BURAYI STRİNG OLARAK TANIMLADIĞIMIZ İÇİN BU ŞEKİLDE BİR TANIMLAMA YAPMIŞ OLDUK
    private Gender gender; //bunun için enum classı oluşturuldu.

    @Column(name = "urole")
    @Enumerated(EnumType.STRING)
    private Role role ;
}
