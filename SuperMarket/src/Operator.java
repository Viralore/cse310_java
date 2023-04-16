import java.util.*;

class Admin
{
    String name,user_name, password,mob_no;
}

class ItemData
{
    String[][] list1 = new String[3][15];
}

public class Operator
{
    String name,address, user_name,password,mob_no;

    Operator(String name,String address, String user_name, String password, String mob_no)
    {
        this.name = name;
        this.address = address;
        this. user_name = user_name;
        this.password = password;
        this.mob_no = mob_no;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Operator user1 = new Operator("Abhishek","Punjab","itz_abhi", "abhi#123", "9461012345");
        Operator user2 = new Operator("Gopal","Hyderabad","gopal_mittal_01", "gopal@245", "9765212345");
        Operator user3 = new Operator("Yogendra","Rajasthan","yogendra_58558", "yogendra#58558", "9636912345");

        ItemData List_1 = new ItemData();
        List_1.list1[0][0] = "12";
        List_1.list1[0][1] = "15";
        List_1.list1[0][2] = "19";
        List_1.list1[0][3] = "20";
        List_1.list1[0][4] = "1";
        List_1.list1[0][5] = "18";
        List_1.list1[0][6] = "30";
        List_1.list1[0][7] = "25";
        List_1.list1[0][8] = "29";
        List_1.list1[0][9] = "10";
        List_1.list1[0][10] = "22";
        List_1.list1[0][11] = "13";
        List_1.list1[0][12] = "5";
        List_1.list1[0][13] = "8";
        List_1.list1[0][14] = "3";

        List_1.list1[1][0] = "Jaggery (1 Kg)";
        List_1.list1[1][1] = "Organic Honey (250 mL)";
        List_1.list1[1][2] = "Almonds (1 Kg)";
        List_1.list1[1][3] = "Cashew (1 Kg)";
        List_1.list1[1][4] = "Raisins (1 Kg)";
        List_1.list1[1][5] = "Walnuts (1 Kg)";
        List_1.list1[1][6] = "Tomato Ketchup (1 Kg)";
        List_1.list1[1][7] = "Noodles (1 Kg)";
        List_1.list1[1][8] = "Pasta (1 Kg)";
        List_1.list1[1][9] = "Marconi (1 Kg)";
        List_1.list1[1][10] = "Health Drinks(Child) (1 Kg)";
        List_1.list1[1][11] = "Papad (250 gms)";
        List_1.list1[1][12] = "Fruit Jam (1 Kg)";
        List_1.list1[1][13] = "Peanut Butter (500 gms)";
        List_1.list1[1][14] = "Coffee (500 gms)";

        List_1.list1[2][0] = "200";
        List_1.list1[2][1] = "500";
        List_1.list1[2][2] = "1500";
        List_1.list1[2][3] = "1200";
        List_1.list1[2][4] = "750";
        List_1.list1[2][5] = "2500";
        List_1.list1[2][6] = "150";
        List_1.list1[2][7] = "180";
        List_1.list1[2][8] = "200";
        List_1.list1[2][9] = "250";
        List_1.list1[2][10] = "550";
        List_1.list1[2][11] = "100";
        List_1.list1[2][12] = "300";
        List_1.list1[2][13] = "350";
        List_1.list1[2][14] = "1450";

        String user,pass;

        int attempt = 3;
        while(attempt!=0)
        {
            user = in.nextLine();
            pass = in.nextLine();
        }
    }
}
