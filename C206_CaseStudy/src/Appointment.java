
import java.time.LocalDate;


public class Appointment {
	private String name;
	private LocalDate appointmentDT;
	private String time;
	private String appointmentReason;
	

	public Appointment(String name, LocalDate appointmentDT, String time, String appointmentReason) {
		this.name = name;
		this.appointmentDT = appointmentDT;
		this.time = time;
		this.appointmentReason = appointmentReason;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getappointmentDT() {
		return appointmentDT;
	}

	public void setappointmentDT (LocalDate appointmentDT){
		this.appointmentDT = appointmentDT;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	public String getappointmentReason() {
		return appointmentReason;
	}

	public void setappointmentReason(String appointmentReason) {
		this.appointmentReason = appointmentReason;
	}
	public String toString() {
		
		// Write your codes here
	        return String.format("%-10s %-30s %-10d", getName(),
	                getappointmentDT(), getappointmentReason());
	    }
	

}
