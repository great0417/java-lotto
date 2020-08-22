package step2.controller;


import step2.domain.CheckWinning;
import step2.domain.Lotto;
import step2.domain.MakeLottoFactory;
import step2.domain.WinningStatistics;
import step2.util.InputUtil;
import step2.view.PrintResult;

import java.util.List;

public class Step2Main {
    public static void main(String[] args) {
        int price = InputUtil.returnInteger("구입금액을 입력해 주세요.");
        MakeLottoFactory makeLotto = new MakeLottoFactory(price);
        PrintResult.printBuyQuantity(makeLotto.buyQuantity());
        List<Lotto> lottoList = makeLotto.lottoRandomList();
        PrintResult.printLottoList(lottoList);
        String winningNumbers = InputUtil.returnString("지난 주 당첨 번호를 입력해 주세요.");
        Lotto winningLotto = makeLotto.makeLottoWithString(winningNumbers);

        CheckWinning checkWinning = new CheckWinning(winningLotto, lottoList);
        lottoList = checkWinning.setWinningNumberLottoList();

        WinningStatistics winningStatistics = new WinningStatistics(lottoList);
        PrintResult.printResult(winningStatistics.getWinningStatic(), winningStatistics.getBenefitOrNot());

    }
}
