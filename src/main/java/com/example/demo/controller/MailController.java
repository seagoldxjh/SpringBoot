/**
 * FileName: MailController
 * Author:   xjh
 * Date:     2019-07-14 11:11
 * Description: 发送邮件控制器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo.controller;


import com.example.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈发送邮件控制器〉
 *
 * @author xjh
 * @create 2019-07-14
 * @since 1.0.0
 */
@RestController
public class MailController {

    @Autowired
    MailService mailService;

    @RequestMapping("/sendSimpleMail")
    public String sendSimpleMail() {
        //发给谁
        String to = "1157418149@qq.com";
        //邮件标题
        String subject = "test html mail";
        //邮件内容
        String content = "hello, this is html mail！";
        mailService.sendSimpleMail(to, subject, content);
        return "success";
    }

    @RequestMapping("/sendHtmlMail")
    public String  sendHtmlMail() {
        String to = "1157418149@qq.com";
        String subject = "test html mail";
        String content = "hello, this is html mail";
        mailService.sendHtmlMail(to, subject, content);
        return "HtmlMail";
    }

    @RequestMapping("/sendAttachmentsMail")
    public String sendAttachmentsMail() {
        String filePath="src/main/resources/static/1.png";
        mailService.sendAttachmentMail("1157418149@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
        return "success";
    }

}