package com.clayfin.utility;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clayfin.entity.Employee;
import com.clayfin.repository.EmployeeRepo;
import com.clayfin.repository.LeaveRepo;
import com.clayfin.repository.TaskRepo;

@Component
public class RepoHelper {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private LeaveRepo leaveRepo;

	@Autowired
	private TaskRepo taskRepo;

	public Boolean isEmployeeExist(Integer employeeId) {
		return employeeRepo.findById(employeeId).isPresent();
	}

	public Boolean isLeaveExist(Integer leaveId) {
		return leaveRepo.findById(leaveId).isPresent();
	}

	public Boolean isTaskExist(Integer taskId) {
		return taskRepo.findById(taskId).isPresent();
	}

	public Boolean isValidEmployeeOfThisManager(Integer managerId, Integer employeeId) {
		Employee employee = employeeRepo.findById(employeeId).orElseGet(null);

		if (employee == null)
			return false;

		if (employee.getManager() != null && employee.getManager().getEmployeeId() == managerId)
			return true;

		return false;
	}

	public LocalTime findTimeBetweenTimestamps(LocalDateTime fromTime, LocalDateTime toTime) {

		Duration duration = Duration.between(fromTime, toTime);

		int hours = (int) duration.toHoursPart();
		int minutes = (int) duration.toMinutesPart();
		
		System.out.println("Hours :"+ hours);
		System.out.println("Minutes : "+minutes);

		return LocalTime.of(hours, minutes);
	}

}
