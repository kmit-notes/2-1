class SavingsAccount{
    static final float interestRate;
    private static float transactionLimit;
    float transaction;
    fixedDeposit fds[];
    static {
        transactionLimit=50000;
        interestRate=0.0825f;
    }
    SavingsAccount(){
        fds=new float[10];
        transaction=0.0f;
    }
    public boolean withDraw(float amount){
        if (transaction>transaction_limit){
            System.out.println("Not allowed.");
            return false;
        }
        if(super.withDraw()){
            transaction+=amount;
        }
    }
    public boolean fixedDeposit(float amount,float duration){
        if (amount>getBalance()-1000){
            return false;
        }
        withdraw(amount);
        float maturityAmount=amount+(amount*interestRate*duration);
        this.fd[0]=maturityAmount;
    }
}
