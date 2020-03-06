Group Members:
•	Ali Asad
•	Dawit Woldegiorgis

Overview 

Our finance framework project (FinCo) is using MVC pattern to keep separation between data layer, UI layer and business logic layer. To implement customer, we used Party pattern so that it can be easily extended for multiple type of customers in applications. Customer is of type person and company in our framework and they will be used as hotspots.

For Accounts and Transactions, we used Account pattern. Account can be extended and used as hotspot to extend with more account types in applications.

Factory method pattern is used to instantiate any type of customers and simple factory is used to instantiate account. These factories are extendable for applications and can be used as hotspots to implement further type of factories.

FinCo class is used as a facade between GUI and framework. Account parameter class is used to keep GUI data in one place and pass to FinCo for further usage. Account parameter can also be used as hotspot for applications to set properties.

Framework is using observer pattern to notify customer whenever any transaction is made so that customer can send email. This pattern is also used when interest is applied to existing accounts. Accounts notify the GUI using FinCo class so that it can display updated amount of each account. 

Bank and Credit card application use hotspots on framework for creating different type of customers, different type of accounts, deposit, withdraw, charge an account, add interest to all accounts, generate reports. 

In Credit card application, add interest, charge account and generate report is overridden to provide different implementation. Framework and both applications are functional.

There are some GUI validation issues. One apparent issue is the expiration date in the credit card system. The date must be in a MM/dd/yyyy format or an exception is thrown.


