package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.*;


public class BibApp {

    public static void main(String[] args) {
//        书籍数据准备
        Book b1 = new Book("基督山伯爵", "大仲马", 1993);
        Book b2 = new Book("遥远的救世主", "司马迁", 2000);
        Book b3 = new Book("能力陷阱", "大盒子", 2001);

//        用户数据准备
        User u1 = new User("qqwa1","qq11","张一","1111@qq.com",11111);
        User u2 = new User("qqwa2","qq22","张二","2222@qq.com",22222);
        User u3 = new User("qqwa3","qq33","张三","3333@qq.com",33333);

//        电影数据准备
        Movie m1 = new Movie("泰坦尼克号","赵本山",1991);
        Movie m2 = new Movie("阿凡达","詹姆斯卡梅隆",2014);
        Movie m3 = new Movie("三十而已","江疏影",2020);
//        容器准备
//        用户列表容器
        List<User> userlist = new ArrayList<>();
//        订单列表容器
        List<Book> booklist = new ArrayList<>();
//        预订书籍列表容器
//        List<Book> pickup_booklist = new ArrayList<>();
////        已购买书籍列表容器
//        List<Book> bought_booklist = new ArrayList<>();
        List<Movie> movielist = new ArrayList<>();
//        数据添加
        booklist.add(b1);
        booklist.add(b2);
        booklist.add(b3);
        userlist.add(u1);
        userlist.add(u2);
        userlist.add(u3);
        movielist.add(m1);
        movielist.add(m2);
        movielist.add(m3);
        login_system(userlist,booklist,movielist);
//        程序启动
    }

    public static void run(List<Book> booklist, User user, List<Movie> movielist) {
//        运行App逻辑方法入口
        show_info();
        while (true) {
            System.out.println("Please enter the number to operate, if you need to check the number function again, press 9");
            Scanner sc = new Scanner(System.in);
            int option_num = sc.nextInt();
            if (option_num == 1) {
                option_one(booklist);
            } else if (option_num == 2) {
                option_two(booklist, user.pickup_booklist);
            } else if (option_num == 3) {
                option_three(user.pickup_booklist);
            } else if (option_num == 4) {
                option_four(user.pickup_booklist, user.bought_booklist);
            } else if (option_num == 5) {
                option_five(booklist, user.bought_booklist);
            } else if(option_num ==100){
                option_hundred(user);
            }
            else if (option_num == 0) {
                break;
            } else if (option_num == 9) {
                show_info();
            } else {
                System.out.println("Please select a valid option!");
            }
        }
    }

    public static void show_info() {
        System.out.println("===============================");
        System.out.println("Welcome to Biblioteca Online Library");
        System.out.println("This is a list of options");
        System.out.println("If you choose 1, get the book list information");
        System.out.println("If you choose 2, then book books");
        System.out.println("If you choose 3, the list of booked books will be displayed");
        System.out.println("If you choose 4, enter the checkout interface");
        System.out.println("If you choose 5, the book return interface");
        System.out.println("If you enter 100, display your personal information");
        System.out.println("If you choose 0, exit");
    }

    public static void option_one(List<Book> booklist) {
//        对应数字1功能  展示所有书籍的信息

        System.out.println("The list of all books is:");
        for (Book book : booklist) {
            System.out.println("Book title：" + book.getTittle() + " Author:" + book.getAuthor() + " Publication date:" + book.getPubYear());
        }
    }

    public static void option_two(List<Book> bookList, List<Book> pickup_booklist) {
//        对应数字2功能 客户捡出的图书存入已捡出书单，且移除书单总目录当中

//        预订书籍--根据输入的书籍名称
        while (true) {
            System.out.println("Please enter the title of the book you want to book, press the number 0 to return to the previous level");
            Scanner sc = new Scanner(System.in);
            String bookname = sc.nextLine();
            if (bookname.equals("0")) {
                break;
            }
            String Flag = "";
            for (Book book : bookList) {
                if (bookname.equals(book.getTittle())) {
                    pickup_booklist.add(book);
                    bookList.remove(book);
                    System.out.println("You have successfully booked" + book.getTittle() + "，The book has been added to your book list");
                    Flag = "true";
                    break;
                }
            }
            if (Flag.equals("true")) {
                return;
            } else {
                System.out.println("Please enter the correct book name, the current book cannot be reserved");
            }
        }
    }

