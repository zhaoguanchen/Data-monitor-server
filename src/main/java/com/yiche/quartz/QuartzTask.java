package com.yiche.quartz;

import com.yiche.service.ExcutingRuleService;
import com.yiche.service.SyncRuleExecTimeService;
import com.yiche.utils.DateFormatSafe;
import com.yiche.utils.FinalVar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class QuartzTask {
    private final Logger logger = LoggerFactory.getLogger(QuartzTask.class);
    @Autowired
    ExcutingRuleService excutingRuleService;

    @Autowired
    private SyncRuleExecTimeService syncRuleExecTimeService;

    @Scheduled(cron = "0 0/5 * * * ?") // 每5分钟执行一次
    public void tableRule() throws Exception {
        logger.info("执行表调度任务：{}", new Date());
        excutingRuleService.runTableRule();
    }


    @Scheduled(cron = "0 0/5 * * * ?") // 每5分钟执行一次
    public void columnRule() throws Exception {
        logger.info("执行字段调度任务：{}", new Date());
        excutingRuleService.runColumnRule();
    }

    @Scheduled(cron = "0 0/25 * * * ?") // 每25分钟执行一次
    public void getTimeRuleNoPass() throws Exception {
        logger.info("未就绪循环：{}", new Date());
        excutingRuleService.getTimeRuleNoPass();
    }

    /**
     * 指数项目报告
     *
     * @throws Exception
     */
    @Scheduled(cron = "0 0 9 * * ?") // 9点发送报告
    public void indexRule() throws Exception {
        if (!DateFormatSafe.isFirstDay()) {
            logger.info("执行指数项目调度任务-日：{}", new Date());
            excutingRuleService.runIndexPro(FinalVar.DAY);
        } else {
            logger.info("执行指数项目调度任务-日和月：{}", new Date());
            excutingRuleService.runIndexPro(null);
        }
    }

    @Scheduled(cron = "0 0 7 * * ?") // 7点发送报告
    public void indexRule2() throws Exception {
        if (!DateFormatSafe.isFirstDay()) {
            logger.info("执行指数项目调度任务-日：{}", new Date());
            excutingRuleService.runIndexPro(FinalVar.DAY);
        } else {
            logger.info("执行指数项目调度任务-日和月：{}", new Date());
            excutingRuleService.runIndexPro(null);
        }
    }


    /**
     * 数仓项目
     *
     * @throws Exception
     */
    @Scheduled(cron = "0 0 9 * * ?") // 9点发送报告
    public void dataWarehourseRule() throws Exception {
        if (!DateFormatSafe.isFirstDay()) {
            logger.info("执行数仓项目调度任务-日：{}", new Date());
            excutingRuleService.runDataWarehourse(FinalVar.DAY);
        } else {
            logger.info("执行数仓项目调度任务-日和月：{}", new Date());
            excutingRuleService.runDataWarehourse(null);
        }
    }

    @Scheduled(cron = "0 0 7 * * ?") // 7点发送报告
    public void dataWarehourseRule2() throws Exception {
        if (!DateFormatSafe.isFirstDay()) {
            logger.info("执行数仓项目调度任务--日：{}", new Date());
            excutingRuleService.runDataWarehourse(FinalVar.DAY);
        } else {
            logger.info("执行数仓项目调度任务--日和月：{}", new Date());
            excutingRuleService.runDataWarehourse(null);
        }
    }


    /**
     * 渠道线索
     *
     * @throws Exception
     */
    @Scheduled(cron = "0 0 7 * * ?") // 7点发送报告
    public void platformIndex() throws Exception {
        if (!DateFormatSafe.isFirstDay()) {
            logger.info("执行渠道线索调度任务--日：{}", new Date());
            excutingRuleService.runPro(FinalVar.DAY);
        } else {
            logger.info("执行渠道线索调度任务--日和月：{}", new Date());
            excutingRuleService.runPro(null);
        }
    }

    @Scheduled(cron = "0 0 9 * * ?") // 9点发送报告
    public void platformIndex2() throws Exception {
        if (!DateFormatSafe.isFirstDay()) {
            logger.info("执行渠道线索调度任务--日：{}", new Date());
            excutingRuleService.runPro(FinalVar.DAY);
        } else {
            logger.info("执行渠道线索调度任务--日和月：{}", new Date());
            excutingRuleService.runPro(null);
        }
    }

    /**
     * 经销商数据中心
     *
     * @throws Exception
     */
    @Scheduled(cron = "0 0 7 * * ?") // 7点发送报告
    public void distributorDataCenter() throws Exception {
        if (!DateFormatSafe.isFirstDay()) {
            logger.info("执行经销商数据中心调度任务--日：{}", new Date());
            excutingRuleService.runDistributorPro(FinalVar.DAY);
        } else {
            logger.info("执行经销商数据中心调度任务--日和月：{}", new Date());
            excutingRuleService.runDistributorPro(null);
        }
    }

    @Scheduled(cron = "0 0 9 * * ?") // 9点发送报告
    public void distributorDataCenter2() throws Exception {
        if (!DateFormatSafe.isFirstDay()) {
            logger.info("执行经销商数据中心调度任务--日：{}", new Date());
            excutingRuleService.runDistributorPro(FinalVar.DAY);
        } else {
            logger.info("执行经销商数据中心调度任务--日和月：{}", new Date());
            excutingRuleService.runDistributorPro(null);
        }
    }

    /**
     * 全局报表
     *
     * @throws Exception
     */
    @Scheduled(cron = "0 0 9 * * ?") // 9点发送报告
    public void globalReport() throws Exception {
        if (!DateFormatSafe.isFirstDay()) {
            logger.info("执行全局报表调度任务--日：{}", new Date());
            excutingRuleService.globalReport(FinalVar.DAY);
        } else {
            logger.info("执行全局报表调度任务--日和月：{}", new Date());
            excutingRuleService.globalReport(null);
        }
    }

    /**
     * 易湃线索宽表
     *
     * @throws Exception
     */
    @Scheduled(cron = "0 0 7 * * ?") // 7点发送报告
    public void yipai() throws Exception {
        if (!DateFormatSafe.isFirstDay()) {
            logger.info("执行易湃线索宽表调度任务--日：{}", new Date());
            excutingRuleService.yipai(FinalVar.DAY);
        } else {
            logger.info("执行易湃线索宽表调度任务--日和月：{}", new Date());
            excutingRuleService.yipai(null);
        }
    }

    @Scheduled(cron = "0 0 9 * * ?") // 9点发送报告
    public void yipai2() throws Exception {
        if (!DateFormatSafe.isFirstDay()) {
            logger.info("执行易湃线索宽表调度任务--日：{}", new Date());
            excutingRuleService.yipai(FinalVar.DAY);
        } else {
            logger.info("执行易湃线索宽表调度任务--日和月：{}", new Date());
            excutingRuleService.yipai(null);
        }
    }

    // 每日凌晨更新规则下次的执行时间
    @Scheduled(cron = "0 0 0 * * ?")
    public void syncRuleExecTime() throws Exception {
        syncRuleExecTimeService.updateRuleExecTime();
    }

    // 更新规则下次执行时间完成后检车规则下次的执行时间
    /*@Scheduled(cron = "0 0 1 * * ?")
    public void checkRuleExecTime() throws Exception {
        syncRuleExecTimeService.checkRuleExecTime();
    }*/

    /**
     * 指数项目报告
     *
     * @throws Exception
     */
    @Scheduled(cron = "0 0 9 * * ?") // 9点发送报告
    public void noPassReport() throws Exception {
        excutingRuleService.sendTodayNoPassReport();
    }

    @Scheduled(cron = "0 0 7 * * ?") // 7点发送报告
    public void noPassRule() throws Exception {
        excutingRuleService.sendTodayNoPassReport();
    }
}

