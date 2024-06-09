package ashish.springsecuirty.SpringSecurityDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ashish.springsecuirty.SpringSecurityDemo.Entity.users;

@Repository
public interface UserRepository extends JpaRepository<users,Integer> {

}
