package com.zcl.somecode.morethread;

/**
 * Created by zhanchunliang on 16/11/17.
 */
public class MailTest {

    private static final String acceptAddress = "liangaiju@126.com";
    public static final String mailcontext = "text";

    public static void main(String[] args) {
        MailBean mailBean = new MailBean();
        mailBean.setRecAdd(acceptAddress);
        mailBean.setTitleStr("公关事件导出请求");
        mailBean.setBodyStr(mailcontext);
        MailThreadTask mailTask = new MailThreadTask(mailBean);
        MailThreadPool mp = MailThreadPool.getInstance();
        //发送邮件线程池执行
        mp.sendEmailPool.execute(mailTask);
    }
}
