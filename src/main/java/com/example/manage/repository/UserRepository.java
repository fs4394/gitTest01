package com.example.manage.repository;

import com.example.manage.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FileName:    UserRepository
 * Author:      Yuan-Programmer
 * Date:        2021/12/10 21:53
 * Description:
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
