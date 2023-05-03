package data;

public class Display_Message {
    private int id;
    private String message;

        public Display_Message( int id, String message) {
        this.message=message;
        this.id=id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
