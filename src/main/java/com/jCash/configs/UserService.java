package com.jCash.configs;

import com.google.common.collect.ImmutableList;
import com.jCash.exception.RecordNotFoundException;
import com.jCash.model.UsersEntity;
import com.jCash.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserService implements UserDetailsService {
    @Autowired
    UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*User usr = new User();*/
       // usersService.setUsername(username);
       // usersService.setPassword("password");
      //  usersService.setAuthorities(ImmutableList.of(Role.USER));
       // usersService.setAccountNonExpired(true);
      //  usersService.setAccountNonLocked(true);
      //  usersService.setEnabled(true);
       // usersService.setCredentialsNonExpired(true);
        UsersEntity usersEntity = null;
        try {
            usersEntity = usersService.getUserByName(username);
        } catch (RecordNotFoundException e) {
            e.printStackTrace();
        }
        usersEntity.setUsername(username);
        //usersEntity.setPassword("password");
        usersEntity.setAuthorities(ImmutableList.of(Role.USER));
        usersEntity.setAccountNonExpired(true);
        usersEntity.setAccountNonLocked(true);
        usersEntity.setEnabled(true);
        usersEntity.setCredentialsNonExpired(true);
        return usersEntity;
    }

}
