package com.itqf.demo01.vo;

/**
 * projectName:easys
 *
 * @author: 三毛
 * time:2020/10/1317:00
 * description:
 */
public class VoAsk {

        private long id;
        private String stuname;
        private java.sql.Timestamp startTime;
        private java.sql.Timestamp endTime;
        private long count;
        private String status;
        private String reason;


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getStuname() {
            return stuname;
        }

        public void setStuname(String stuname) {
            this.stuname = stuname;
        }

     public java.sql.Timestamp getStartTime() {
            return startTime;
        }

        public void setStartTime(java.sql.Timestamp startTime) {
            this.startTime = startTime;
        }


        public java.sql.Timestamp getEndTime() {
            return endTime;
        }

        public void setEndTime(java.sql.Timestamp endTime) {
            this.endTime = endTime;
        }


        public long getCount() {
            return count;
        }

        public void setCount(long count) {
            this.count = count;
        }


        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }


        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }



}
