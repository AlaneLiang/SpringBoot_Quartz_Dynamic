package com.lx.quartzdynamic.job;

import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component("testTask")
public class TestTask extends BaseTask {

    private Logger logger = LoggerFactory.getLogger(TestTask.class);

    @PostConstruct
    public void init() {
        this.cronExpression = "0/2 * * * * ? ";
    }

    @Override
    protected void executeInternal(JobExecutionContext context) {
        logger.info("TestTask 开始执行");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            logger.info("TestTask 执行暂停");
        }
        logger.info("TestTask 执行结束");
    }
}
