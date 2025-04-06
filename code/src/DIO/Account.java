package DIO;
public class Account {
    private int accountId;
    private String name;
    private String password;

    public Account() {}

    public Account(String name, String password) {
        this.accountId = 0;
        this.name = name;
        this.password = password;
    }

    public Account(int accountId, String name, String password) {
        this.accountId = accountId;
        this.name = name;
        this.password = password;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
