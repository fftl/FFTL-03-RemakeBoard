package fftl.fftl03RemakeBoard.repository;

import fftl.fftl03RemakeBoard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
