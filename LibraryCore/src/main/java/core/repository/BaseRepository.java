package repository;

import model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;


public interface BaseRepository<T extends BaseEntity<ID>, ID extends
        Serializable>
        extends JpaRepository<T, ID> {

}