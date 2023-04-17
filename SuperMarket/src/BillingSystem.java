import java.util.*;
import java.time.*;
import java.util.Calendar;

class Admin
{
    String name,user_name, password,mob_no;

    Admin(String name, String user_name,String password,String mob_no)
    {
        this.name = name;
        this.user_name = user_name;
        this.password = password;
        this.mob_no = mob_no;
    }



    public void printDetails()
    {
        System.out.println("Name      : "+ this.name);
        System.out.println("Mobile no : "+ this.mob_no);
    }

}

class ItemData
{
    String[][] item_list_Other =new String[3][15];
    String[][] item_list_Grocery =new String[3][15];
    String[][] item_list_Veg =new String[3][15];
    String[][] item_list_Fruit =new String[3][15];
}

class Operator
{
    String name,address, user_name,password,mob_no;
    static int operator_count = 7;
    Operator(String name,String address, String user_name, String password, String mob_no)
    {
        this.name = name;
        this.address = address;
        this. user_name = user_name;
        this.password = password;
        this.mob_no = mob_no;
        operator_count--;
    }

}

public class BillingSystem
{
    public static boolean checkAdmin(Admin ad,String user_name,String password)
    {
        return ad.user_name.equals(user_name) && ad.password.equals(password);
    }

    public static void createOperator(Operator[] ar,String[] arr,int idx)
    {
        ar[idx] = new Operator(arr[0],arr[1],arr[2],arr[3],arr[4]);
    }

    public static boolean checkOperator(Operator[] ar, String user_name,String password)
    {
        int temp=0;
        for(int i=0;i<ar.length;i++)
        {
            if(ar[i]!=null) temp++;
            else break;
        }

        for (int i=0;i<temp;i++)
        {
            if (ar[i].user_name.equals(user_name) && ar[i].password.equals(password))
            {
                return true;
            }
        }
        return false;
    }

    public static String getOperatorName(Operator[] ar,String username,String password)
    {
        String str = "";
        int temp=0;
        for(int i=0;i<ar.length;i++)
        {
            if(ar[i]!=null) temp++;
            else break;
        }
        for (int i=0;i<temp;i++)
        {
            if (ar[i].user_name.equals(username) && ar[i].password.equals(password))
            {
                str = ar[i].name;
            }
        }

        return str;
    }

    public static void printItemListOther(ItemData li)
    {
        System.out.println("Item Code \t\t\t Item Name");
        for(int i=0;i<15;i++)
        {
            System.out.print("\t"+li.item_list_Other[0][i]);
            System.out.print("\t\t\t\t" + li.item_list_Other[1][i]);
            System.out.println();
        }
        System.out.println();
    }

    public static void printItemListGrocery(ItemData li)
    {
        System.out.println("Item Code \t\t\t Item Name");
        for(int i=0;i<15;i++)
        {
            System.out.print("\t"+li.item_list_Grocery[0][i]);
            System.out.print("\t\t\t\t" + li.item_list_Grocery[1][i]);
            System.out.println();
        }
        System.out.println();
    }

    public static void printItemListVeg(ItemData li)
    {
        System.out.println("Item Code \t\t\t Item Name");
        for(int i=0;i<15;i++)
        {
            System.out.print("\t"+li.item_list_Veg[0][i]);
            System.out.print("\t\t\t\t" + li.item_list_Veg[1][i]);
            System.out.println();
        }
        System.out.println();
    }

    public static void printItemListFruit(ItemData li)
    {
        System.out.println("Item Code \t\t\t Item Name");
        for(int i=0;i<15;i++)
        {
            System.out.print("\t"+li.item_list_Fruit[0][i]);
            System.out.print("\t\t\t\t" + li.item_list_Fruit[1][i]);
            System.out.println();
        }
        System.out.println();
    }

    public static int getOtherPrice(ItemData li,int x)
    {
        int price = 0;
        for(int i=0;i<15;i++)
        {
            if(Integer.parseInt(li.item_list_Other[0][i])==x)
                price = Integer.parseInt(li.item_list_Other[2][i]);
        }
        return price;
    }

