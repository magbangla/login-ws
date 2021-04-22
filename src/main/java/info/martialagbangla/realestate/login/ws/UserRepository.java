package info.martialagbangla.realestate.login.ws;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import info.martialagbangla.realestate.login.ws.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);

}
