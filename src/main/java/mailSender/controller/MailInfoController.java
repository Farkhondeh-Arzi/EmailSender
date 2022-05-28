package mailSender.controller;

import mailSender.model.MailInfo;
import mailSender.service.MailInfoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail-info")
public class MailInfoController {

    private final MailInfoService service;

    public MailInfoController(MailInfoService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public MailInfo getMailInfo() {
        return service.get(1);
    }

    @PostMapping("/add")
    public void addMailInfo(@RequestBody MailInfo mailInfo) {
        service.add(mailInfo);
    }

    @PutMapping("/update")
    public void updateMailInfo(@RequestBody MailInfo mailInfo) {
        service.update(mailInfo, 1);
    }
}
