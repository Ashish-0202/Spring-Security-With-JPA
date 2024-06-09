package ashish.springsecuirty.SpringSecurityDemo.Repository;

import ashish.springsecuirty.SpringSecurityDemo.Entity.authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<authorities,String> {
}
