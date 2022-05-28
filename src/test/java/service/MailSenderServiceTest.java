package service;

import mailSender.model.MailInfo;
import mailSender.service.MailSenderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import mailSender.type.AuthenticationType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MailSenderServiceTest {

    @Mock
    MailInfo setting;

    MailSenderService mailSenderService;

    @BeforeEach
    public void setup() {
        given(setting.getHost()).willReturn("smtp.gmail.com");

        // SSL port --> 465, TLS port --> 587
        given(setting.getUsername()).willReturn("example.mail.server.sender@gmail.com");
        given(setting.getPassword()).willReturn("example@mail@server");

    }

    @Test
    void setProperties() {
    }

    @Test
    void sendSSL() {
        given(setting.getServerPort()).willReturn("465");
        given(setting.getType()).willReturn(AuthenticationType.SSL);

        mailSenderService = new MailSenderService(setting);

        assertThat(mailSenderService.send("farkhondeh.arzi@gmail.com", "example", "plain text")).isEqualTo(true);
    }

    @Test
    void sendPlain() {
        given(setting.getServerPort()).willReturn("587");
        given(setting.getType()).willReturn(AuthenticationType.PLAIN);

        mailSenderService = new MailSenderService(setting);
        assertThat(mailSenderService.send("farkhondeh.arzi@gmail.com", "example", "plain text")).isEqualTo(true);
    }
}