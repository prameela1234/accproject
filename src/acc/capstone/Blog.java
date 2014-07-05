package acc.capstone;

public class Blog {

	private int id;
	private String title;
	private String text;
	private String date;
	private String link;
	private String img;

	public Blog(int id, String title, String text, String date, String link,
			String img) {
		super();
		this.title = title;
		this.text = text;
		this.date = date;
		this.link = link;
		this.img = img;
		this.id = id;
	}

	public Blog(String title2, String text2, String date2, String link2,
			String img) {

		super();
		this.title = title2;
		this.text = text2;
		this.date = date2;
		this.link = link2;
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public String getDate() {
		return date;
	}

	public String getLink() {
		return link;
	}

	public int getId() {
		return id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setId(int id) {
		this.id = id;
	}

}
