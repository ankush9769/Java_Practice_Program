package org.example.Modernswitchcase;

public class DeptSwitch {
    public static void main(String[] args){
        int deptid =2;
        String dept = switch (deptid){
            case 1 -> "hr";
            case 2 -> "it";
            case 3 -> "accontant";
            default -> "invalid";
        };
        System.out.println(dept);



        String day = "sunday";
        boolean isweekend = switch (day){
            case "sunday","saturday" -> true;
            default -> false;
        };
        System.out.println(day);
        System.out.println(isweekend);

        //replace return with yield

        String status ="success";
        String res = switch (status){
            case "success" ->{
                System.out.println("transaction successfully");
                yield "payment done";
            }
            case "failed" ->{
                System.out.println("not done");
                yield "payment failed";
            }
            default -> "invalid";
        };
        System.out.println(res);



        int statuscode = 200;
        String reqmessage = switch (statuscode){
            case 200 -> "success";
            case 400 -> "bad request";
            case 401 -> "unautherized";
            case 404 -> "page not found";
            default -> "invalid status code";
        };
        System.out.println(reqmessage);

    }
}
