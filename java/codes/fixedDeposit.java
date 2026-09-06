class fixedDeposit{
    double amount;
    double duration;
    static final double min_duration=2;
    double maturityAmount;
    static fixedDeposit createFixedDeposit(double amount,double duration){
        if (duration>min_duration)
            return new fixedDeposit(amount,duration);
        else
            return null;
    }
    private fixedDeposit(double amount,double duration){
        this.amount=amount;
        this.duration=duration;
        maturityAmount=amount+(amount*0.0825*duration);
    }
    public int compareTo(object d){
`        fixedDeposit s=(fixedDeposit)d;  //dereferencing
        return (int)(this.maturedAmount-s.maturedAmount);
    }
}

// if a constructed is protected only the sub class can access it (privte then even sub class cannot access it)