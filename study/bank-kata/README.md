# Bank kata

Create a simple bank application with the following features:

- Deposit into Account
- Withdraw from an Account
- Print a bank statement to the console

## Acceptance criteria

Statement should have transactions in the following format:

| DATE      | AMOUNT  | BALANCE |
|-----------|---------|---------|
|10/04/2014 | 500.00  | 1400.00 |
|02/04/2014 | -100.00 | 900.00  |
|01/04/2014 | 1000.00 | 1000.00 |

## Starting point and constraints

1. Start with a class the following structure:
    ```
    public class Account {
        public void deposit(int amount);
        public void withdraw(int amount);
        public void printStatement();
    }
    ```
1. You are not allowed to add any other public method to this class.
1. Use Strings and Integers for dates and amounts (keep it simple)
1. Don't worry about spacing in the statement printed on the console.

## References

- [Outside In TDD part I](https://www.youtube.com/watch?v=XHnuMjah6ps)
- [Outside In TDD part II](https://www.youtube.com/watch?v=gs0rqDdz3ko)
- [Outside In TDD part III](https://www.youtube.com/watch?v=R9OAt9AOrzI&t=3s)