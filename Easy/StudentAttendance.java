public class StudentAttendance {
    private String studentId;
    private String studentName;
    private String date;
    private String status;

    public StudentAttendance(String studentId, String studentName, String date, String status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.date = date;
        this.status = status;
    }

    // Getters
    public String getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public String getDate() { return date; }
    public String getStatus() { return status; }
}
