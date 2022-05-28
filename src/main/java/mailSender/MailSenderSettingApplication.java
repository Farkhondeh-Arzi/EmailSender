package mailSender;

import mailSender.service.MailInfoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = MailInfoService.class)
public class MailSenderSettingApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailSenderSettingApplication.class, args);
    }
}
