package com.zcl.somecode.morethread;

/***
 * 
* @ClassName: MailThreadTask
* @Description: TODO(这里用一句话描述这个类的作用)
* @author chunliang.zhan
* @date 2016年8月25日 下午4:03:52
*
 */
public class MailThreadTask implements Runnable {
	
	private MailBean mailBean;
	
	public MailThreadTask(MailBean mailBean){
		this.mailBean = mailBean;
	};
	
	@Override
	public void run() {
		// TODO: 16/11/17
//		MailUtil mu = MailUtil.getInstance();
//		//发送邮件
//		mu.sendEmail(mailBean.getRecAdd(),mailBean.getTitleStr(),mailBean.getBodyStr());
		System.out.println("do something...");

	}

}
