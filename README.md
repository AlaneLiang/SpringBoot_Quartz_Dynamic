# SpringBoot_Quartz_Dynamic
在实践中遇到动态管理定时任务的需求，场景通常是动态添加、更新、删除任务，借助Quartz，可方便实现功能。 
以下使用Quartz结合Spring Boot方式使用
#测试样例结果
2018-11-30 22:50:33.608  INFO 3054 --- [           main] org.quartz.impl.StdSchedulerFactory      : Quartz scheduler 'DefaultQuartzScheduler' initialized from default resource file in Quartz package: 'quartz.properties'
2018-11-30 22:50:33.608  INFO 3054 --- [           main] org.quartz.impl.StdSchedulerFactory      : Quartz scheduler version: 2.3.0
2018-11-30 22:50:33.608  INFO 3054 --- [           main] org.quartz.core.QuartzScheduler          : JobFactory set to: com.lx.quartzdynamic.bean.AutowiringSpringBeanJobFactory@5cd61783
2018-11-30 22:50:33.626  INFO 3054 --- [           main] org.quartz.core.QuartzScheduler          : Scheduler DefaultQuartzScheduler_$_NON_CLUSTERED started.
2018-11-30 22:50:33.626  INFO 3054 --- [           main] c.lx.quartzdynamic.config.QuartzManager  : start jobs finished.
2018-11-30 22:50:34.009  INFO 3054 --- [eduler_Worker-1] com.lx.quartzdynamic.job.TestTask        : TestTask 开始执行
2018-11-30 22:50:36.004  INFO 3054 --- [eduler_Worker-2] com.lx.quartzdynamic.job.TestTask        : TestTask 开始执行
2018-11-30 22:50:37.013  INFO 3054 --- [eduler_Worker-1] com.lx.quartzdynamic.job.TestTask        : TestTask 执行结束
2018-11-30 22:50:38.006  INFO 3054 --- [eduler_Worker-3] com.lx.quartzdynamic.job.TestTask        : TestTask 开始执行
2018-11-30 22:50:39.007  INFO 3054 --- [eduler_Worker-2] com.lx.quartzdynamic.job.TestTask        : TestTask 执行结束
2018-11-30 22:50:40.006  INFO 3054 --- [eduler_Worker-4] com.lx.quartzdynamic.job.TestTask        : TestTask 开始执行
2018-11-30 22:50:41.011  INFO 3054 --- [eduler_Worker-3] com.lx.quartzdynamic.job.TestTask        : TestTask 执行结束
2018-11-30 22:50:42.006  INFO 3054 --- [eduler_Worker-5] com.lx.quartzdynamic.job.TestTask        : TestTask 开始执行
2018-11-30 22:50:43.011  INFO 3054 --- [eduler_Worker-4] com.lx.quartzdynamic.job.TestTask        : TestTask 执行结束
2018-11-30 22:50:43.630  INFO 3054 --- [           main] com.lx.quartzdynamic.QuartzDynamicTests  : start update job
2018-11-30 22:50:43.631  INFO 3054 --- [           main] com.lx.quartzdynamic.QuartzDynamicTests  : end update job
2018-11-30 22:50:45.004  INFO 3054 --- [eduler_Worker-6] com.lx.quartzdynamic.job.TestTask        : TestTask 开始执行
2018-11-30 22:50:45.009  INFO 3054 --- [eduler_Worker-5] com.lx.quartzdynamic.job.TestTask        : TestTask 执行结束
2018-11-30 22:50:48.002  INFO 3054 --- [eduler_Worker-7] com.lx.quartzdynamic.job.TestTask        : TestTask 开始执行
2018-11-30 22:50:48.007  INFO 3054 --- [eduler_Worker-6] com.lx.quartzdynamic.job.TestTask        : TestTask 执行结束
2018-11-30 22:50:51.004  INFO 3054 --- [eduler_Worker-7] com.lx.quartzdynamic.job.TestTask        : TestTask 执行结束
2018-11-30 22:50:51.005  INFO 3054 --- [eduler_Worker-8] com.lx.quartzdynamic.job.TestTask        : TestTask 开始执行
2018-11-30 22:50:53.636  INFO 3054 --- [           main] com.lx.quartzdynamic.QuartzDynamicTests  : start delete job
2018-11-30 22:50:53.637  INFO 3054 --- [           main] com.lx.quartzdynamic.QuartzDynamicTests  : end delete job
2018-11-30 22:50:54.011  INFO 3054 --- [eduler_Worker-8] com.lx.quartzdynamic.job.TestTask        : TestTask 执行结束
2018-11-30 22:51:03.642  INFO 3054 --- [           main] com.lx.quartzdynamic.QuartzDynamicTests  : start add job
2018-11-30 22:51:03.643  INFO 3054 --- [           main] org.quartz.core.QuartzScheduler          : Scheduler DefaultQuartzScheduler_$_NON_CLUSTERED started.
2018-11-30 22:51:03.643  INFO 3054 --- [           main] com.lx.quartzdynamic.QuartzDynamicTests  : end add job
2018-11-30 22:51:03.644  INFO 3054 --- [eduler_Worker-9] com.lx.quartzdynamic.job.TestTask        : TestTask 开始执行
2018-11-30 22:51:06.005  INFO 3054 --- [duler_Worker-10] com.lx.quartzdynamic.job.TestTask        : TestTask 开始执行
2018-11-30 22:51:06.647  INFO 3054 --- [eduler_Worker-9] com.lx.quartzdynamic.job.TestTask        : TestTask 执行结束
2018-11-30 22:51:09.003  INFO 3054 --- [eduler_Worker-1] com.lx.quartzdynamic.job.TestTask        : TestTask 开始执行
2018-11-30 22:51:09.008  INFO 3054 --- [duler_Worker-10] com.lx.quartzdynamic.job.TestTask        : TestTask 执行结束
2018-11-30 22:51:12.002  INFO 3054 --- [eduler_Worker-2] com.lx.quartzdynamic.job.TestTask        : TestTask 开始执行
2018-11-30 22:51:12.007  INFO 3054 --- [eduler_Worker-1] com.lx.quartzdynamic.job.TestTask        : TestTask 执行结束
2018-11-30 22:51:13.648  INFO 3054 --- [           main] com.lx.quartzdynamic.QuartzDynamicTests  : start update job
2018-11-30 22:51:13.649  INFO 3054 --- [           main] com.lx.quartzdynamic.QuartzDynamicTests  : end update job
2018-11-30 22:51:15.002  INFO 3054 --- [eduler_Worker-3] com.lx.quartzdynamic.job.TestTask        : TestTask 开始执行
2018-11-30 22:51:15.007  INFO 3054 --- [eduler_Worker-2] com.lx.quartzdynamic.job.TestTask        : TestTask 执行结束
2018-11-30 22:51:18.005  INFO 3054 --- [eduler_Worker-3] com.lx.quartzdynamic.job.TestTask        : TestTask 执行结束
2018-11-30 22:51:18.006  INFO 3054 --- [eduler_Worker-4] com.lx.quartzdynamic.job.TestTask        : TestTask 开始执行
2018-11-30 22:51:21.005  INFO 3054 --- [eduler_Worker-5] com.lx.quartzdynamic.job.TestTask        : TestTask 开始执行
2018-11-30 22:51:21.009  INFO 3054 --- [eduler_Worker-4] com.lx.quartzdynamic.job.TestTask        : TestTask 执行结束
2018-11-30 22:51:23.651  INFO 3054 --- [           main] com.lx.quartzdynamic.QuartzDynamicTests  : start delete job
2018-11-30 22:51:23.652  INFO 3054 --- [           main] com.lx.quartzdynamic.QuartzDynamicTests  : end delete job
2018-11-30 22:51:23.653  INFO 3054 --- [           main] com.lx.quartzdynamic.QuartzDynamicTests  : end.
