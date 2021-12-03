package beans;

import java.util.Objects;

import conn.web.MysqlConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InfoEntity {
	int id;
	String firstname, lastname, username, password, phone, email, description, createdDate, updateTime;
	
	public InfoEntity() {
		super();
		int id = -1;
	}
	
	public InfoEntity(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "InfoEntity [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + 
				", password=" + password + ", phone=" + phone + ", email=" + email + ", description=" + description + 
				", createdDate=" + createdDate + ", updateTime=" + updateTime + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, firstname, lastname, username, password, phone, email, createdDate, updateTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InfoEntity other = (InfoEntity) obj;
		return Objects.equals(description, other.description) && Objects.equals(firstname, other.firstname) 
				&& Objects.equals(lastname, other.lastname) && Objects.equals(createdDate, other.createdDate)
				&& Objects.equals(updateTime, other.updateTime)	&& Objects.equals(email, other.email) 
				&& Objects.equals(phone, other.phone);
	}
	
}