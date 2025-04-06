package DIO;

public class Company {
    private int companyId;
    private int accountId;
    private String companyName;

    public Company() {}
    
    public Company(int accountId, String companyName) {
        this.accountId = accountId;
        this.companyName = companyName;
    }

    public Company(int companyId, int accountId, String companyName) {
        this.companyId = companyId;
        this.accountId = accountId;
        this.companyName = companyName;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", accountId=" + accountId +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
