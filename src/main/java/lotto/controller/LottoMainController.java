package lotto.controller;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import lotto.domain.constant.Rank;
import lotto.service.ProfitService;
import lotto.service.ResultService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoMainController {
    private static LottoTickets lottoTickets;
    private static WinningLotto winningLotto;
    private static Map<Rank, Integer> result;
    private LottoMainController(){
    }

    public static void start() {
        generateLottoTickets();
        getInputNumbers();
        resultOfLotto();
        calculateProfit();
    }

    private static void generateLottoTickets() {
        lottoTickets = InputView.inputBuyAmount();
        OutputView.printLottoTickets(lottoTickets.getAmount(), lottoTickets.getLottos());
    }

    private static void getInputNumbers(){
        Lotto winningNumbers = InputView.inputWinningNumber();
        LottoNumber winningBonus = InputView.inputWinningBonusNumber(winningNumbers);
        winningLotto = new WinningLotto(winningNumbers, winningBonus);
    }

    private static void resultOfLotto(){
        ResultService resultService = new ResultService(lottoTickets,winningLotto);
        result = resultService.calculateResults();
        OutputView.printResult(result);
    }

    private static void calculateProfit(){
        double profit = ProfitService.calculateProfitOfWinning(result,lottoTickets.getAmount());
        OutputView.printProfit(profit);
    }
}
