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
            System.out.println("请输入数字进行操作，如需重新查看数字功能请按9");
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
                System.out.println("请选择一个有效的选项！");
            }
        }
    }

    public static void show_info() {
        System.out.println("===============================");
        System.out.println("欢迎来到Biblioteca线上图书馆");
        System.out.println("这是一个选项清单");
        System.out.println("如果选1，则获得书单信息");
        System.out.println("如果选2，则开始预订书籍");
        System.out.println("如果选3，则显示已预订书籍名单");
        System.out.println("如果选4，进入结账界面");
        System.out.println("如果选5，还书界面");
        System.out.println("如果输入100，显示您的个人信息");
        System.out.println("如果选0，则退出");
    }

    public static void option_one(List<Book> booklist) {
//        对应数字1功能  展示所有书籍的信息

        System.out.println("全部书籍清单为：");
        for (Book book : booklist) {
            System.out.println("书籍名称：" + book.getTittle() + " 作者：" + book.getAuthor() + " 出版日期：" + book.getPubYear());
        }
    }

    public static void option_two(List<Book> bookList, List<Book> pickup_booklist) {
//        对应数字2功能 客户捡出的图书存入已捡出书单，且移除书单总目录当中

//        预订书籍--根据输入的书籍名称
        while (true) {
            System.out.println("请输入您想预订的书名，按数字0返回上一层");
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
                    System.out.println("您已成功预定" + book.getTittle() + "，该书已经加入您的预定书单");
                    Flag = "true";
                    break;
                }
            }
            if (Flag.equals("true")) {
                return;
            } else {
                System.out.println("请输入正确的书籍名称，当前书籍不可预订");
            }
        }
    }

    public static void option_three(List<Book> pickup_booklist) {
//        对应数字3的功能，展示客户已经预订了的书单

        System.out.println("您的专属预订书单为：");
        for (Book book : pickup_booklist) {
            System.out.println("书籍名称：" + book.getTittle() + " 作者：" + book.getAuthor() + " 出版日期：" + book.getPubYear());
        }
    }

    public static void option_four(List<Book> pickup_booklist, List<Book> boughtbook) {

        /*1.显示客户已预订的书单列表
         * 2.输入想要结账的书籍名称
         * 3.将已结账的书籍添加到已结账的书单列表
         * 4.显示结账成功消息
         * 5.显示结账失败消息*/
        while (true) {
            System.out.println("欢迎来到结账页面，下面是您的预订书籍列表清单");

            option_three(pickup_booklist);
            System.out.println("请输入您想结账的书籍名称,按0返回初始界面");
            Scanner sc = new Scanner(System.in);
            String bookname = sc.nextLine();
            String Flag = "";
            if (bookname.equals("0")) {
                break;
            }
            for (Book book : pickup_booklist) {
                if (bookname.equals(book.getTittle())) {
                    System.out.println("您已经成功将" + book.getTittle() + "添加至已购买列表");
                    boughtbook.add(book);
                    pickup_booklist.remove(book);
                    System.out.println("您已经成功订购的图书列表");
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
                System.out.println("抱歉，这本书不可用，请检查是否存在拼写错误，或者重新选择书籍");
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
            System.out.println("这是您的已购买书籍清单");

            for (Book book : boughtbooklist) {
                System.out.println(book.getTittle());
            }
            System.out.println("请输入想要结账的书籍名称,按数字0返回初始界面");
            Scanner sc = new Scanner(System.in);
            String bookname = sc.nextLine();
            if (bookname.equals("0")) {
                break;
            }
            for (Book book : boughtbooklist) {
                if (bookname.equals(book.getTittle())) {
                    System.out.println("您已经成功将该图书归还，欢迎下次光临");
                    Flag = "true";
                    boughtbooklist.remove(book);
                    booklist.add(book);
                    break;
                }
            }
            if (Flag.equals("true")) {
                return;
            } else {
                System.out.println("请检查您输入的书籍名称是否正确，或者是否属于该图书馆");
            }
        }
    }

    public static void option_hundred(User user){
        System.out.println("您的个人信息如下");
        System.out.println("姓名："+user.getName());
        System.out.println("电话："+ user.getPhone_num());
        System.out.println("电子邮箱：" + user.getEmail());
    }

    public static void login_system(List<User> userlist,List<Book> booklist, List<Movie> movielist) {

        while (true){
            System.out.println("欢迎来到Bibllioteca图书馆，请输入您的用户名密码名进行登录验证");
            System.out.println("请输入您的用户名：");
            Scanner sc = new Scanner(System.in);
            String account = sc.nextLine();
            System.out.println("请输入您的密码：");
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
                        System.out.println("尊敬的"+user.getName()+"您好，您已经成功登陆图书馆在线系统");
//                        此时将执行图书馆管理界面
//                        这里将进行登录后的功能
                        // TODO: 2020/8/5

                        run(booklist,user,movielist);
                    }else {
//                        密码输入错误的话 将重新输入用户名和密码
                        System.out.println("用户名与密码不匹配，请重新输入用户名和密码");
                    }
                }
            }
//            账号不存在，重新输入
            if(Flag.equals("true")){
            }else {
                System.out.println("您输入的用户名不存在，请重新输入正确的用户名");
            }
        }

    }
}
