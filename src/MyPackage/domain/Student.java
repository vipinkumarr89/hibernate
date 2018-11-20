package MyPackage.domain;
public class Student {
    private int studid, smarks;
    private String sname;

    public Student() {
    }

    public Student( String sname,int smarks) {
        this.sname = sname;
        this.smarks = smarks;
    }

    public Student(int studid,  String sname, int smarks) {
        this.studid = studid;
        this.smarks = smarks;
        this.sname = sname;
    }

    public int getStudid() {
        return studid;
    }

    public void setStudid(int studid) {
        this.studid = studid;
    }

    public int getSmarks() {
        return smarks;
    }

    public void setSmarks(int smarks) {
        this.smarks = smarks;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studid=" + studid +
                ", sname='" + sname +
                ", smarks=" + smarks + '\'' +
                '}';
    }
}




