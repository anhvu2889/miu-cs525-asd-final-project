import domain.banking.BankService;
import domain.banking.entity.BankUiCommandData;
import domain.banking.entity.accounts.AccountType;
import domain.banking.entity.customers.Company;
import domain.banking.usecase.AddInterestUsecase;
import domain.banking.usecase.CreateAccountUsecase;
import domain.banking.usecase.DepositAccountUsecase;
import domain.banking.usecase.WithdrawAccountUsecase;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CreateAccountUsecase createAccountUsecase = new CreateAccountUsecase(BankService.getInstance());

        //Create account 1
        try {
            createAccountUsecase.execute(new BankUiCommandData("113", new Company("Duy", "vduy@gmail.com", null, 9), AccountType.CHECKING, 0.0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Create account 2
//        try{
//            createAccountUsecase.execute(new BankUiCommandData("112", new Company("Thinh", "", null, 9), AccountType.SAVING, 0.0));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //Deposit
        DepositAccountUsecase depositAccountUsecase = new DepositAccountUsecase(BankService.getInstance());
        //Withdraw
        WithdrawAccountUsecase withdrawAccountUsecase = new WithdrawAccountUsecase(BankService.getInstance());
        try {
            depositAccountUsecase.execute(new BankUiCommandData("113", new Company("Duy", "vduy@gmail.com", null, 9), AccountType.CHECKING, 500.0));
//            withdrawAccountUsecase.execute(new BankUiCommandData("113", new Company("Duy", "vduy@gmail.com", null, 9), AccountType.CHECKING, 100.0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}