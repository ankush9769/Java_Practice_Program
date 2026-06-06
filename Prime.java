class Prime{
    public static void main(String[] args) {
        Scanner sc = new Snanner();
        int n = sc.nextInt();
        int n = 5;
        boolean flag = true;
        if(n==1 || n==0){
            System.out.println(n+"no. is not prime");
        }else{
        for(int i=2;i<n;i++){
            if(n%i==0){
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.println(n+" no. is prime");
        }else{
            System.out.println(n+" no. is not prime");
        }
        }
    }
}