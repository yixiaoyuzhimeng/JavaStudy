package Model;

public class Grades {
    private int id;
    private String stu_name;
    private String course_name;
    private int grades;
    private String cpid;
    private String spid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }

    public String getCpid() {
        return cpid;
    }

    public void setCpid(String cpid) {
        this.cpid = cpid;
    }

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }


    public Grades() {
    }

    public Grades(String stu_name, String course_name, int grades, String cpid) {
        this.stu_name = stu_name;
        this.course_name = course_name;
        this.grades = grades;
        this.cpid = cpid;
    }

    public Grades(String stu_name, String course_name, int grades, String cpid,String spid) {
        this.stu_name = stu_name;
        this.course_name = course_name;
        this.grades = grades;
        this.cpid = cpid;
        this.spid = spid;
    }

}
