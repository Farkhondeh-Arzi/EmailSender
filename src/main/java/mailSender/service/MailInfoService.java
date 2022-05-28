package mailSender.service;

import mailSender.dao.MailRepository;
import mailSender.model.MailInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailInfoService implements ServiceInterface<MailInfo> {

    @Autowired
    MailRepository mailRepo;

    @Override
    public List<MailInfo> getAll() {
        return mailRepo.findAll();
    }

    @Override
    public MailInfo add(MailInfo mailInfo) {
        return mailRepo.save(mailInfo);
    }

    @Override
    public MailInfo get(int Id) {
        return mailRepo.getById(Id);
    }

    @Override
    public MailInfo update(MailInfo mailInfo, int Id) {
        MailInfo oldMailInfo = mailRepo.getById(Id);
        oldMailInfo.setHost(mailInfo.getHost());
        oldMailInfo.setServerAddress(mailInfo.getServerAddress().toString());
        oldMailInfo.setServerPort(mailInfo.getServerPort());
        oldMailInfo.setUsername(mailInfo.getUsername());
        oldMailInfo.setPassword(mailInfo.getPassword());
        oldMailInfo.setType(mailInfo.getType());
        return add(oldMailInfo);
    }

    @Override
    public void delete(int Id) {
        mailRepo.delete(mailRepo.getById(Id));
    }
}
