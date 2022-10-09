package racingcar.service;

import racingcar.model.dto.EnteredCarNames;
import racingcar.model.dto.RaceResult;
import racingcar.model.dto.RoundResult;
import racingcar.model.vo.CarState;
import racingcar.model.vo.Entry;
import racingcar.model.vo.TotalRound;

public interface RacingService {

    /**
     * 참가 자동차 목록 세팅
     *
     * @param carNamesInput 입력받은 자동차 이름들
     * @return 자동차 목록
     */
    Entry setCarEntry(EnteredCarNames carNamesInput);

    /**
     * 자동차 이름 문자열 배열로 분리
     *
     * @param input 입력받은 자동자 이름들(문자열)
     * @return 배열로 분리된 자동차 이름들
     */
    String[] splitCarNames(String input);

    /**
     * 자동차 이름 배열을 사용하여 자동차 목록 객체 생성
     *
     * @param carNames 자동차 이름 배열
     * @return 자동차 목록 객체(Entry)
     */
    Entry makeEntry(String[] carNames);

    /**
     * 총 시도 횟수 세팅
     *
     * @param totalRoundInput 입력받은 시도횟수
     * @return 총 시도 횟수
     */
    TotalRound setTotalRound(String totalRoundInput);

    /**
     * 자동차 경주 1회 실행
     *
     * @param entry       자동차 목록
     * @param roundResult 현재까지 경주 진행한 결과
     */
    void roundProceed(Entry entry, RoundResult roundResult);

    /**
     * 최종 우승자 목록 확보
     *
     * @param roundResult 현재까지 경주 진행한 결과
     * @return 우승자 목록
     */
    RaceResult getRaceResult(RoundResult roundResult);

    /**
     * 우승자 추가
     *
     * @param maxPosition 현재까지 가장 멀리간 위치
     * @param carState    자동차 상태
     * @param raceResult  현재까지 경주 진행한 결과
     * @return 가장 멀리간 위치(최신)
     */
    int addWinner(int maxPosition, CarState carState, RaceResult raceResult);
}
