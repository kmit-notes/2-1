class dMT{
    public static void main(String[] args){
        fixedDeposit fd=fixedDeposit.createFixedDeposit(20000,3);
        fixedDeposit fd1=fixedDeposit.createFixedDeposit(20000,1);
        fixedDeposit fd2=fixedDeposit.createFixedDeposit(20000,1);
        fixedDeposit fds[]=new fixedDeposit[3];
        fds[0]=fd;
        fds[1]=fd1;
        fds[2]=fd2;
        // System.out.println(fds+" "+fds1+" "+fds2);
        // System.out.println(fdss1==fdss2);
        for (int i=0;i<fds.length;i++){
            System.out.println(fds[i]);
            System.out.println(fds[i].amount);
        }
    }
}

// object 
// equals  --> to compare objects