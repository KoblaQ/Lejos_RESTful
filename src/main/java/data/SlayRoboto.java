package data;


public class SlayRoboto {
    
    private int base_speed;
    private int cycle;
    private int safety_distance;
    private int obstacle_detected;
    private int intensity_level;
    private String message;

    //Constructors

    public SlayRoboto() {
        super();
    }

    public SlayRoboto( int base_speed) {
        super();
        this.base_speed=base_speed;
    }

    public SlayRoboto( int base_speed, int cycle) {
        super();
        this.base_speed=base_speed;
        this.cycle=cycle;
    }

    public SlayRoboto( int base_speed, int cycle, int safety_distance) {
        super();
        this.base_speed=base_speed;
        this.cycle=cycle;
        this.safety_distance=safety_distance;
    }

    public SlayRoboto( int base_speed, int cycle, int safety_distance, int obstacle_detected) {
        super();
        this.base_speed=base_speed;
        this.cycle=cycle;
        this.safety_distance=safety_distance;
        this.obstacle_detected=obstacle_detected;
    }

    public SlayRoboto( int base_speed, int cycle, int safety_distance, int obstacle_detected, int intensity_level) {
        super();
        this.base_speed=base_speed;
        this.cycle=cycle;
        this.safety_distance=safety_distance;
        this.obstacle_detected=obstacle_detected;
        this.intensity_level=intensity_level;
    }

        public SlayRoboto( int base_speed, int cycle, int safety_distance, int obstacle_detected, int intensity_level, String message) {
        super();
        this.base_speed=base_speed;
        this.cycle=cycle;
        this.safety_distance=safety_distance;
        this.obstacle_detected=obstacle_detected;
        this.intensity_level=intensity_level;
        this.message=message;
    }
    

    //Methods for base_speed
    public int getBase_speed() {
        return base_speed;
    }
    public void setBase_speed(int base_speed) {
        this.base_speed = base_speed;
    }

    //Methods for cycle
    public int getCycle() {
        return cycle;
    }
    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    //Methods for safety_distance
    public int getSafety_distance() {
        return safety_distance;
    }
    public void setSafety_distance(int safety_distance) {
        this.safety_distance = safety_distance;
    }

    //Methods for obstacle_detected
    public int getObstacle_detected() {
        return obstacle_detected;
    }
    public void setObstacle_detected(int obstacle_detected) {
        this.obstacle_detected = obstacle_detected;
    }

    //Methods for intensity_level
    public int getIntensity_level() {
        return intensity_level;
    }
    public void setIntensity_level(int intensity_level) {
        this.intensity_level = intensity_level;
    }

    
    //Methods for message
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}

