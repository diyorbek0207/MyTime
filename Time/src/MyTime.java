import java.util.Scanner;
public class MyTime {
    private int hour;
    private int minute;
    private int seconde;

    public void setTime(int hour, int minute, int seconde) {
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59 || seconde < 0 || seconde > 59) {
            System.out.println("Invalid time values");
        } else {
            this.hour = hour;
            this.minute = minute;
            this.seconde = seconde;
        }
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getMinute() {
        return minute;
    }

    public void setSeconde(int seconde) {
        this.seconde = seconde;
    }

    public int getSeconde() {
        return seconde;
    }

    @Override
    public String toString() {
        if (getHour()==0 && getMinute()!=0 && getSeconde() != 0){
            return "0"+getHour()+":"+getMinute()+":"+getSeconde();
        } else if (getMinute()==0 && getHour() != 0 && getSeconde() !=0) {
            return getHour()+":0"+getMinute()+":"+getSeconde();
        } else if (getSeconde()==0 && getHour() != 0 && getMinute() !=0) {
            return getHour()+":"+getMinute()+":0"+getSeconde();
        } else if (getHour()==0 && getMinute()==0 && getSeconde()==0) {
            return getHour()+"0:0"+getMinute()+":0"+getSeconde();
        }else {
            return getHour()+":"+getMinute()+":"+getSeconde();
        }
    }

    public void nextSeconde(int seconde){
        this.seconde=getSeconde()+1;
        if (getSeconde()  == 60){
            this.seconde=0;
            this.minute=minute+1;
        }
        if (minute==60){
            this.minute=0;
            this.hour=hour+1;
        }
        if (hour==24){
            this.hour=0;
        }
        System.out.println(toString());
    }
    public void nextMinute(int minute){
        this.minute=getMinute()+1;
        if (getMinute()==60){
            this.minute=0;
            this.hour=hour+1;
        }
        if (hour==24){
            this.hour=0;
        }
        System.out.println(toString());
    }
    public void nextHour(int hour){
        this.hour=getHour()+1;

        if (getHour()==24){
            this.hour=0;
        }
        System.out.println(toString());
    }


    public static void main(String[] args) {
        MyTime myTime=new MyTime();
        Scanner scanner=new Scanner(System.in);
        int h=scanner.nextInt();
        int m=scanner.nextInt();
        int s=scanner.nextInt();
        myTime.setHour(h);
        myTime.setMinute(m);
        myTime.setSeconde(s);
        myTime.setTime(h,m,s);
        System.out.println(myTime.toString());
        myTime.nextSeconde(myTime.getSeconde());
        myTime.nextMinute(myTime.getMinute());
        myTime.nextHour(myTime.getHour());
    }
}
