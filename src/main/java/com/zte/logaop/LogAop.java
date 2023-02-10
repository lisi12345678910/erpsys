package com.zte.logaop;

import com.zte.login.model.LoginUser;
import com.zte.sys.model.Journal;
import com.zte.sys.service.ISysJournalService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect //标识为切面
public class LogAop {

    @Autowired
    private ISysJournalService iSysJournalService;

    @Autowired
    private RedisTemplate redisTemplate;

    //声明公共切入点表达式
    @Pointcut("@annotation(com.zte.logaop.Log)")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) throws Exception {
        Signature signature = joinPoint.getSignature();//获取签名信息

        //jcontent
        String name = signature.getName();//方法名
        String name1 = joinPoint.getTarget().getClass().getName();//方法所属类名
        String funname = name1+"."+name;

        //uid
        LoginUser loginUser = (LoginUser) redisTemplate.opsForValue().get("loginUser");
        Integer uId = loginUser.getUId();

        //moduleid  &&  jcontent
        Log annotationLog = getAnnotationLog(joinPoint);
        String moduleid = annotationLog.value();//模块id(注解内容)

        String action = annotationLog.action();//操作描述(注解内容)
        String jcontent = "操作："+action+"操作------类名.方法名："+funname;
        //读取注释内容


        //存入数据库
        Journal journal = new Journal();
        journal.setModuleId(Integer.parseInt(moduleid));
        journal.setUId(uId);
        journal.setJcontent(jcontent);
        journal.setJdate(new Date());

        Boolean b = iSysJournalService.creatjournal(journal);
        if (b) {
            System.out.println("创建日志成功");
        }else {
            System.out.println("创建日志失败");
        }






    }




    //获取注解
    private static Log getAnnotationLog(JoinPoint joinPoint) throws Exception {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(Log.class);
        }
        return null;
    }
}
