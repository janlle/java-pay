package com.andy.pay.service;//package com.andy.pay.service;
//
//import com.andy.pay.common.enums.ResultEnum;
//import com.andy.pay.common.exception.AppException;
//import com.andy.pay.common.utils.AppUtils;
//import com.andy.pay.common.utils.CodeUtil;
//import com.andy.pay.common.utils.JwtTokenUtil;
//import com.andy.pay.mapper.UserMapper;
//import com.andy.pay.object.entity.User;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.web.client.RestTemplate;
//import org.thymeleaf.context.Context;
//import org.thymeleaf.context.IContext;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//import org.thymeleaf.TemplateEngine;
//
//import javax.mail.internet.MimeMessage;
//import java.time.LocalDateTime;
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author Leone
// * @since 2018-05-09
// **/
//@Slf4j
//@Service
//public class MessageService {
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Autowired
//    private TemplateEngine templateEngine;
//
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private UserMapper userMapper;
//
//    private String template;
//
//    private String smsProviderUrl;
//
//    private String key;
//
//    private String tplId;
//
//    private String provicerUrl;
//
//    public boolean sendMail(String from, String to, String subject) throws RuntimeException {
//        String token = storage(to);
//        try {
//            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//
//            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
//            Map<String, Object> map = new HashMap<>();
//            map.put("token", token);
//            map.put("to", to);
//            IContext context = new Context(Locale.CHINESE, map);
//
//            String process = templateEngine.process(template, context);
//            messageHelper.setFrom(from);
//            messageHelper.setTo(to);
//            messageHelper.setSubject(subject);
//            messageHelper.setText(process, true);
//            javaMailSender.send(mimeMessage);
//            log.info("发送邮件,[邮件发送成功]->{}!", to);
//        } catch (Exception e) {
//            log.error("发送邮件,[邮件发送失败]->{}!", to);
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//
//    public String storage(String to) {
//        String code = UUID.randomUUID().toString().replace("-", "");
//        Map<String, String> map = new HashMap<>();
//        map.put("code", code);
//        map.put("time", LocalDateTime.now().toString());
//        String token = JwtTokenUtil.getToken(map);
//        try {
//            redisTemplate.opsForValue().set(code, to, 1800, TimeUnit.SECONDS);
//        } catch (Exception e) {
//            log.info("生成验证码,[保存验证码失败]->{}", to);
//        }
//        return token;
//    }
//
//    public boolean sendSms(String to) throws RuntimeException {
////        String codeToken = CodeUtil.genSexNum();
//        //http://v.juhe.cn/sms/send?mobile=%s&tpl_id=%s&tpl_value=%s&key=%s
////        smsProviderUrl = String.format(smsProviderUrl, to, tplId, AppUtils.urlEncoder("#code#=" + codeToken), key);
////        SmsDTO result = restTemplate.getForObject(smsProviderUrl, SmsDTO.class);
////        log.info("短信平台响应结果为：{}", result);
////        if (result != null) {
////            if (result.getError_code() == 0){
////                log.info("发送验证码成功,验证码为:{}" ,codeToken);
////            } else {
//////                log.error("获取验证码失败！错误码为：{}", result.getError_code());
////                throw new AppException(ResultEnum.GET_VALIDATE_CODE_ERROR);
////            }
////        }
////        try {
////            stringRedisTemplate.opsForValue().set(to, codeToken, 120, TimeUnit.SECONDS);
////        } catch (Exception e) {
////            log.error("短信验证码,[保存验证码失败]->to:{},codeToken:{}", to, codeToken);
////        }
//        return true;
//    }
//
//    public boolean activateMail(String token, String mail) throws RuntimeException {
//        if (token == null || mail == null) {
//            log.error("邮件激活,[token或mail为空]->token:{},mail:{}", token, mail);
//        }
//        Map<String, String> map = null;
//        try {
//            map = JwtTokenUtil.verifyToken(token);
//        } catch (Exception e) {
//            log.error("邮件激活,[token验证失败]->{}", token);
//            return false;
//        }
//        String code = map.get("code");
//        String localCode = (String)redisTemplate.opsForValue().get(code);
//        if (localCode != null && mail.equals(localCode)) {
//            log.info("邮件激活,[token验证成功]->mail:{},token:{}",mail, token);
////            List<User> users = userMapper.findByEmail(mail);
////            if (users != null && users.size() > 0) {
////                User user = users.get(0);
//////                userService.activatedUser(user.getId());
////            }
//            redisTemplate.delete(code);
//            return true;
//        }
//        return false;
//    }
//
//    public void activateSms(String phone, String code) throws RuntimeException {
//        if (phone != null && code != null) {
//            String result = stringRedisTemplate.opsForValue().get(phone);
//            if (result == null) {
//                log.warn("验证码已过期，请重新获取！");
//                throw new AppException(ResultEnum.VALIDATE_CODE_EXPIRED);
//            }
//            if (!result.equals(code)){
//                log.error("输入的验证码有误,原始验证码为：{}，输入验证码为：{}", result, code);
//                throw new AppException(ResultEnum.CODE_MISMATCHING);
//            }
//        }
//        stringRedisTemplate.delete(phone);
//        log.info("短信验证码,[验证码输入正确]->phone:{},code:{}",phone, code);
//    }
//}
