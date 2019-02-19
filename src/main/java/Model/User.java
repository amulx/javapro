package Model;

public class User {
    public static char SEX_MALE = '男'; //可被外界修改
    static public char SEX_FEMALE = '女';
    public final static char SEX_UNKOWN = '0';//不可被外界修改

    public User(){

    }

    public User(String username,char usersex){
        this.setUsername(username);
        this.setUsersex(usersex);
    }
    public User(String username,byte userage){
        this.username = username;
        this.setUserage(userage);
    }


    public void check(){
        String[] for_names = {"admin","","amu"};
//        for (int i=0;i<for_names.length;i++){
//
//        }

        for (String name:for_names) {
            if (username.trim() == name){
                this.username = "非法输入";
                break;
            }
        }
//        if (this.username.trim() == "admin" || this.username.trim() == ""){
//            this.username = "guest";
//        }
//        if (userage<10 || userage> 80){
//            userage = 15;
//        }
    }

    public String username = "guest";
    public byte userage = 0;
    public char usersex = '男';
    public int userscore = 0;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = "tx_" + username;
    }

    public byte getUserage() {
        return userage;
    }

    public void setUserage(byte userage) {
        this.userage = userage;
    }

    public char getUsersex() {
        return usersex;
    }

    public void setUsersex(char usersex) {
        this.usersex = usersex;
    }

    public int getUserscore() {
        return userscore;
    }

    public void setUserscore(int userscore) {
        this.userscore = userscore;
    }
}
