package os.in.productManagement.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import os.in.productManagement.Entity.User;
import os.in.productManagement.Entity.UserPrincipal;
import os.in.productManagement.Repository.UserRepo;

@Service
public class MyUserDetailService  implements UserDetailsService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        User user=userRepo.findByName(username);

        if (user==null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(user);
    }

}