    public static int billOthers(ItemData li,int number,int[] arr_item_code,int[] arr_item_quantity)
    {
        if(number==0) return 0;
        else
        {
            int sum = 0;
            for(int i=0;i<number;i++)
            {
                int temp = getOtherPrice(li,arr_item_code[i]);
                temp = temp * arr_item_quantity[i];
                sum = sum+temp;
            }
            return sum;
        }
    }

    public static int getGroceryPrice(ItemData li,int x)
    {
        int price = 0;
        for(int i=0;i<15;i++)
        {
            if(Integer.parseInt(li.item_list_Grocery[0][i])==x)
                price = Integer.parseInt(li.item_list_Grocery[2][i]);
        }
        return price;
    }

    public static int billGrocery(ItemData li,int number,int[] arr_item_code,int[] arr_item_quantity)
    {
        if(number==0) return 0;
        else
        {
            int sum = 0;
            for(int i=0;i<number;i++)
            {
                int temp = getGroceryPrice(li,arr_item_code[i]);
                temp = temp * arr_item_quantity[i];
                sum = sum+temp;
            }
            return sum;
        }
    }

    public static int getVegPrice(ItemData li,int x)
    {
        int price = 0;
        for(int i=0;i<15;i++)
        {
            if(Integer.parseInt(li.item_list_Veg[0][i])==x)
                price = Integer.parseInt(li.item_list_Veg[2][i]);
        }
        return price;
    }

    public static int billVeg(ItemData li,int number,int[] arr_item_code,int[] arr_item_quantity)
    {
        if(number==0) return 0;
        else
        {
            int sum = 0;
            for(int i=0;i<number;i++)
            {
                int temp = getVegPrice(li,arr_item_code[i]);
                temp = temp * arr_item_quantity[i];
                sum = sum+temp;
            }
            return sum;
        }
    }

    public static int getFruitsPrice(ItemData li,int x)
    {
        int price = 0;
        for(int i=0;i<15;i++)
        {
            if(Integer.parseInt(li.item_list_Fruit[0][i])==x)
                price = Integer.parseInt(li.item_list_Fruit[2][i]);
        }
        return price;
    }

    public static int billFruits(ItemData li,int number,int[] arr_item_code,int[] arr_item_quantity)
    {
        if(number==0) return 0;
        else
        {
            int sum = 0;
            for(int i=0;i<number;i++)
            {
                int temp = getFruitsPrice(li,arr_item_code[i]);
                temp = temp * arr_item_quantity[i];
                sum = sum+temp;
            }
            return sum;
        }
    }

    public static String getItemNameOthers(ItemData li,int x)
    {
        String str = "";
        for(int i=0;i<15;i++)
        {
            if(Integer.parseInt(li.item_list_Other[0][i])==x)
                str = li.item_list_Other[1][i];
        }
        return str;
    }

    public static String getItemNameGrocery(ItemData li,int x)
    {
        String str = "";
        for(int i=0;i<15;i++)
        {
            if(Integer.parseInt(li.item_list_Grocery[0][i])==x)
                str = li.item_list_Grocery[1][i];
        }
        return str;
    }

    public static String getItemNameVeg(ItemData li,int x)
    {
        String str = "";
        for(int i=0;i<15;i++)
        {
            if(Integer.parseInt(li.item_list_Veg[0][i])==x)
                str = li.item_list_Veg[1][i];
        }
        return str;
    }

    public static String getItemNameFruits(ItemData li,int x)
    {
        String str = "";
        for(int i=0;i<15;i++)
        {
            if(Integer.parseInt(li.item_list_Fruit[0][i])==x)
                str = li.item_list_Fruit[1][i];
        }
        return str;
    }

