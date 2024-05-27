package com.rabiayarenn.api.service.impl;

import com.rabiayarenn.api.common.GeneralException;
import com.rabiayarenn.api.entity.User;
import com.rabiayarenn.api.entity.enums.Role;
import com.rabiayarenn.api.repository.IUserRepository;
import com.rabiayarenn.api.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getUsersByRole(Role role) {
        //return List.of();
        return  userRepository.findByRole(role);
    }

    @Override
    public List<User> getPotentialUsers(List<Integer> ids) {
        //return List.of();
        if (ids.isEmpty()) {
            return  getUsersByRole(Role.STUDENT);
        }
        return userRepository.findAllByRoleAndIdIsNotIn(Role.STUDENT,ids);
    }

    @Override
    public User save(User user) {
        //return null;
        if (user.getId() == null) { //update ve oluşturmak için bu metod kullanılacak (güncelleme mi yapacak yoksa save mi edecek burdan belirlenmiş olacak)
            if (user.getIdentityNo() == null || user.getIdentityNo().length() != 11)  { //unique mi geçerli mi kontrolü
                //common altında Generalexception oluşturduk!
                throw new GeneralException("Invalid user identity number");
            }
            //bir kontrol daha yaparsak eğer
            if (userRepository.existsByIdentityNo(user.getIdentityNo())) {
                throw new GeneralException("User identity already exists");
            }
        }
        return userRepository.save(user);
    }

    @Override
    public User getById(Integer id) {
        //return null;
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new GeneralException("User not found");
        }
        return user.get();

        //bu şekilde de istenilen sonuca varılabilir.
        //return userRepository.findById(id).orElseThrow(() -> new GeneralException("User not found"));
    }

    @Override
    public List<User> getAll() {
        //return List.of();
        return userRepository.findAll();
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        //return null;
        return userRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        if (!userRepository.existsById(id)){
            throw new GeneralException("User not found");
        }
        userRepository.deleteById(id);
    }
}
