package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.domain.Race;
import racingcar.model.dto.EnteredCarNames;
import racingcar.model.dto.RaceResult;
import racingcar.model.dto.RoundResult;
import racingcar.model.vo.Car;
import racingcar.model.vo.CarState;
import racingcar.model.vo.Entry;
import racingcar.model.vo.TotalRound;

public class RacingServiceImpl implements RacingService {

    /**
     * 참가 자동차 목록 세팅
     *
     * @param carNamesInput 입력받은 자동차 이름들
     * @return 자동차 목록
     */
    @Override
    public Entry setCarEntry(EnteredCarNames carNamesInput) {
        try {
            String[] carNames = carNamesInput.getEnteredCarNames().split(",");
            List<Car> cars = new ArrayList<>();
            for (String carName : carNames) {
                cars.add(new Car(carName));
            }
            return new Entry(cars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 총 시도 횟수 세팅
     *
     * @param totalRoundInput 입력받은 시도횟수
     * @return 총 시도 횟수
     */
    @Override
    public TotalRound setTotalRound(String totalRoundInput) {
        try {
            return new TotalRound(totalRoundInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * 자동차 경주 1회 실행
     *
     * @param entry       자동차 목록
     * @param roundResult 현재까지 경주 진행한 결과
     */
    @Override
    public void roundProceed(Entry entry, RoundResult roundResult) {
        for (int i = 0; i < roundResult.getRoundResult().size(); i++) {
            roundResult.getRoundResult().get(i).addRound();
            int result = Race.goForward(Race.createRandomNumber());
            roundResult.getRoundResult().get(i).updatePosition(result);
        }
    }

    /**
     * 최종 우승자 목록 확보
     *
     * @param roundResult 현재까지 경주 진행한 결과
     * @return 우승자 목록
     */
    @Override
    public RaceResult getRaceResult(RoundResult roundResult) {
        int maxPosition = 0;
        RaceResult raceResult = new RaceResult();
        for (CarState carState : roundResult.getRoundResult()) {
            maxPosition = addWinner(maxPosition, carState, raceResult);
        }
        return raceResult;
    }

    /**
     * 우승자 추가
     *
     * @param maxPosition 현재까지 가장 멀리간 위치
     * @param carState    자동차 상태
     * @param raceResult  현재까지 경주 진행한 결과
     * @return 가장 멀리간 위치(최신)
     */
    @Override
    public int addWinner(int maxPosition, CarState carState, RaceResult raceResult) {
        if (carState.getPosition() > maxPosition) {
            raceResult.getWinners().clear();
            raceResult.getWinners().add(carState.getCarName());
            return carState.getPosition();
        }
        if (carState.getPosition() == maxPosition) {
            raceResult.getWinners().add(carState.getCarName());
        }
        return maxPosition;
    }
}
