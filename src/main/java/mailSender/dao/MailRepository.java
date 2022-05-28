package mailSender.dao;

import mailSender.model.MailInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailRepository extends JpaRepository<MailInfo, Integer> {
}
