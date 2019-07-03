package com.study.java8;

import com.aliyuncs.utils.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author 华志宾
 * @date 2019-04-16
 */
public class Main {

    public static void main(String args[]){
        Main main = new Main();
        main.get();
    }

    public void get(){
        ExportTaskQuery query = new ExportTaskQuery();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            query.setStartDate("2019-04-16T12:33:12Z");
            query.setStartDate(sdf.format(DateUtils.addHours(sdf.parse(query.getStartDate()),8)));
            System.out.println(query.getStartDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }


        query.setBusinessType("");
        query.setOutId("1234");
        dealQuery(query);
        System.out.println(query.getBusinessType());
    }

    public void dealQuery(ExportTaskQuery query){
        if(query == null){
            query = new ExportTaskQuery();
        }
        if(StringUtils.isEmpty(query.getBusinessType())){
            query.setBusinessType(null);
        }
        if(StringUtils.isEmpty(query.getTaskStatus())){
            query.setTaskStatus(null);
        }
    }

    class ExportTaskQuery{
        private Long cid;

        private Integer eid;

        private String taskStatus;

        private String businessType;

        private String startDate;

        private String endDate;

        private String outId;

        public Long getCid() {
            return cid;
        }

        public void setCid(Long cid) {
            this.cid = cid;
        }

        public Integer getEid() {
            return eid;
        }

        public void setEid(Integer eid) {
            this.eid = eid;
        }

        public String getTaskStatus() {
            return taskStatus;
        }

        public void setTaskStatus(String taskStatus) {
            this.taskStatus = taskStatus;
        }

        public String getBusinessType() {
            return businessType;
        }

        public void setBusinessType(String businessType) {
            this.businessType = businessType;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getOutId() {
            return outId;
        }

        public void setOutId(String outId) {
            this.outId = outId;
        }
    }

}
