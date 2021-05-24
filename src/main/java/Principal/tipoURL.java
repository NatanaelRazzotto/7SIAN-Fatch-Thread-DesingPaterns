package Principal;

public enum tipoURL {
	TODOS("todos/"),
	USERS("users/"),
	ALBUMS("albums/"),
	PHOTOS("photos/"),
	POST("posts/"),
	COMMENTS("comments/");	
	
	public final String URL;
	
	private tipoURL(String URL)
	{
		this.URL = URL;		
	}
	public String getURL() {
		return this.URL;
		
	}
}
