package logic;

public class Schedule {
    
    private int scheduleId;
    private String startTime;
    private String endTime;

    public Schedule() {
    }

    public Schedule(int scheduleId, String startTime, String endTime) {
        this.scheduleId = scheduleId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    
}
