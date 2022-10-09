package racingcar.model.vo;

public class CarState {

    private final String carName;
    private int round;
    private int position;

    public CarState(Car car) {
        this.carName = car.getCarName();
    }

    public void addRound() {
        this.round++;
    }

    public void updatePosition(int add) {
        this.position += add;
    }

    public String getCarName() {
        return carName;
    }

    public int getRound() {
        return round;
    }

    public int getPosition() {
        return position;
    }
}
