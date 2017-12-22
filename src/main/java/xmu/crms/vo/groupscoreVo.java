package xmu.crms.vo;

import javax.validation.constraints.Null;
import java.util.ArrayList;

public class groupscoreVo {
    Integer id;
    String topic;
    String groupname;
    People leader;
    ArrayList<People> member;
    Integer discussionScore;
    String is_submit;
    Integer reportScore;
    Integer score;
    String report;

    public groupscoreVo() {
    }

    public groupscoreVo(String topic, String groupname, People leader, ArrayList<People> member, Integer discussionScore, String is_submit, Integer reportScore, Integer score, String report) {
        this.topic = topic;
        this.groupname = groupname;
        this.leader = leader;
        this.member = member;
        this.discussionScore = discussionScore;
        this.is_submit = is_submit;
        this.reportScore = reportScore;
        this.score = score;
        this.report = report;
    }

    public groupscoreVo(Integer id, String topic, String groupname, People leader, ArrayList<People> member, Integer discussionScore, String is_submit, Integer reportScore, Integer score, String report) {
        this.id = id;
        this.topic = topic;
        this.groupname = groupname;
        this.leader = leader;
        this.member = member;
        this.discussionScore = discussionScore;
        this.is_submit = is_submit;
        this.reportScore = reportScore;
        this.score = score;
        this.report = report;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public People getLeader() {
        return leader;
    }

    public void setLeader(People leader) {
        this.leader = leader;
    }

    public ArrayList<People> getMember() {
        return member;
    }

    public void setMember(ArrayList<People> member) {
        this.member = member;
    }

    public Integer getDiscussionScore() {
        return discussionScore;
    }

    public void setDiscussionScore(Integer discussionScore) {
        this.discussionScore = discussionScore;
    }

    public String getIs_submit() {
        return is_submit;
    }

    public void setIs_submit(String is_submit) {
        this.is_submit = is_submit;
    }

    public Integer getReportScore() {
        return reportScore;
    }

    public void setReportScore(Integer reportScore) {
        this.reportScore = reportScore;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}
