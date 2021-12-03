package beans;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Content {
	private int id;
	private String title;
	private String brief;
	private String content;
	private String sort;
	private int authorid;
	
	private String createDateTime;
	private String updateDateTime;
	
	public Content() {
		
	}
	public Content(int id, String title, String brief, String content, String createDateTime 
			,String updateDateTime, String sort, int authorid) {
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.updateDateTime = updateDateTime;
		this.createDateTime = createDateTime;
		this.sort = sort;
		this.authorid = authorid;
	}
	
	public Content(String title, String brief, String content, int authorid,
			String createDateTime, String updateDateTime) {
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.authorid = authorid;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
	}
	
	public Content(int id, String title, String brief, String content, String updateDateTime) {
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.updateDateTime = updateDateTime;
	}
	
	public Content(int id, String title, String brief, String content) {
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
	}
	
	
	
	
	
	public int getId() {
		return id;
	}

	public String getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(String updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public int getAuthorid() {
		return authorid;
	}

	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	
	
}
