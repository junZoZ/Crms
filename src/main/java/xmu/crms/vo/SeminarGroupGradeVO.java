package xmu.crms.vo;
/**
 * @author  cb
 */
public class SeminarGroupGradeVO {
    private String topicSerial;
    private String groupName;
    private String leaderName;
    private Integer presentationGrade;
    private Integer reportGrade;
    private Integer finalGrade;
    private String report;
    private String submit;

    @Override
    public String toString() {
        return "SeminarGroupGradeVO{" +
                "topicSerial='" + topicSerial + '\'' +
                ", groupName='" + groupName + '\'' +
                ", leaderName='" + leaderName + '\'' +
                ", presentationGrade=" + presentationGrade +
                ", reportGrade=" + reportGrade +
                ", finalGrade=" + finalGrade +
                ", report='" + report + '\'' +
                ", submit='" + submit + '\'' +
                '}';
    }

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    public SeminarGroupGradeVO() {
    }

    public String getTopicSerial() {
        return topicSerial;
    }

    public void setTopicSerial(String topicSerial) {
        this.topicSerial = topicSerial;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public Integer getPresentationGrade() {
        return presentationGrade;
    }

    public void setPresentationGrade(Integer presentationGrade) {
        this.presentationGrade = presentationGrade;
    }

    public Integer getReportGrade() {
        return reportGrade;
    }

    public void setReportGrade(Integer reportGrade) {
        this.reportGrade = reportGrade;
    }

    public Integer getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(Integer finalGrade) {
        this.finalGrade = finalGrade;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

}
