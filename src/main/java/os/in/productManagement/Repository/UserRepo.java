package os.in.productManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import os.in.productManagement.Entity.User;



@Repository
public interface UserRepo extends JpaRepository<User,Long> {
      User findByName(String name);
}
