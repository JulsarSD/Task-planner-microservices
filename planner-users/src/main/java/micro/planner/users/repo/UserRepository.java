package micro.planner.users.repo;

import micro.planner.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    void deleteByEmail(String email);

    @Query("SELECT u FROM User u where " +
            "(:email is null or :email='' or lower(u.email) like lower(concat('%', :email, '%'))) or" +
            "(:username is null or :username='' or lower(u.username) like lower(concat('%', :username, '%')))"
    )
    // искать по всем переданным параметрам (пустые учитываться не будут)
    Page<User> findByParams(@Param("email") String email,
                            @Param("username") String username,
                            Pageable pageable
    );
}
