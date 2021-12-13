package vo;

import java.sql.Date;
import java.sql.Time;

public class MemberVo {
	private int id;
	private String username;
	private String password;
	private String email;
	private Date dateAt;
	private Time timeAt;
	
	public MemberVo() {
	}

	public MemberVo(int id, String username, String password, String email, Date dateAt, Time timeAt) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dateAt = dateAt;
		this.timeAt = timeAt;
	}

	public MemberVo(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateAt() {
		return dateAt;
	}

	public void setDateAt(Date dateAt) {
		this.dateAt = dateAt;
	}

	public Time getTimeAt() {
		return timeAt;
	}

	public void setTimeAt(Time timeAt) {
		this.timeAt = timeAt;
	}

	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", dateAt=" + dateAt + ", timeAt=" + timeAt + "]";
	}
	
	
}


