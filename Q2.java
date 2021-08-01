class Fibo{
    private int n=1,a=-1,b=1,c;
    synchronized void disp(){
        for(int i=0;i<=50;i++){
            if(n==31)
                try{
                    System.out.println("Fibonacci Generation Halted");
                    Thread.sleep(5000);
                }catch(InterruptedException e){
                    System.out.println("Caught interrupted exception");
                }
            c=a+b;
            System.out.println(n+" Fibo : "+c);
            a=b;
            b=c;
            n++;
        }
    }
}


class Prime{
    int n=1;
    boolean isPrime=true;
    synchronized void disp(){
        for(int i=2;;i++){
isPrime=true;
            for(int j=2;j<=i/2;j++){
                if((i%j)==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                System.out.println(n+" Prime : "+i);
                n++;
                if(n==25){
                    break;
                }
            }
        }
    }
}



class PrimeThread implements Runnable{
    Thread t;
    Prime p1;
    PrimeThread(){
        t=new Thread(this);
        t.setPriority(Thread.NORM_PRIORITY);
        t.start();
    }
    public void run(){
        p1=new Prime();
        p1.disp();
    }
}
class FiboThread implements Runnable{
    Thread t2;
    Fibo f;
    FiboThread(){
        t2=new Thread(this);
        t2.setPriority(8);
        t2.start();
    }
    public void run(){
        f=new Fibo();
        f.disp();
    }
}
class Q2
{
    public static void main(String args[]){
        FiboThread ft=new FiboThread();
        PrimeThread pt=new PrimeThread();
    }
}
