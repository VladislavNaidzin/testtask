package by.trainee.testtask.Repository;


import by.trainee.testtask.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

    @Query(
            value = "select * from user",
            nativeQuery = true)
    ArrayList<User> findAllUsers();

    @Query(
            value = "select * from user",
            nativeQuery = true)
    User[] findAllUsersSimpleArray();

    @Query(
            value = "select * from user where login=:log",
            nativeQuery = true)
    User findByLogin(@Param("log") String log);

}
