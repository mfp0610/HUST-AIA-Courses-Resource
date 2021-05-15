class  MyDate {
        private int day;
        private int month;
        private int year;
           
		public String getDate(){
			return day+"/"+month+"/"+year;
		}
		
        public int setDate(int a,int b,int c){  
        	if ((a>0 && a<=31)&&(b>0&&b<=12)){
        		day=a;
        		month=b;
        		year=c;
        		return 0;
        	}else {
        		return -1;
        	}
        }
}

public class UseMyDate{
	public static void main(String[] args){
		MyDate d = new 	MyDate();
		if(d.setDate(22,5,2009)==0){
				System.out.println(d.getDate());
			}


/*		//illegal operations.
        d.day=22;
		d.month = 5 ;
		d.year = 2009;                      
		System.out.println(d.day+"/"+d.month+"/"+d.year);  */
	}
}
