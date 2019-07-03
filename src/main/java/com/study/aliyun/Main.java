package com.study.aliyun;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.rds.model.v20140815.DescribeSlowLogRecordsRequest;
import com.aliyuncs.rds.model.v20140815.DescribeSlowLogRecordsResponse;
import com.google.gson.Gson;

/**
 * @author 华志宾
 * @date 2019-04-03
 */
public class Main {

    public static void main(String args[]){
        /** 创建DefaultAcsClient实例并初始化*/
        DefaultProfile profile = DefaultProfile.getProfile(
                /** 您的可用区ID*/
                "cn-hangzhou",
                /** 您的AccessKey ID*/
                "LTAI0L3BiJbro7uG",
                /** 您的AccessKey Secret*/
                "WYtNH5ysHl1FkWAjHw0HrKAxFDnCeB");
        IAcsClient client = new DefaultAcsClient(profile);
        /**
         * 创建API请求并设置参数
         */
        DescribeSlowLogRecordsRequest request = new DescribeSlowLogRecordsRequest();
        /**
         * 系统规定参数，取值：DescribeSlowLogs。
         */
        request.setActionName("DescribeSlowLogRecords");
        /**
         * 实例ID。
         */
        request.setDBInstanceId("rr-bp19o81n2b3s1t330");
        /**
         * 查询开始日期，格式：yyyy-MM-ddZ。
         */
        request.setStartTime("2019-04-03T13:00Z");
        /**
         * 查询结束日期，不能小于查询开始日期，与查询开始日期间隔不超过31天。格式：yyyy-MM-ddZ。
         */
        request.setEndTime("2019-04-03T17:00Z");
        /**
         * 数据库名称 非必填
         */
//        request.setDBName("");


        try {
            DescribeSlowLogRecordsResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
    }
}
