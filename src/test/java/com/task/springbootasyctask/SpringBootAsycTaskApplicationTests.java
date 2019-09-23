package com.task.springbootasyctask;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEParsingException;
import com.task.springbootasyctask.server.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAsycTaskApplicationTests {

    @Autowired
    BookService bookService;
    @Autowired
    JavaMailSender javaMailSender; //--实现类是javamailsender

    @Test
    public void contextLoads() {
        //异步调用;

        bookService.getList();
        List<String> list1 = null;
        while (list1 == null) {
            System.out.println("list在执行吗");

        }
    }

    @Test
    public void sendMailSimple() {
        //通过简单消息-包装类
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //设置邮件 标题<subject>, 内容<Text>, 发给谁<to> 谁发的<From>
        simpleMailMessage.setSubject("今天在忙啥了");
        simpleMailMessage.setText("你在忙啥了,今天忙吗?最近过的还好吗");
        simpleMailMessage.setFrom("251006339@qq.com");
        simpleMailMessage.setTo("756893228@qq.com");


        javaMailSender.send(simpleMailMessage);//发送消息;


    }

    @Test
    public void sendMail() throws MessagingException {
        //通过复杂类型:
        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();//创建消息类;
        //通过构造器传入对象MimeMessage  开启多文件上传 ;multipart;
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage,true);
        mimeMessageHelper.setSubject("通知---今晚开会");
         //设置文件内容 发送html类型的----true
        mimeMessageHelper.setText("<b style='color:red'> 你在忙啥了,今天过得开心吗</b>");
        mimeMessageHelper.setFrom("251006339@qq.com");
        mimeMessageHelper.setTo("756893228@qq.com");//到哪里  --from 来自
        //上传文件附件  --上传文件附件--流的形式转换成文件; 可以上传多个文件
        mimeMessageHelper.addAttachment("1.jpg",new File("C:\\Users\\Administrator.BY-201906202342\\Desktop\\timg (1).jpg"));//多文件的 类型或路径
        //文件后缀,ini--
       mimeMessageHelper.addAttachment("2.ini",new File("C:\\Users\\Administrator.BY-201906202342\\Desktop\\Config.ini"));
        javaMailSender.send(mimeMailMessage);

    }
}