    public static void printBill_Items(ItemData li,int[] other_code,int[] other_quantity,int[] grocery_code,int[] grocery_quantity,int[] veg_code,int[] veg_quantity,int[] fruits_code,int[] fruits_quantity)
    {
        System.out.println("========================================================================");
        System.out.println("\t Item Name \t\t\t\t Price \t\t\t Total");
        System.out.println("========================================================================");
        for(int i=0;i<other_code.length;i++)
        {
            System.out.print(getItemNameOthers(li,other_code[i])+"\t\t\t\t "+other_quantity[i]+"*"+getOtherPrice(li,other_code[i])+"\t\t\t"+getOtherPrice(li,other_code[i])*other_quantity[i]);
            System.out.println();
        }

        for(int i=0;i<grocery_code.length;i++)
        {
            System.out.print(getItemNameGrocery(li,grocery_code[i])+"\t\t\t\t "+grocery_quantity[i]+"*"+getGroceryPrice(li,grocery_code[i])+"\t\t\t"+getGroceryPrice(li,grocery_code[i])*grocery_quantity[i]);
            System.out.println();
        }

        for(int i=0;i<veg_code.length;i++)
        {
            System.out.print(getItemNameVeg(li,veg_code[i])+"\t\t\t\t "+veg_quantity[i]+"*"+getVegPrice(li,veg_code[i])+"\t\t\t"+getVegPrice(li,veg_code[i])*veg_quantity[i]);
            System.out.println();
        }

        for(int i=0;i<fruits_code.length;i++)
        {
            System.out.print(getItemNameFruits(li,fruits_code[i])+"\t\t\t\t "+fruits_quantity[i]+"*"+getFruitsPrice(li,fruits_code[i])+"\t\t\t"+getFruitsPrice(li,fruits_code[i])*fruits_quantity[i]);
            System.out.println();
        }
        System.out.println("========================================================================");
    }

    public static void printBill_Total(int tot)
    {
        int gst = tot*18/100;
        Calendar cal = Calendar.getInstance();
        String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        String current_day = days[cal.get(Calendar.DAY_OF_WEEK)-1];
        int discount = 0;
        int discount_rate;
        switch(current_day)
        {
            case "Sunday":
                discount_rate = 10;
                discount = 10*(tot+gst)/100;
                break;
            case "Monday":
                discount_rate = 15;
                discount = 15*(tot+gst)/100;
                break;
            case "Tuesday":
                discount_rate = 17;
                discount = 17*(tot+gst)/100;
                break;
            case "Wednesday":
                discount_rate = 25;
                discount = 25*(tot+gst)/100;
                break;
            case "Thursday":
                discount_rate = 20;
                discount = 20*(tot+gst)/100;
                break;
            case "Friday":
                discount_rate = 50;
                discount = 50*(tot+gst)/100;
                break;
            default:
                discount_rate = 19;
                discount = 19*(tot+gst)/100;
                break;
        }

        System.out.println("========================================================================");
        System.out.println("Amount               : "+tot+"/-");
        System.out.println("GST 18%              : "+ gst+"/-");
        System.out.println("Grand Total          : "+(gst+tot)+"/-");
        System.out.println("Discount("+discount_rate+"%)        : "+discount+"/-");
        System.out.println("Total Payable Amount : "+ (tot+gst-discount)+"/-");
        System.out.println("========================================================================");
        System.out.println("\t\t\t\tThank You for Being Our Valued Customer.");
        System.out.println("========================================================================");
        System.out.println("\t\t\t\t\t\tPlease visit us again.");
        System.out.println("========================================================================");
        System.out.println("\t\t\t\tPlease Note: Discount differ with each day.");
    }

