package feature;

import com.codurance.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

    @Mock
    private Console console;
    @Mock
    private Clock clock;

    private Account account;

    @Before
    public void setUp() throws Exception {
        TransactionRepository transactionRepository = new TransactionRepository(clock);
        StatementPrinter statementPrinter = new StatementPrinter(console);
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    public void print_statement_containing_all_transactions() {
        given(clock.todayAsString()).willReturn("01/04/2014", "02/04/2014", "10/04/2014");

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).printLine( "02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}
