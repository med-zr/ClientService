package org.operationsix.ClientService.Repository;

import org.operationsix.ClientService.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findByUserName(String username);
    User findByEmail(String email);
}
