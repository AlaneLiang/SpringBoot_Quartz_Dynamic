package com.lx.quartzdynamic.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseTask implements Job {

    private Logger logger = LoggerFactory.getLogger(BaseTask.class);

    protected abstract void executeInternal(JobExecutionContext context);

    protected String cronExpression;

    @Override
    public void execute(JobExecutionContext context) {
        try {
            executeInternal(context);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            logger.error("job 执行失败！");
        }
    }

    public String getCronExpression() {
        return cronExpression;
    }
}

