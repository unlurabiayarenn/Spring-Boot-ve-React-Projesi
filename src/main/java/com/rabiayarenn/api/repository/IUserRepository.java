package com.rabiayarenn.api.repository;

import com.rabiayarenn.api.entity.User;
import com.rabiayarenn.api.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    boolean existsByIdentityNo(String username); //Unique old. kontrol için
    List<User> findByRole(Role role); //verilen role göre kullanıcıları dönen bir metod
    List<User> findAllByRoleAndIdIsNotIn(Role role, List<Integer> idList); //verilen idler dışındaki kullanıcıları dönüyor

}
