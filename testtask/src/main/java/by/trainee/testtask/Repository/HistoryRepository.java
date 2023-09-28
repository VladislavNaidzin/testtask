package by.trainee.testtask.Repository;


import by.trainee.testtask.Entity.History;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends CrudRepository<History,Integer> {



}
