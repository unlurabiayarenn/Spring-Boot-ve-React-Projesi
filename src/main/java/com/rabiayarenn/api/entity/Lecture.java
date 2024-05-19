package com.rabiayarenn.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="lectures")

//lombok anatasyonu kullanıldı
@AllArgsConstructor
@NoArgsConstructor
@Data //getter setterı bu şekilde daha rahat kullanım oldu

public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column//(name= id)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;

    public Integer getTeacherId(){
        if (teacher != null) {
            return teacher.getId();
        }
        return null;
    }
/*
    //one to many bir ilişki
    //one tarafı bu kıısm olacağı için many için burdan başlamam gerekmekte
    //eğer son kısmında one varsa buraya tekil tanımlarım
    //many tarafı burda olsaydı burasını list şeklinde tanımlanacaktı
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;
*/
    //mantto many ilişkiside mevcut; birden çok öğrenci birden çok lecture olabilir
   @ManyToMany
   @JoinTable(name = "user_lectures",
           joinColumns = {@JoinColumn(name = "lecture_id", referencedColumnName = "id")},
           inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName = "id")}
   )
   private List<User> students;
   //eğer bu tanımlamayı user tarafında yapılsaydı  eğer ters şekilde olacaktı

}
