package racingcar.model.vo;

public class CarState {

    private String carName;
    private int round;
    private int position;

    public CarState(String carName) {
        this.carName = carName;
    }

    public void addRound() {
        this.round++;
    }

    public void updatePosition(int add) {
        this.position += add;
    }

    public CarState(Car car) {
        this.carName = car.getCarName();
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
