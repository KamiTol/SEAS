package SEAS.Model.Repository;

import SEAS.Model.Domain.Schedule;
import SEAS.Model.shared.FileJsonAdapter;

import java.util.List;

public class ScheduleRepository {
    private FileJsonAdapter<Schedule> fileJsonAdapter;
    private String path;

    public ScheduleRepository(String path) {
        this.path = path;
        this.fileJsonAdapter = FileJsonAdapter.getInstance();
    }

    public boolean insert(Schedule schedule){
        List<Schedule> schedules = fileJsonAdapter.getObjects(path, Schedule[].class);
        schedules.add(schedule);
        return fileJsonAdapter.writeObjects(path, schedules);
    }

    public boolean delete(String id){
        List<Schedule> schedules = fileJsonAdapter.getObjects(path, Schedule[].class);
        for (Schedule schedule : schedules) {
            if (schedule.getId().equals(id)) {
                schedules.remove(schedule);
                return fileJsonAdapter.writeObjects(path, schedules);
            }
        }
        return false;
    }

    public boolean update(Schedule updatedSchedule){
    List<Schedule> schedules = fileJsonAdapter.getObjects(path, Schedule[].class);
    for (int i = 0; i < schedules.size(); i++) {
        if (schedules.get(i).getId().equals(updatedSchedule.getId())) {
            schedules.set(i, updatedSchedule);
            return fileJsonAdapter.writeObjects(path, schedules);
        }
    }
    return false;
    }

    public Schedule getSchedule(String id){
        List<Schedule> schedules = fileJsonAdapter.getObjects(path, Schedule[].class);
        for (Schedule schedule : schedules) {
            if (schedule.getId().equals(id)) {
                return schedule;
            }
        }
        return null;
    }

    public List<Schedule> getSchedules(){
        return fileJsonAdapter.getObjects(path, Schedule[].class);
    }
}
