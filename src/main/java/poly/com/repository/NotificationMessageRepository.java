package poly.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poly.com.entitis.NotificationMessage;

@Repository
public interface NotificationMessageRepository extends JpaRepository<NotificationMessage, String> {

}