    public static void option_three(List<Book> pickup_booklist) {
//        对应数字3的功能，展示客户已经预订了的书单

        System.out.println("Your exclusive booking list is:");
        for (Book book : pickup_booklist) {
            System.out.println("Title of book:" + book.getTittle() + " Author:" + book.getAuthor() + " Publication date：" + book.getPubYear());
        }
    }

    public static void option_four(List<Book> pickup_booklist, List<Book> boughtbook) {

        /*1.显示客户已预订的书单列表
         * 2.输入想要结账的书籍名称
         * 3.将已结账的书籍添加到已结账的书单列表
         * 4.显示结账成功消息
         * 5.显示结账失败消息*/
        while (true) {
            System.out.println("Welcome to the checkout page, below is your book list list");

            option_three(pickup_booklist);
            System.out.println("Please enter the name of the book you want to check out, press 0 to return to the initial interface");
            Scanner sc = new Scanner(System.in);
            String bookname = sc.nextLine();
            String Flag = "";
            if (bookname.equals("0")) {
                break;
            }
            for (Book book : pickup_booklist) {
                if (bookname.equals(book.getTittle())) {
                    System.out.println("You have successfully" + book.getTittle() + "Add to purchased list");
                    boughtbook.add(book);
                    pickup_booklist.remove(book);
                    System.out.println("List of books you have successfully ordered");
                    for (Book b : boughtbook) {
                        System.out.println(b.getTittle());
                    }
                    Flag = "true";
                    break;
                }
            }
            if (Flag.equals("true")) {
                return;
            } else {
                System.out.println("Sorry, this book is unavailable, please check for spelling errors, or select the book again");
            }
        }
    }

    public static void option_five(List<Book> booklist, List<Book> boughtbooklist) {
//        对应数字5的功能，还书功能  传递两个参数 boughtbooklist 和 booklist
        /*1. 展示已结账书单界面
         * 2. 输入想要还的书籍名称
         * 3. 将该书从已结账列表中移除，并且添加至booklist中，通知客户还书成功
         * 4. 通知客户失败，请重新检查书籍名称和图书馆*/
        while (true) {
            String Flag = "";
            System.out.println("This is your list of purchased books");

            for (Book book : boughtbooklist) {
                System.out.println(book.getTittle());
            }
            System.out.println("Please enter the name of the book you want to check out, press the number 0 to return to the initial interface");
            Scanner sc = new Scanner(System.in);
            String bookname = sc.nextLine();
            if (bookname.equals("0")) {
                break;
            }
            for (Book book : boughtbooklist) {
                if (bookname.equals(book.getTittle())) {
                    System.out.println("You have successfully returned the book, welcome to visit next time");
                    Flag = "true";
                    boughtbooklist.remove(book);
                    booklist.add(book);
                    break;
                }
            }
            if (Flag.equals("true")) {
                return;
            } else {
                System.out.println("Please check if the book name you entered is correct or if it belongs to the library");
            }
        }
    }

    public static void option_hundred(User user){
        System.out.println("Your personal information is as follows");
        System.out.println("Name："+user.getName());
        System.out.println("TEL："+ user.getPhone_num());
        System.out.println("E-mail：" + user.getEmail());
    }

    public static void login_system(List<User> userlist,List<Book> booklist, List<Movie> movielist) {

        while (true){
            System.out.println("Welcome to Bibllioteca Library, please enter your username and password for login verification");
            System.out.println("Please enter your username:");
            Scanner sc = new Scanner(System.in);
            String account = sc.nextLine();
            System.out.println("please enter your password:");
            Scanner sc1 = new Scanner(System.in);
            String password = sc1.nextLine();
            String Flag = "";
//        进行用户名密码匹配验证
//        1. 循环查找是否存在用户账号
            for(User user: userlist){
                if (account.equals(user.getAccount())){
//                如果账号存在，则继续进行密码匹配，否则将报错，用户名不存在请重新输入
//                    进行密码匹配
                    Flag = "true";
                    if(user.getPassword().equals(password)){
//                        如果账号和密码匹配成功，则成功登陆，并显示成功信息
                        System.out.println("Dear"+user.getName()+"Hello, you have successfully logged in the library online system");
//                        此时将执行图书馆管理界面
//                        这里将进行登录后的功能
                        // TODO: 2020/8/5

                        run(booklist,user,movielist);
                    }else {
//                        密码输入错误的话 将重新输入用户名和密码
                        System.out.println("The username and password do not match, please re-enter the username and password");
                    }
                }
            }
//            账号不存在，重新输入
            if(Flag.equals("true")){
            }else {
                System.out.println("The username you entered does not exist, please re-enter the correct username");
            }
        }

    }
}
