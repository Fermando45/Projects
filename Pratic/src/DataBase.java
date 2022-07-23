public class DataBase {
    private String name;
    private String pass;

 DataBase(String name, String pass)  {

     this.name=name;
     this.pass=pass;


 }
 public void setName(String name){


     this.name=name;
 }

 public String getName(){
     return name;
 }
    public void setpass(String pass){


        this.pass=pass;
    }

    public String getpass(){
        return pass;
    }



}