    public static void printBill_Details(Operator[] array,String name,String mob_no,String username,String password)
    {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        int hours = time.getHour();
        int minutes = time.getMinute();
        int seconds = time.getSecond();
        Calendar cal = Calendar.getInstance();
        String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        int invoice_min = 1000000;
        int invoice_max = 9999999;
        int invoice = (int)(Math.random()*(invoice_max-invoice_min-1)+invoice_min);

        int bill_min = 100000;
        int bill_max = 999999;
        int bill_no = (int)(Math.random()*(bill_max-bill_min-1)+bill_min);

        System.out.println("========================================================================");
        System.out.println("\t\t\t\t\tWelcome to Lovely Super Mall");
        System.out.println("========================================================================");
        System.out.print("INVOICE NO.             : "+invoice);
        System.out.println("\t\t\tBILL NO. : "+bill_no);
        System.out.println("========================================================================");

        System.out.print("Name of Customer        : "+name);
        System.out.println("\t\t\t\tDate : "+date);
        System.out.print("Mobile no of Customer   : "+mob_no);
        System.out.println("\t\t\tTime : "+hours+":"+minutes+":"+seconds);
        System.out.print("Name of the Operator    : "+getOperatorName(array,username,password));
        System.out.print("\t\t\t\tDay  : "+days[cal.get(Calendar.DAY_OF_WEEK)-1]);
        System.out.println();
        System.out.println("========================================================================");
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ItemData list = new ItemData();
        //Other Items
        list.item_list_Other[0][0] = "12";
        list.item_list_Other[0][1] = "15";
        list.item_list_Other[0][2] = "19";
        list.item_list_Other[0][3] = "20";
        list.item_list_Other[0][4] = "1";
        list.item_list_Other[0][5] = "18";
        list.item_list_Other[0][6] = "30";
        list.item_list_Other[0][7] = "25";
        list.item_list_Other[0][8] = "29";
        list.item_list_Other[0][9] = "10";
        list.item_list_Other[0][10] = "22";
        list.item_list_Other[0][11] = "13";
        list.item_list_Other[0][12] = "5";
        list.item_list_Other[0][13] = "8";
        list.item_list_Other[0][14] = "3";

        list.item_list_Other[1][0] = "Jaggery (1 Kg)";
        list.item_list_Other[1][1] = "Honey (250 mL)";
        list.item_list_Other[1][2] = "Almonds (1 Kg)";
        list.item_list_Other[1][3] = "Cashew (1 Kg)";
        list.item_list_Other[1][4] = "Raisins (1 Kg)";
        list.item_list_Other[1][5] = "Walnuts (1 Kg)";
        list.item_list_Other[1][6] = "Ketchup (1 Kg)";
        list.item_list_Other[1][7] = "Noodles (1 Kg)";
        list.item_list_Other[1][8] = "Pasta (1 Kg)";
        list.item_list_Other[1][9] = "Marconi (1 Kg)";
        list.item_list_Other[1][10] = "Health Drinks (1 Kg)";
        list.item_list_Other[1][11] = "Papad (250 gms)";
        list.item_list_Other[1][12] = "Fruit Jam (1 Kg)";
        list.item_list_Other[1][13] = "Peanut Butter (500 gms)";
        list.item_list_Other[1][14] = "Coffee (500 gms)";

        list.item_list_Other[2][0] = "200";
        list.item_list_Other[2][1] = "500";
        list.item_list_Other[2][2] = "1500";
        list.item_list_Other[2][3] = "1200";
        list.item_list_Other[2][4] = "750";
        list.item_list_Other[2][5] = "2500";
        list.item_list_Other[2][6] = "150";
        list.item_list_Other[2][7] = "180";
        list.item_list_Other[2][8] = "200";
        list.item_list_Other[2][9] = "250";
        list.item_list_Other[2][10] = "550";
        list.item_list_Other[2][11] = "100";
        list.item_list_Other[2][12] = "300";
        list.item_list_Other[2][13] = "350";
        list.item_list_Other[2][14] = "1450";

        //Grocery items
        list.item_list_Grocery[0][0] = "32";
        list.item_list_Grocery[0][1] = "33";
        list.item_list_Grocery[0][2] = "34";
        list.item_list_Grocery[0][3] = "36";
        list.item_list_Grocery[0][4] = "38";
        list.item_list_Grocery[0][5] = "41";
        list.item_list_Grocery[0][6] = "44";
        list.item_list_Grocery[0][7] = "47";
        list.item_list_Grocery[0][8] = "49";
        list.item_list_Grocery[0][9] = "51";
        list.item_list_Grocery[0][10] = "52";
        list.item_list_Grocery[0][11] = "55";
        list.item_list_Grocery[0][12] = "56";
        list.item_list_Grocery[0][13] = "58";
        list.item_list_Grocery[0][14] = "60";

        list.item_list_Grocery[1][0] = "Basmati Rice (1 kg)";
        list.item_list_Grocery[1][1] = "Whole Wheat Flour (5 kg)";
        list.item_list_Grocery[1][2] = "Brown Sugar (500 g)";
        list.item_list_Grocery[1][3] = "Ground Cumin (100 g)";
        list.item_list_Grocery[1][4] = "Turmeric Powder (100g )";
        list.item_list_Grocery[1][5] = "Fennel Seeds (100 g)";
        list.item_list_Grocery[1][6] = "Maida Flour (1 kg)";
        list.item_list_Grocery[1][7] = "Refined Oil (1 L)";
        list.item_list_Grocery[1][8] = "Red Chilli Powder (100 g)";
        list.item_list_Grocery[1][9] = "Mustard Seeds (100 g)";
        list.item_list_Grocery[1][10] = "Salt (1 kg)";
        list.item_list_Grocery[1][11] = "Groundnut Oil (1 L)";
        list.item_list_Grocery[1][12] = "Aata (1 kg)";
        list.item_list_Grocery[1][13] = "Besan (1 kg)";
        list.item_list_Grocery[1][14] = "Makkai aata (500 g)";

        list.item_list_Grocery[2][0] = "300";
        list.item_list_Grocery[2][1] = "1000";
        list.item_list_Grocery[2][2] = "150";
        list.item_list_Grocery[2][3] = "50";
        list.item_list_Grocery[2][4] = "120";
        list.item_list_Grocery[2][5] = "60";
        list.item_list_Grocery[2][6] = "135";
        list.item_list_Grocery[2][7] = "700";
        list.item_list_Grocery[2][8] = "450";
        list.item_list_Grocery[2][9] = "150";
        list.item_list_Grocery[2][10] = "20";
        list.item_list_Grocery[2][11] = "200";
        list.item_list_Grocery[2][12] = "300";
        list.item_list_Grocery[2][13] = "55";
        list.item_list_Grocery[2][14] = "140";

        //Vegetables list
        list.item_list_Veg[0][0] = "61";
        list.item_list_Veg[0][1] = "63";
        list.item_list_Veg[0][2] = "64";
        list.item_list_Veg[0][3] = "65";
        list.item_list_Veg[0][4] = "67";
        list.item_list_Veg[0][5] = "71";
        list.item_list_Veg[0][6] = "75";
        list.item_list_Veg[0][7] = "76";
        list.item_list_Veg[0][8] = "77";
        list.item_list_Veg[0][9] = "79";
        list.item_list_Veg[0][10] = "81";
        list.item_list_Veg[0][11] = "82";
        list.item_list_Veg[0][12] = "85";
        list.item_list_Veg[0][13] = "87";
        list.item_list_Veg[0][14] = "90";

        list.item_list_Veg[1][0] = "Green Chillies (250 g)";
        list.item_list_Veg[1][1] = "Cauliflower (1 piece)";
        list.item_list_Veg[1][2] = "Red Onions (1 kg)";
        list.item_list_Veg[1][3] = "Green Peas (500 g)";
        list.item_list_Veg[1][4] = "Carrots (500 g)";
        list.item_list_Veg[1][5] = "Tomatoes (1 kg)";
        list.item_list_Veg[1][6] = "Coriander Leaves (100 g)";
        list.item_list_Veg[1][7] = "Iceberg Lettuce (1 piece)";
        list.item_list_Veg[1][8] = "Sweet Potatoes (1 kg)";
        list.item_list_Veg[1][9] = "Green Beans (500 g)";
        list.item_list_Veg[1][10] = "Lemons (500 g)";
        list.item_list_Veg[1][11] = "Cucumber (1 piece)";
        list.item_list_Veg[1][12] = "Corn (1 piece)";
        list.item_list_Veg[1][13] = "Drumsticks (1 kg)";
        list.item_list_Veg[1][14] = "Mushroom (500 g)";

        list.item_list_Veg[2][0] = "100";
        list.item_list_Veg[2][1] = "250";
        list.item_list_Veg[2][2] = "550";
        list.item_list_Veg[2][3] = "130";
        list.item_list_Veg[2][4] = "80";
        list.item_list_Veg[2][5] = "300";
        list.item_list_Veg[2][6] = "135";
        list.item_list_Veg[2][7] = "700";
        list.item_list_Veg[2][8] = "450";
        list.item_list_Veg[2][9] = "345";
        list.item_list_Veg[2][10] = "100";
        list.item_list_Veg[2][11] = "200";
        list.item_list_Veg[2][12] = "300";
        list.item_list_Veg[2][13] = "130";
        list.item_list_Veg[2][14] = "240";

        //Fruit list
        list.item_list_Fruit[0][0] = "91";
        list.item_list_Fruit[0][1] = "93";
        list.item_list_Fruit[0][2] = "94";
        list.item_list_Fruit[0][3] = "95";
        list.item_list_Fruit[0][4] = "97";
        list.item_list_Fruit[0][5] = "101";
        list.item_list_Fruit[0][6] = "105";
        list.item_list_Fruit[0][7] = "106";
        list.item_list_Fruit[0][8] = "107";
        list.item_list_Fruit[0][9] = "109";
        list.item_list_Fruit[0][10] = "111";
        list.item_list_Fruit[0][11] = "112";
        list.item_list_Fruit[0][12] = "115";
        list.item_list_Fruit[0][13] = "117";
        list.item_list_Fruit[0][14] = "120";

        list.item_list_Fruit[1][0] = "Apple (1 kg)";
        list.item_list_Fruit[1][1] = "Strawberries (500 g)";
        list.item_list_Fruit[1][2] = "Pineapple (1 piece)";
        list.item_list_Fruit[1][3] = "Grapes (1 kg)";
        list.item_list_Fruit[1][4] = "Mango (1 kg)";
        list.item_list_Fruit[1][5] = "Banana (1 Dozen)";
        list.item_list_Fruit[1][6] = "Orange (1 kg)";
        list.item_list_Fruit[1][7] = "Pomegranate (1 kg)";
        list.item_list_Fruit[1][8] = "Watermelon (1 piece)";
        list.item_list_Fruit[1][9] = "Kiwi (500 g)";
        list.item_list_Fruit[1][10] = "Cherry (500 g)";
        list.item_list_Fruit[1][11] = "Mangosteen (1 kg)";
        list.item_list_Fruit[1][12] = "Dragonfruit (1 piece)";
        list.item_list_Fruit[1][13] = "Avocados (1 kg)";
        list.item_list_Fruit[1][14] = "papaya (1 piece)";

        list.item_list_Fruit[2][0] = "100";
        list.item_list_Fruit[2][1] = "450";
        list.item_list_Fruit[2][2] = "150";
        list.item_list_Fruit[2][3] = "130";
        list.item_list_Fruit[2][4] = "350";
        list.item_list_Fruit[2][5] = "300";
        list.item_list_Fruit[2][6] = "250";
        list.item_list_Fruit[2][7] = "300";
        list.item_list_Fruit[2][8] = "450";
        list.item_list_Fruit[2][9] = "345";
        list.item_list_Fruit[2][10] = "1000";
        list.item_list_Fruit[2][11] = "500";
        list.item_list_Fruit[2][12] = "300";
        list.item_list_Fruit[2][13] = "230";
        list.item_list_Fruit[2][14] = "240";

        Admin admin = new Admin("Admin", "admin", "admin#123", "9876543210");
        Operator[] operators = new Operator[10];
        operators[0] = new Operator("Abhishek", "Punjab", "itz_abhi", "abhi#123", "9461012345");
        operators[1] = new Operator("Gopal", "Hyderabad", "gopal_mittal_01", "gopal@245", "9765212345");
        operators[2] = new Operator("Yogendra", "Rajasthan", "yogendra_58558", "yogendra#58558", "9636912345");

        int attempt_admin = 3, attempt_op = 3;
        /*// For Testing
        int[] a1 = {12,13};
        int[] a2 = {1,1};
        int a3 = 1;
        int a = billOthers(list,a3,a1,a2);

        int[] b1 = {32};
        int[] b2 = {1};
        int b3 = 1;
        int b = billGrocery(list,b3,b1,b2);

        int[] c1 = {61};
        int[] c2 = {1};
        int c3 = 1;
        int c = billVeg(list,c3,c1,c2);

        int[] d1 = {91};
        int[] d2 = {1};
        int d3 = 1;
        int d = billFruits(list,d3,d1,d2);
        int e = a+b+c+d;
        System.out.println(e);
        printBill_Details(operators,"Amrinder Ma'am","9876543210","itz_abhi","abhi#123");
        printBill_Items(list,a1,a2,b1,b2,c1,c2,d1,d2);
        printBill_Total(e);
        */

        EXIT_Main:
        while (true)
        {
            Exit:
            while (true) {
                System.out.println("Enter 1 for Admin");
                System.out.println("Enter 2 for Operator");
                System.out.println("Enter 3 to exit");
                int choice_1 = in.nextInt();
                in.nextLine();
                switch (choice_1) {
                    case 1:
                        Exit_Admin:
                        while (attempt_admin != 0) {
                            String usr, pass;
                            System.out.print("Please enter Username : ");
                            usr = in.nextLine();
                            System.out.print("Please enter Password : ");
                            pass = in.nextLine();
                            if (checkAdmin(admin, usr, pass)) {
                                System.out.println("Enter 1 for Admin Details");
                                System.out.println("Enter 2 for create new Operator");
                                System.out.println("Enter 3 to exit");
                                int choice_2 = in.nextInt();
                                in.nextLine();
                                switch (choice_2) {
                                    case 1:
                                        admin.printDetails();
                                        break Exit_Admin;
                                    case 2:
                                        int temp = 0;
                                        for (int i = 0; i < operators.length; i++) {
                                            if (operators[i] != null) temp++;
                                        }

                                        String[] arguments = new String[5];
                                        for (int i = 0; i < 5; i++) {
                                            if (i == 0) {
                                                System.out.print("Enter the name of Operator : ");
                                                arguments[i] = in.nextLine();
                                            } else if (i == 1) {
                                                System.out.print("Enter the address : ");
                                                arguments[i] = in.nextLine();
                                            } else if (i == 2) {
                                                System.out.print("Enter the Username : ");
                                                arguments[i] = in.nextLine();
                                            } else if (i == 3) {
                                                System.out.print("Enter the Password : ");
                                                arguments[i] = in.nextLine();
                                            } else {
                                                System.out.print("Enter the Mobile no. : ");
                                                arguments[i] = in.nextLine();
                                            }
                                        }
                                        createOperator(operators, arguments, temp);
                                        System.out.println("Operator created");
                                        break Exit_Admin;
                                    default:
                                        System.out.println("Exiting Admin panel");
                                        break Exit_Admin;
                                }
                            } else {
                                attempt_admin--;
                                System.out.println("Invalid Username or Password");
                                System.out.println("Please re-enter Username and Password");
                                System.out.println("Attempts remaining : " + attempt_admin);
                            }
                        }
                        break Exit;
                    case 2:
                        Exit_Operator:
                        while (attempt_op != 0) {
                            String usr1, pass1;
                            System.out.print("Please enter Username : ");
                            usr1 = in.nextLine();
                            System.out.print("Please enter Password : ");
                            pass1 = in.nextLine();
                            if (checkOperator(operators, usr1, pass1)) {
                                System.out.println("Enter 1 for create Bill");
                                System.out.println("Enter 2 to exit");
                                int choice_3 = in.nextInt();
                                in.nextLine();
                                if (choice_3 == 1) {
                                    System.out.print("Please enter the name of the customer : ");
                                    String name_cust = in.nextLine();
                                    System.out.print("Please enter the Mobile no. of the customer : ");
                                    String mob_no_cust = in.nextLine();
                                    int bill = 0;
                                    printItemListOther(list);
                                    System.out.print("Please enter items purchased in this list : ");
                                    int items_other = in.nextInt();
                                    int[] items_arr_others = new int[items_other];
                                    int[] items_arr_others_quantity = new int[items_other];
                                    if (items_other != 0) {
                                        System.out.println("Please enter item codes of purchased items");
                                        for (int i = 0; i < items_other; i++) {
                                            items_arr_others[i] = in.nextInt();
                                        }

                                        System.out.println("Please enter quantity of purchased items");
                                        for (int i = 0; i < items_other; i++) {
                                            items_arr_others_quantity[i] = in.nextInt();
                                        }
                                    }
                                    bill = bill + billOthers(list, items_other, items_arr_others, items_arr_others_quantity);

                                    printItemListGrocery(list);
                                    System.out.print("Please enter items purchased in this list : ");
                                    int items_grocery = in.nextInt();
                                    int[] items_arr_grocery = new int[items_grocery];
                                    int[] items_arr_grocery_quantity = new int[items_grocery];
                                    if (items_grocery != 0) {
                                        System.out.println("Please enter item codes of purchased items");
                                        for (int i = 0; i < items_grocery; i++) {
                                            items_arr_grocery[i] = in.nextInt();
                                        }
                                        System.out.println("Please enter quantity of purchased items");
                                        for (int i = 0; i < items_grocery; i++) {
                                            items_arr_grocery_quantity[i] = in.nextInt();
                                        }
                                    }
                                    bill = bill + billGrocery(list, items_grocery, items_arr_grocery, items_arr_grocery_quantity);

                                    printItemListVeg(list);
                                    System.out.print("Please enter items purchased in this list : ");
                                    int items_veg = in.nextInt();
                                    int[] items_arr_veg = new int[items_veg];
                                    int[] items_arr_veg_quantity = new int[items_veg];
                                    if (items_veg != 0) {
                                        System.out.println("Please enter item codes of purchased items");
                                        for (int i = 0; i < items_veg; i++) {
                                            items_arr_veg[i] = in.nextInt();
                                        }

                                        System.out.println("Please enter quantity of purchased items");

                                        for (int i = 0; i < items_veg; i++) {
                                            items_arr_veg_quantity[i] = in.nextInt();
                                        }
                                    }
                                    bill = bill + billVeg(list, items_veg, items_arr_veg, items_arr_veg_quantity);

                                    printItemListFruit(list);
                                    System.out.print("Please enter items purchased in this list : ");
                                    int items_fruits = in.nextInt();
                                    int[] items_arr_fruits = new int[items_fruits];
                                    int[] items_arr_fruits_quantity = new int[items_fruits];
                                    if (items_fruits != 0) {
                                        System.out.println("Please enter item codes of purchased items");
                                        for (int i = 0; i < items_fruits; i++) {
                                            items_arr_fruits[i] = in.nextInt();
                                        }

                                        System.out.println("Please enter quantity of purchased items");
                                        for (int i = 0; i < items_fruits; i++) {
                                            items_arr_fruits_quantity[i] = in.nextInt();
                                        }
                                    }
                                    bill = bill + billFruits(list, items_fruits, items_arr_fruits, items_arr_fruits_quantity);

                                    printBill_Details(operators, name_cust, mob_no_cust, usr1, pass1);
                                    printBill_Items(list, items_arr_others, items_arr_others_quantity, items_arr_grocery, items_arr_grocery_quantity, items_arr_veg, items_arr_veg_quantity, items_arr_fruits, items_arr_fruits_quantity);
                                    printBill_Total(bill);

                                    break Exit_Operator;

                                } else
                                {
                                    System.out.println("Exiting User Panel");
                                    break Exit;
                                }
                            } else {
                                attempt_op--;
                                System.out.println("Invalid Username or Password");
                                System.out.println("Please re-enter Username and Password");
                                System.out.println("Attempts remaining : " + attempt_op);
                            }
                        }
                        break Exit;
                    default:
                        System.out.println("Exiting Super Market Billing System");
                        break EXIT_Main;
                }
            }
        }
    }
}
