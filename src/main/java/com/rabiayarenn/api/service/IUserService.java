package com.rabiayarenn.api.service;

import com.rabiayarenn.api.entity.User;
import com.rabiayarenn.api.entity.enums.Role;

import java.util.List;

public interface IUserService extends IService<User> {
    List<User> getUsersByRole(Role role);
    List<User> getPotentialUsers(List<Integer> ids);

}
