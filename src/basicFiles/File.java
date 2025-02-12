package basicFiles;

public class File extends SystemElements{
	private String fileText;
	public File(String fileName, String fullParentName, String fileText) {
		super(fileName, fullParentName);
		this.setFileText(fileText);
	}
	public String getFileText() {
		return fileText;
	}
	public void setFileText(String fileText) {
		this.fileText = fileText;
	}
}
